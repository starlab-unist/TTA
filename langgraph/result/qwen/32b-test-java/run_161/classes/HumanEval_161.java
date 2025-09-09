import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_161 {

    // Source Code
    static class HumanEval_161 {
        public String solve(String s) {
            int flg = 0;
            int idx = 0;
            char[] newStr = s.toCharArray();
            for (char i : s.toCharArray()) {
                if (Character.isLetter(i)) {
                    newStr[idx] = Character.isUpperCase(i) ? Character.toLowerCase(i) : Character.toUpperCase(i);
                    flg = 1;
                }
                idx++;
            }
            StringBuilder result = new StringBuilder(new String(newStr));
            if (flg == 0) {
                return result.reverse().toString();
            }
            return result.toString();
        }
    }

    // Transformed Code
    static class HumanEval_161_Transformed {
        public String transformString(String inputString) {
            boolean modified = false;
            int position = 0;
            char[] resultChars = inputString.toCharArray();
            for (char c : inputString.toCharArray()) {
                if (Character.isLetter(c)) {
                    resultChars[position] = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
                    modified = true;
                }
                position++;
            }
            String transformedString = new String(resultChars);
            if (!modified) {
                return new StringBuilder(transformedString).reverse().toString();
            }
            return transformedString;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "Hello World",  // Mixed case letters, spaces
        "Python3.8",    // Letters and numbers
        "1234567890",   // Only digits
        "!@#$%^&*()",   // Special characters only
        "aBcDeFgHiJ",   // Alternating case letters
        "ABCdef123",    // Mixed case with numbers
        "No Change 123",// Letters and numbers, spaces
        "SWAPcase",     // All letters
        "",             // Empty string
        " ",            // Single space
        "UPPERlower",   // Lower and upper case consecutive
        "mixedCASE123", // Mixed case with numbers
        "SINGLELETTER", // All uppercase
        "alllower",     // All lowercase
        "1234567890!@#",// Digits and special characters
        "ALLUPPER"      // All uppercase letters
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_161().solve(testCases[0]), new HumanEval_161_Transformed().transformString(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_161().solve(testCases[1]), new HumanEval_161_Transformed().transformString(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_161().solve(testCases[2]), new HumanEval_161_Transformed().transformString(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_161().solve(testCases[3]), new HumanEval_161_Transformed().transformString(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_161().solve(testCases[4]), new HumanEval_161_Transformed().transformString(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_161().solve(testCases[5]), new HumanEval_161_Transformed().transformString(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_161().solve(testCases[6]), new HumanEval_161_Transformed().transformString(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_161().solve(testCases[7]), new HumanEval_161_Transformed().transformString(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_161().solve(testCases[8]), new HumanEval_161_Transformed().transformString(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_161().solve(testCases[9]), new HumanEval_161_Transformed().transformString(testCases[9]));
    }

    // Additional simple test cases
    @Test
    public void test_10() {
        assertEquals("hELLO wORLD", new HumanEval_161().solve("Hello World"), "Failed on mixed case letters with spaces");
        assertEquals(new HumanEval_161_Transformed().transformString("Hello World"), "hELLO wORLD", "Transformed failed on mixed case letters with spaces");
    }

    @Test
    public void test_11() {
        assertEquals("pYTHON3.8", new HumanEval_161().solve("Python3.8"), "Failed on letters and numbers");
        assertEquals(new HumanEval_161_Transformed().transformString("Python3.8"), "pYTHON3.8", "Transformed failed on letters and numbers");
    }

    @Test
    public void test_12() {
        assertEquals("0987654321", new HumanEval_161().solve("1234567890"), "Failed on only digits");
        assertEquals(new HumanEval_161_Transformed().transformString("1234567890"), "0987654321", "Transformed failed on only digits");
    }

    @Test
    public void test_13() {
        assertEquals(")(*&^%$#@!", new HumanEval_161().solve("!@#$%^&*()"), "Failed on special characters only");
        assertEquals(new HumanEval_161_Transformed().transformString("!@#$%^&*()"), ")(*&^%$#@!", "Transformed failed on special characters only");
    }

    @Test
    public void test_14() {
        assertEquals("AbCdEfGhIj", new HumanEval_161().solve("aBcDeFgHiJ"), "Failed on alternating case letters");
        assertEquals(new HumanEval_161_Transformed().transformString("aBcDeFgHiJ"), "AbCdEfGhIj", "Transformed failed on alternating case letters");
    }
}