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
    public static boolean correct_bracketing(String brackets) {
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
    public static boolean validate_parentheses(String sequence) {
        int balance = 0;
        int index = 0;
        while (index < sequence.length()) {
            if (sequence.charAt(index) == '(') {
                balance += 1;
            } else if (sequence.charAt(index) == ')') {
                balance -= 1;
            }
            if (balance < 0) {
                return false;
            }
            index += 1;
        }
        return balance == 0;
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
        assertEquals(correct_bracketing(testCases[0]), validate_parentheses(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(correct_bracketing(testCases[1]), validate_parentheses(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(correct_bracketing(testCases[2]), validate_parentheses(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(correct_bracketing(testCases[3]), validate_parentheses(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(correct_bracketing(testCases[4]), validate_parentheses(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(correct_bracketing(testCases[5]), validate_parentheses(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(correct_bracketing(testCases[6]), validate_parentheses(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(correct_bracketing(testCases[7]), validate_parentheses(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(correct_bracketing(testCases[8]), validate_parentheses(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(correct_bracketing(testCases[9]), validate_parentheses(testCases[9]));
    }
}