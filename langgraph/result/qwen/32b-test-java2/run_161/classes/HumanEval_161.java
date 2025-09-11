import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_161 {

    // Source Code
    static class HumanEval_161_Source {
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
        "Hello World",
        "Python3.8",
        "1234567890",
        "!@#$%^&*()",
        "aBcDeFgHiJ",
        "ABCdef123",
        "No Change 123",
        "SWAPcase",
        "",
        " ",
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_161_Source().solve(testCases[0]), 
                     new HumanEval_161_Transformed().transformString(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_161_Source().solve(testCases[1]), 
                     new HumanEval_161_Transformed().transformString(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_161_Source().solve(testCases[2]), 
                     new HumanEval_161_Transformed().transformString(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_161_Source().solve(testCases[3]), 
                     new HumanEval_161_Transformed().transformString(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_161_Source().solve(testCases[4]), 
                     new HumanEval_161_Transformed().transformString(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_161_Source().solve(testCases[5]), 
                     new HumanEval_161_Transformed().transformString(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_161_Source().solve(testCases[6]), 
                     new HumanEval_161_Transformed().transformString(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_161_Source().solve(testCases[7]), 
                     new HumanEval_161_Transformed().transformString(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_161_Source().solve(testCases[8]), 
                     new HumanEval_161_Transformed().transformString(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_161_Source().solve(testCases[9]), 
                     new HumanEval_161_Transformed().transformString(testCases[9]));
    }
}