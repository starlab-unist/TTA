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
        int idx = 0;
        char[] newStr = s.toCharArray();
        for (char i : s.toCharArray()) {
            if (Character.isLetter(i)) {
                newStr[idx] = Character.isUpperCase(i) ? Character.toLowerCase(i) : Character.toUpperCase(i);
                flg = 1;
            }
            idx++;
        }
        s = "";
        for (char i : newStr) {
            s += i;
        }
        if (flg == 0) {
            return new StringBuilder(s).reverse().toString();
        }
        return s;
    }

    // Transformed Code
    public static String transformString(String inputString) {
        boolean modified = false;
        int position = 0;
        char[] resultChars = inputString.toCharArray();
        for (char ch : inputString.toCharArray()) {
            if (Character.isLetter(ch)) {
                resultChars[position] = Character.isUpperCase(ch) ? Character.toLowerCase(ch) : Character.toUpperCase(ch);
                modified = true;
            }
            position++;
        }
        String transformedString = new String(resultChars);
        if (!modified) {
            return new StringBuilder(inputString).reverse().toString();
        }
        return transformedString;
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
        " "
    };

    @Test
    public void test_0() {
        assertEquals(solve(testCases[0]), transformString(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(solve(testCases[1]), transformString(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(solve(testCases[2]), transformString(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(solve(testCases[3]), transformString(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(solve(testCases[4]), transformString(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(solve(testCases[5]), transformString(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(solve(testCases[6]), transformString(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(solve(testCases[7]), transformString(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(solve(testCases[8]), transformString(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(solve(testCases[9]), transformString(testCases[9]));
    }
}