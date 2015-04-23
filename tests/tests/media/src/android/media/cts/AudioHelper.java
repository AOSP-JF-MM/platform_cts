/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.media.cts;

import java.nio.ByteBuffer;
import org.junit.Assert;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Looper;

// Used for statistics and loopers in listener tests.
// See AudioRecordTest.java and AudioTrack_ListenerTest.java.
public class AudioHelper {
    public static int frameSizeFromFormat(AudioFormat format) {
        return format.getChannelCount()
                * format.getBytesPerSample(format.getEncoding());
    }

    public static int frameCountFromMsec(int ms, AudioFormat format) {
        return ms * format.getSampleRate() / 1000;
    }

    public static class Statistics {
        public void add(double value) {
            final double absValue = Math.abs(value);
            mSum += value;
            mSumAbs += absValue;
            mMaxAbs = Math.max(mMaxAbs, absValue);
            ++mCount;
        }

        public double getAvg() {
            if (mCount == 0) {
                return 0;
            }
            return mSum / mCount;
        }

        public double getAvgAbs() {
            if (mCount == 0) {
                return 0;
            }
            return mSumAbs / mCount;
        }

        public double getMaxAbs() {
            return mMaxAbs;
        }

        private int mCount = 0;
        private double mSum = 0;
        private double mSumAbs = 0;
        private double mMaxAbs = 0;
    }

    // for listener tests
    // lightweight java.util.concurrent.Future*
    public static class FutureLatch<T>
    {
        private T mValue;
        private boolean mSet;
        public void set(T value)
        {
            synchronized (this) {
                assert !mSet;
                mValue = value;
                mSet = true;
                notify();
            }
        }
        public T get()
        {
            T value;
            synchronized (this) {
                while (!mSet) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        ;
                    }
                }
                value = mValue;
            }
            return value;
        }
    }

    // for listener tests
    // represents a factory for T
    public interface MakesSomething<T>
    {
        T makeSomething();
    }

    // for listener tests
    // used to construct an object in the context of an asynchronous thread with looper
    public static class MakeSomethingAsynchronouslyAndLoop<T>
    {
        private Thread mThread;
        volatile private Looper mLooper;
        private final MakesSomething<T> mWhatToMake;

        public MakeSomethingAsynchronouslyAndLoop(MakesSomething<T> whatToMake)
        {
            assert whatToMake != null;
            mWhatToMake = whatToMake;
        }

        public T make()
        {
            final FutureLatch<T> futureLatch = new FutureLatch<T>();
            mThread = new Thread()
            {
                @Override
                public void run()
                {
                    Looper.prepare();
                    mLooper = Looper.myLooper();
                    T something = mWhatToMake.makeSomething();
                    futureLatch.set(something);
                    Looper.loop();
                }
            };
            mThread.start();
            return futureLatch.get();
        }
        public void join()
        {
            mLooper.quit();
            try {
                mThread.join();
            } catch (InterruptedException e) {
                ;
            }
            // avoid dangling references
            mLooper = null;
            mThread = null;
        }
    }

    public static int outChannelMaskFromInChannelMask(int channelMask) {
        switch (channelMask) {
            case AudioFormat.CHANNEL_IN_MONO:
                return AudioFormat.CHANNEL_OUT_MONO;
            case AudioFormat.CHANNEL_IN_STEREO:
                return AudioFormat.CHANNEL_OUT_STEREO;
            default:
                return AudioFormat.CHANNEL_INVALID;
        }
    }

    /* AudioRecordAudit extends AudioRecord to allow concurrent playback
     * of read content to an AudioTrack.
     * This affects AudioRecord timing.
     */
    public static class AudioRecordAudit extends AudioRecord {
        AudioRecordAudit(int audioSource, int sampleRate, int channelMask,
                int format, int bufferSize) {
            this(audioSource, sampleRate, channelMask, format, bufferSize,
                    AudioManager.STREAM_MUSIC, 500 /*delayMs*/);
        }

        AudioRecordAudit(int audioSource, int sampleRate, int channelMask,
                int format, int bufferSize, int auditStreamType, int delayMs) {
            super(audioSource, sampleRate, channelMask, format, bufferSize);

            if (delayMs >= 0) { // create an AudioTrack
                final int channelOutMask = outChannelMaskFromInChannelMask(channelMask);
                final int bufferOutFrames = sampleRate * delayMs / 1000;
                final int bufferOutSamples = bufferOutFrames
                        * AudioFormat.channelCountFromOutChannelMask(channelOutMask);
                final int bufferOutSize = bufferOutSamples
                        * AudioFormat.getBytesPerSample(format);

                // Caution: delayMs too large results in buffer sizes that cannot be created.
                mTrack = new AudioTrack(auditStreamType, sampleRate, channelOutMask, format,
                        bufferOutSize, AudioTrack.MODE_STREAM);
                mPosition = 0;
                mFinishAtMs = 0;
            }
        }

        @Override
        public int read(byte[] audioData, int offsetInBytes, int sizeInBytes) {
            // for byte array access we verify format is 8 bit PCM (typical use)
            Assert.assertEquals(TAG + ": format mismatch",
                    AudioFormat.ENCODING_PCM_8BIT, getAudioFormat());
            int samples = super.read(audioData, offsetInBytes, sizeInBytes);
            if (mTrack != null) {
                Assert.assertEquals(samples, mTrack.write(audioData, offsetInBytes, samples));
                mPosition += samples / mTrack.getChannelCount();
            }
            return samples;
        }

        @Override
        public int read(short[] audioData, int offsetInShorts, int sizeInShorts) {
            // for short array access we verify format is 16 bit PCM (typical use)
            Assert.assertEquals(TAG + ": format mismatch",
                    AudioFormat.ENCODING_PCM_16BIT, getAudioFormat());
            int samples = super.read(audioData, offsetInShorts, sizeInShorts);
            if (mTrack != null) {
                Assert.assertEquals(samples, mTrack.write(audioData, offsetInShorts, samples));
                mPosition += samples / mTrack.getChannelCount();
            }
            return samples;
        }

        @Override
        public int read(float[] audioData, int offsetInFloats, int sizeInFloats, int readMode) {
            // for float array access we verify format is float PCM (typical use)
            Assert.assertEquals(TAG + ": format mismatch",
                    AudioFormat.ENCODING_PCM_FLOAT, getAudioFormat());
            int samples = super.read(audioData, offsetInFloats, sizeInFloats, readMode);
            if (mTrack != null) {
                Assert.assertEquals(samples, mTrack.write(audioData, offsetInFloats, samples,
                        AudioTrack.WRITE_BLOCKING));
                mPosition += samples / mTrack.getChannelCount();
            }
            return samples;
        }

        @Override
        public int read(ByteBuffer audioBuffer, int sizeInBytes) {
            int bytes = super.read(audioBuffer, sizeInBytes);
            if (mTrack != null) {
                // read does not affect position and limit of the audioBuffer.
                // we make a duplicate to change that for writing to the output AudioTrack
                // which does check position and limit.
                ByteBuffer copy = audioBuffer.duplicate();
                copy.position(0).limit(bytes);  // read places data at the start of the buffer.
                Assert.assertEquals(bytes, mTrack.write(copy, bytes, AudioTrack.WRITE_BLOCKING));
                mPosition += bytes /
                        (mTrack.getChannelCount()
                                * AudioFormat.getBytesPerSample(mTrack.getAudioFormat()));
            }
            return bytes;
        }

        @Override
        public void startRecording() {
            super.startRecording();
            if (mTrack != null) {
                mTrack.play();
            }
        }

        @Override
        public void stop() {
            super.stop();
            if (mTrack != null) {
                if (mPosition > 0) { // stop may be called multiple times.
                    final int remainingFrames = mPosition - mTrack.getPlaybackHeadPosition();
                    mFinishAtMs = System.currentTimeMillis()
                            + remainingFrames * 1000 / mTrack.getSampleRate();
                    mPosition = 0;
                }
                mTrack.stop(); // allows remaining data to play out
            }
        }

        @Override
        public void release() {
            super.release();
            if (mTrack != null) {
                final long remainingMs = mFinishAtMs - System.currentTimeMillis();
                if (remainingMs > 0) {
                    try {
                        Thread.sleep(remainingMs);
                    } catch (InterruptedException e) {
                        ;
                    }
                }
                mTrack.release();
                mTrack = null;
            }
        }

        public AudioTrack mTrack;
        private final static String TAG = "AudioRecordAudit";
        private int mPosition;
        private long mFinishAtMs;
    }
}