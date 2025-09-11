import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_1 {

    // Source Code
    public static List<String> separateParenGroups(String parenString) {
        List<String> result = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        int currentDepth = 0;

        for (char c : parenString.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                currentString.append(c);
            } else if (c == ')') {
                currentDepth--;
                currentString.append(c);

                if (currentDepth == 0) {
                    result.add(currentString.toString());
                    currentString.setLength(0);
                }
            }
        }

        return result;
    }

    // Transformed Code
    public static List<String> extractBalancedParentheses(String parenString) {
        List<String> result = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        int currentDepth = 0;

        int index = 0;
        while (index < parenString.length()) {
            char character = parenString.charAt(index);
            if (character == '(') {
                currentDepth++;
                currentString.append(character);
            } else if (character == ')') {
                currentDepth--;
                currentString.append(character);

                if (currentDepth == 0) {
                    result.add(currentString.toString());
                    currentString.setLength(0);
                }
            }

            index++;
        }

        return result;
    }

    // Test Cases
    private static final String[] testCases = {
        "()",
        "(())",
        "((()))",
        "(()())",
        "()(())",
        "(()(()))",
        "",
        "a(b)c(d(e)f)g",
        "(abc)(def)",
        "((a)(b))(c)"
    };

    @Test
    public void test_0() {
        assertEquals(separateParenGroups(testCases[0]), extractBalancedParentheses(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(separateParenGroups(testCases[1]), extractBalancedParentheses(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(separateParenGroups(testCases[2]), extractBalancedParentheses(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(separateParenGroups(testCases[3]), extractBalancedParentheses(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(separateParenGroups(testCases[4]), extractBalancedParentheses(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(separateParenGroups(testCases[5]), extractBalancedParentheses(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(separateParenGroups(testCases[6]), extractBalancedParentheses(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(separateParenGroups(testCases[7]), extractBalancedParentheses(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(separateParenGroups(testCases[8]), extractBalancedParentheses(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(separateParenGroups(testCases[9]), extractBalancedParentheses(testCases[9]));
    }
}