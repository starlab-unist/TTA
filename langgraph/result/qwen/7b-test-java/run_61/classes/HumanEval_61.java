import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_61 {

    // Source Code
    public static boolean correctBracketing(String brackets) {
        int depth = 0;
        for (char b : brackets.toCharArray()) {
            if (b == '(') {
                depth += 1;
            } else {
                depth -= 1;
            }
            if (depth < 0) {
                return false;
            }
        }
        return depth == 0;
    }

    // Transformed Code
    public static boolean validateParentheses(String brackets) {
        int depth = 0;
        int index = 0;
        while (index < brackets.length()) {
            if (brackets.charAt(index) == '(') {
                depth++;
            } else if (brackets.charAt(index) == ')') {
                depth--;
            }
            if (depth < 0) {
                return false;
            }
            index++;
        }
        return depth == 0;
    }

    // Test Cases
    private static final String[] testCases = {
        "()",
        "(())",
        "((()))",
        "(()())",
        ")(",
        "(()",
        "())",
        "",
        "((((()))))",
        "(()))(()"
    };

    @Test
    public void test_0() {
        assertEquals(correctBracketing(testCases[0]), validateParentheses(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(correctBracketing(testCases[1]), validateParentheses(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(correctBracketing(testCases[2]), validateParentheses(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(correctBracketing(testCases[3]), validateParentheses(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(correctBracketing(testCases[4]), validateParentheses(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(correctBracketing(testCases[5]), validateParentheses(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(correctBracketing(testCases[6]), validateParentheses(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(correctBracketing(testCases[7]), validateParentheses(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(correctBracketing(testCases[8]), validateParentheses(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(correctBracketing(testCases[9]), validateParentheses(testCases[9]));
    }
}