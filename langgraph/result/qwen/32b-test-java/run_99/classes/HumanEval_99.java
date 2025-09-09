import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_99 {

    // Source Code
    static class SourceCode {
        public static int closestInteger(String value) {
            if (value.contains(".")) {
                // Remove trailing zeros
                while (value.endsWith("0")) {
                    value = value.substring(0, value.length() - 1);
                }
            }

            double num = Double.parseDouble(value);
            int res;
            if (value.endsWith(".5")) {
                if (num > 0) {
                    res = (int) Math.ceil(num);
                } else {
                    res = (int) Math.floor(num);
                }
            } else if (!value.isEmpty()) {
                res = (int) Math.round(num);
            } else {
                res = 0;
            }

            return res;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int nearestWholeNumber(String inputValue) {
            if (inputValue.contains(".")) {
                // strip trailing zeros
                while (inputValue.endsWith("0")) {
                    inputValue = inputValue.substring(0, inputValue.length() - 1);
                }
            }

            double number = Double.parseDouble(inputValue);
            int result;
            if (inputValue.endsWith(".5")) {
                result = number > 0 ? (int) Math.ceil(number) : (int) Math.floor(number);
            } else if (!inputValue.isEmpty()) {
                result = (int) Math.round(number);
            } else {
                result = 0;
            }

            return result;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "4.5",   // Rounds up to 5
        "-2.5",  // Rounds down to -2
        "3.7",   // Rounds up to 4
        "-1.2",  // Rounds down to -1
        "0.0",   // Rounds to 0
        "5.000", // Strips trailing zeros and rounds to 5
        "6.99",  // Rounds up to 7
        "-3.01", // Rounds down to -3
        ".5",    // Rounds up to 1
        "-.5",   // Rounds down to -1
        "2",     // Integer input, remains 2
        "-4",    // Negative integer input, remains -4
        "0.49",  // Rounds down to 0
        "-0.49", // Rounds up to 0
        "3.50"   // Strips trailing zeros and rounds up to 4
    };

    @Test
    public void test_0() {
        assertEquals(SourceCode.closestInteger(testCases[0]), TransformedCode.nearestWholeNumber(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.closestInteger(testCases[1]), TransformedCode.nearestWholeNumber(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.closestInteger(testCases[2]), TransformedCode.nearestWholeNumber(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.closestInteger(testCases[3]), TransformedCode.nearestWholeNumber(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.closestInteger(testCases[4]), TransformedCode.nearestWholeNumber(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.closestInteger(testCases[5]), TransformedCode.nearestWholeNumber(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.closestInteger(testCases[6]), TransformedCode.nearestWholeNumber(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.closestInteger(testCases[7]), TransformedCode.nearestWholeNumber(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.closestInteger(testCases[8]), TransformedCode.nearestWholeNumber(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.closestInteger(testCases[9]), TransformedCode.nearestWholeNumber(testCases[9]));
    }

    @Test
    public void test_10() {
        assertEquals(SourceCode.closestInteger(testCases[10]), TransformedCode.nearestWholeNumber(testCases[10]));
    }

    @Test
    public void test_11() {
        assertEquals(SourceCode.closestInteger(testCases[11]), TransformedCode.nearestWholeNumber(testCases[11]));
    }

    @Test
    public void test_12() {
        assertEquals(SourceCode.closestInteger(testCases[12]), TransformedCode.nearestWholeNumber(testCases[12]));
    }

    @Test
    public void test_13() {
        assertEquals(SourceCode.closestInteger(testCases[13]), TransformedCode.nearestWholeNumber(testCases[13]));
    }

    @Test
    public void test_14() {
        assertEquals(SourceCode.closestInteger(testCases[14]), TransformedCode.nearestWholeNumber(testCases[14]));
    }
}