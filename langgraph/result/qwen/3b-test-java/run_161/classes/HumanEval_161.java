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
    public static String solve(String s) {
        int flg = 0;
        StringBuilder newStr = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                newStr.setCharAt(i, Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
                flg = 1;
            }
        }
        s = newStr.toString();
        if (flg == 0) {
            return new StringBuilder(s).reverse().toString(); // Corrected the reverse logic
        }
        return s;
    }

    // Transformed Code
    public static String transformString(String inputString) {
        boolean modified = false;
        char[] resultChars = inputString.toCharArray();
        for (char charAt : inputString.toCharArray()) {
            if (Character.isLetter(charAt)) {
                resultChars[inputString.indexOf(charAt)] = Character.isUpperCase(charAt) ? Character.toLowerCase(charAt) : Character.toUpperCase(charAt);
                modified = true;
            }
        }
        String transformedString = new String(resultChars);
        if (!modified) {
            return new StringBuilder(transformedString).reverse().toString(); // Corrected the reverse logic
        }
        return transformedString;
    }

    // Test Cases
    private static final Object[] testCases = {
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
        assertEquals(solve((String) testCases[0]), transformString((String) testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(solve((String) testCases[1]), transformString((String) testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(solve((String) testCases[2]), transformString((String) testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(solve((String) testCases[3]), transformString((String) testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(solve((String) testCases[4]), transformString((String) testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(solve((String) testCases[5]), transformString((String) testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(solve((String) testCases[6]), transformString((String) testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(solve((String) testCases[7]), transformString((String) testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(solve((String) testCases[8]), transformString((String) testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(solve((String) testCases[9]), transformString((String) testCases[9]));
    }
}