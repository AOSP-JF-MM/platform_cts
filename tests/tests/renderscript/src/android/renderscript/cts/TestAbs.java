/*
 * Copyright (C) 2014 The Android Open Source Project
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

// Don't edit this file!  It is auto-generated by frameworks/rs/api/gen_runtime.

package android.renderscript.cts;

import android.renderscript.Allocation;
import android.renderscript.RSRuntimeException;
import android.renderscript.Element;

public class TestAbs extends RSBaseCompute {

    private ScriptC_TestAbs script;
    private ScriptC_TestAbsRelaxed scriptRelaxed;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        script = new ScriptC_TestAbs(mRS);
        scriptRelaxed = new ScriptC_TestAbsRelaxed(mRS);
    }

    public class ArgumentsCharUchar {
        public byte inN;
        public byte out;
    }

    private void checkAbsCharUchar() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_8, 1, 0x79257810f7393e9el, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_8, 1), INPUTSIZE);
            script.forEach_testAbsCharUchar(inN, out);
            verifyResultsAbsCharUchar(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsCharUchar: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_8, 1), INPUTSIZE);
            scriptRelaxed.forEach_testAbsCharUchar(inN, out);
            verifyResultsAbsCharUchar(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsCharUchar: " + e.toString());
        }
    }

    private void verifyResultsAbsCharUchar(Allocation inN, Allocation out, boolean relaxed) {
        byte[] arrayInN = new byte[INPUTSIZE * 1];
        inN.copyTo(arrayInN);
        byte[] arrayOut = new byte[INPUTSIZE * 1];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 1 ; j++) {
                // Extract the inputs.
                ArgumentsCharUchar args = new ArgumentsCharUchar();
                args.inN = arrayInN[i];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 1 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 1 + j]));
                    if (args.out != arrayOut[i * 1 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsCharUchar" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    private void checkAbsChar2Uchar2() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_8, 2, 0xff611dd40e5e4074l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_8, 2), INPUTSIZE);
            script.forEach_testAbsChar2Uchar2(inN, out);
            verifyResultsAbsChar2Uchar2(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsChar2Uchar2: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_8, 2), INPUTSIZE);
            scriptRelaxed.forEach_testAbsChar2Uchar2(inN, out);
            verifyResultsAbsChar2Uchar2(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsChar2Uchar2: " + e.toString());
        }
    }

    private void verifyResultsAbsChar2Uchar2(Allocation inN, Allocation out, boolean relaxed) {
        byte[] arrayInN = new byte[INPUTSIZE * 2];
        inN.copyTo(arrayInN);
        byte[] arrayOut = new byte[INPUTSIZE * 2];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 2 ; j++) {
                // Extract the inputs.
                ArgumentsCharUchar args = new ArgumentsCharUchar();
                args.inN = arrayInN[i * 2 + j];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 2 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 2 + j]));
                    if (args.out != arrayOut[i * 2 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsChar2Uchar2" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    private void checkAbsChar3Uchar3() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_8, 3, 0xff62e6ef04796152l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_8, 3), INPUTSIZE);
            script.forEach_testAbsChar3Uchar3(inN, out);
            verifyResultsAbsChar3Uchar3(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsChar3Uchar3: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_8, 3), INPUTSIZE);
            scriptRelaxed.forEach_testAbsChar3Uchar3(inN, out);
            verifyResultsAbsChar3Uchar3(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsChar3Uchar3: " + e.toString());
        }
    }

    private void verifyResultsAbsChar3Uchar3(Allocation inN, Allocation out, boolean relaxed) {
        byte[] arrayInN = new byte[INPUTSIZE * 4];
        inN.copyTo(arrayInN);
        byte[] arrayOut = new byte[INPUTSIZE * 4];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 3 ; j++) {
                // Extract the inputs.
                ArgumentsCharUchar args = new ArgumentsCharUchar();
                args.inN = arrayInN[i * 4 + j];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 4 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 4 + j]));
                    if (args.out != arrayOut[i * 4 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsChar3Uchar3" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    private void checkAbsChar4Uchar4() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_8, 4, 0xff64b009fa948230l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_8, 4), INPUTSIZE);
            script.forEach_testAbsChar4Uchar4(inN, out);
            verifyResultsAbsChar4Uchar4(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsChar4Uchar4: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_8, 4), INPUTSIZE);
            scriptRelaxed.forEach_testAbsChar4Uchar4(inN, out);
            verifyResultsAbsChar4Uchar4(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsChar4Uchar4: " + e.toString());
        }
    }

    private void verifyResultsAbsChar4Uchar4(Allocation inN, Allocation out, boolean relaxed) {
        byte[] arrayInN = new byte[INPUTSIZE * 4];
        inN.copyTo(arrayInN);
        byte[] arrayOut = new byte[INPUTSIZE * 4];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 4 ; j++) {
                // Extract the inputs.
                ArgumentsCharUchar args = new ArgumentsCharUchar();
                args.inN = arrayInN[i * 4 + j];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 4 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 4 + j]));
                    if (args.out != arrayOut[i * 4 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsChar4Uchar4" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    public class ArgumentsShortUshort {
        public short inN;
        public short out;
    }

    private void checkAbsShortUshort() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_16, 1, 0xfab837da0648194l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_16, 1), INPUTSIZE);
            script.forEach_testAbsShortUshort(inN, out);
            verifyResultsAbsShortUshort(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsShortUshort: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_16, 1), INPUTSIZE);
            scriptRelaxed.forEach_testAbsShortUshort(inN, out);
            verifyResultsAbsShortUshort(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsShortUshort: " + e.toString());
        }
    }

    private void verifyResultsAbsShortUshort(Allocation inN, Allocation out, boolean relaxed) {
        short[] arrayInN = new short[INPUTSIZE * 1];
        inN.copyTo(arrayInN);
        short[] arrayOut = new short[INPUTSIZE * 1];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 1 ; j++) {
                // Extract the inputs.
                ArgumentsShortUshort args = new ArgumentsShortUshort();
                args.inN = arrayInN[i];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 1 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 1 + j]));
                    if (args.out != arrayOut[i * 1 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsShortUshort" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    private void checkAbsShort2Ushort2() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_16, 2, 0x231450e16856b936l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_16, 2), INPUTSIZE);
            script.forEach_testAbsShort2Ushort2(inN, out);
            verifyResultsAbsShort2Ushort2(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsShort2Ushort2: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_16, 2), INPUTSIZE);
            scriptRelaxed.forEach_testAbsShort2Ushort2(inN, out);
            verifyResultsAbsShort2Ushort2(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsShort2Ushort2: " + e.toString());
        }
    }

    private void verifyResultsAbsShort2Ushort2(Allocation inN, Allocation out, boolean relaxed) {
        short[] arrayInN = new short[INPUTSIZE * 2];
        inN.copyTo(arrayInN);
        short[] arrayOut = new short[INPUTSIZE * 2];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 2 ; j++) {
                // Extract the inputs.
                ArgumentsShortUshort args = new ArgumentsShortUshort();
                args.inN = arrayInN[i * 2 + j];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 2 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 2 + j]));
                    if (args.out != arrayOut[i * 2 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsShort2Ushort2" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    private void checkAbsShort3Ushort3() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_16, 3, 0x23611868beb24a62l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_16, 3), INPUTSIZE);
            script.forEach_testAbsShort3Ushort3(inN, out);
            verifyResultsAbsShort3Ushort3(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsShort3Ushort3: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_16, 3), INPUTSIZE);
            scriptRelaxed.forEach_testAbsShort3Ushort3(inN, out);
            verifyResultsAbsShort3Ushort3(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsShort3Ushort3: " + e.toString());
        }
    }

    private void verifyResultsAbsShort3Ushort3(Allocation inN, Allocation out, boolean relaxed) {
        short[] arrayInN = new short[INPUTSIZE * 4];
        inN.copyTo(arrayInN);
        short[] arrayOut = new short[INPUTSIZE * 4];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 3 ; j++) {
                // Extract the inputs.
                ArgumentsShortUshort args = new ArgumentsShortUshort();
                args.inN = arrayInN[i * 4 + j];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 4 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 4 + j]));
                    if (args.out != arrayOut[i * 4 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsShort3Ushort3" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    private void checkAbsShort4Ushort4() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_16, 4, 0x23addff0150ddb8el, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_16, 4), INPUTSIZE);
            script.forEach_testAbsShort4Ushort4(inN, out);
            verifyResultsAbsShort4Ushort4(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsShort4Ushort4: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_16, 4), INPUTSIZE);
            scriptRelaxed.forEach_testAbsShort4Ushort4(inN, out);
            verifyResultsAbsShort4Ushort4(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsShort4Ushort4: " + e.toString());
        }
    }

    private void verifyResultsAbsShort4Ushort4(Allocation inN, Allocation out, boolean relaxed) {
        short[] arrayInN = new short[INPUTSIZE * 4];
        inN.copyTo(arrayInN);
        short[] arrayOut = new short[INPUTSIZE * 4];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 4 ; j++) {
                // Extract the inputs.
                ArgumentsShortUshort args = new ArgumentsShortUshort();
                args.inN = arrayInN[i * 4 + j];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 4 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 4 + j]));
                    if (args.out != arrayOut[i * 4 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsShort4Ushort4" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    public class ArgumentsIntUint {
        public int inN;
        public int out;
    }

    private void checkAbsIntUint() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_32, 1, 0x6adb1880ac5b83del, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_32, 1), INPUTSIZE);
            script.forEach_testAbsIntUint(inN, out);
            verifyResultsAbsIntUint(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsIntUint: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_32, 1), INPUTSIZE);
            scriptRelaxed.forEach_testAbsIntUint(inN, out);
            verifyResultsAbsIntUint(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsIntUint: " + e.toString());
        }
    }

    private void verifyResultsAbsIntUint(Allocation inN, Allocation out, boolean relaxed) {
        int[] arrayInN = new int[INPUTSIZE * 1];
        inN.copyTo(arrayInN);
        int[] arrayOut = new int[INPUTSIZE * 1];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 1 ; j++) {
                // Extract the inputs.
                ArgumentsIntUint args = new ArgumentsIntUint();
                args.inN = arrayInN[i];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 1 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 1 + j]));
                    if (args.out != arrayOut[i * 1 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsIntUint" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    private void checkAbsInt2Uint2() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_32, 2, 0xc8728053938616f2l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_32, 2), INPUTSIZE);
            script.forEach_testAbsInt2Uint2(inN, out);
            verifyResultsAbsInt2Uint2(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsInt2Uint2: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_32, 2), INPUTSIZE);
            scriptRelaxed.forEach_testAbsInt2Uint2(inN, out);
            verifyResultsAbsInt2Uint2(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsInt2Uint2: " + e.toString());
        }
    }

    private void verifyResultsAbsInt2Uint2(Allocation inN, Allocation out, boolean relaxed) {
        int[] arrayInN = new int[INPUTSIZE * 2];
        inN.copyTo(arrayInN);
        int[] arrayOut = new int[INPUTSIZE * 2];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 2 ; j++) {
                // Extract the inputs.
                ArgumentsIntUint args = new ArgumentsIntUint();
                args.inN = arrayInN[i * 2 + j];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 2 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 2 + j]));
                    if (args.out != arrayOut[i * 2 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsInt2Uint2" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    private void checkAbsInt3Uint3() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_32, 3, 0xc8728af4f28ddbe6l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_32, 3), INPUTSIZE);
            script.forEach_testAbsInt3Uint3(inN, out);
            verifyResultsAbsInt3Uint3(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsInt3Uint3: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_32, 3), INPUTSIZE);
            scriptRelaxed.forEach_testAbsInt3Uint3(inN, out);
            verifyResultsAbsInt3Uint3(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsInt3Uint3: " + e.toString());
        }
    }

    private void verifyResultsAbsInt3Uint3(Allocation inN, Allocation out, boolean relaxed) {
        int[] arrayInN = new int[INPUTSIZE * 4];
        inN.copyTo(arrayInN);
        int[] arrayOut = new int[INPUTSIZE * 4];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 3 ; j++) {
                // Extract the inputs.
                ArgumentsIntUint args = new ArgumentsIntUint();
                args.inN = arrayInN[i * 4 + j];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 4 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 4 + j]));
                    if (args.out != arrayOut[i * 4 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsInt3Uint3" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    private void checkAbsInt4Uint4() {
        Allocation inN = createRandomAllocation(mRS, Element.DataType.SIGNED_32, 4, 0xc87295965195a0dal, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_32, 4), INPUTSIZE);
            script.forEach_testAbsInt4Uint4(inN, out);
            verifyResultsAbsInt4Uint4(inN, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsInt4Uint4: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.UNSIGNED_32, 4), INPUTSIZE);
            scriptRelaxed.forEach_testAbsInt4Uint4(inN, out);
            verifyResultsAbsInt4Uint4(inN, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testAbsInt4Uint4: " + e.toString());
        }
    }

    private void verifyResultsAbsInt4Uint4(Allocation inN, Allocation out, boolean relaxed) {
        int[] arrayInN = new int[INPUTSIZE * 4];
        inN.copyTo(arrayInN);
        int[] arrayOut = new int[INPUTSIZE * 4];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 4 ; j++) {
                // Extract the inputs.
                ArgumentsIntUint args = new ArgumentsIntUint();
                args.inN = arrayInN[i * 4 + j];
                // Figure out what the outputs should have been.
                CoreMathVerifier.computeAbs(args);
                // Validate the outputs.
                boolean valid = true;
                if (args.out != arrayOut[i * 4 + j]) {
                    valid = false;
                }
                if (!valid) {
                    StringBuilder message = new StringBuilder();
                    message.append("Input inN: ");
                    message.append(String.format("%d", args.inN));
                    message.append("\n");
                    message.append("Expected output out: ");
                    message.append(String.format("0x%x", args.out));
                    message.append("\n");
                    message.append("Actual   output out: ");
                    message.append(String.format("0x%x", arrayOut[i * 4 + j]));
                    if (args.out != arrayOut[i * 4 + j]) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    assertTrue("Incorrect output for checkAbsInt4Uint4" +
                            (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
                }
            }
        }
    }

    public void testAbs() {
        checkAbsCharUchar();
        checkAbsChar2Uchar2();
        checkAbsChar3Uchar3();
        checkAbsChar4Uchar4();
        checkAbsShortUshort();
        checkAbsShort2Ushort2();
        checkAbsShort3Ushort3();
        checkAbsShort4Ushort4();
        checkAbsIntUint();
        checkAbsInt2Uint2();
        checkAbsInt3Uint3();
        checkAbsInt4Uint4();
    }
}
