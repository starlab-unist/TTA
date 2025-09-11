import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_6 {

    // Source Code
    public static List<Integer> parseNestedParens(String parenString) {
        List<Integer> result = new ArrayList<>();

        for (String x : parenString.split(" ")) {
            if (!x.isEmpty()) {
                result.add(parseParenGroup(x));
            }
        }

        return result;
    }

    private static int parseParenGroup(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxDepth = Math.max(depth, maxDepth);
            } else if (c == ')') {
                depth--;
            }
        }

        return maxDepth;
    }

    // Transformed Code
    public static List<Integer> analyze_parentheses_depth(String paren_sequence) {
        List<Integer> result = new ArrayList<>();

        for (String segment : paren_sequence.split("\\s+")) {
            if (!segment.isEmpty()) {
                result.add(calculate_max_nesting_level(segment));
            }
        }

        return result;
    }

    private static int calculate_max_nesting_level(String substring) {
        int current_level = 0;
        int peak_level = 0;

        for (char character : substring.toCharArray()) {
            if (character == '(') {
                current_level += 1;
                peak_level = Math.max(current_level, peak_level);
            } else if (character == ')') {
                current_level -= 1;
            }
        }

        return peak_level;
    }

    // Test Cases
    private static final String[] testCases = {
        "(()) ()",
        "((())) (()) ()",
        "()",
        "((( ))) (( )) ( )",
        "",
        "(()(()))",
        "((()()()))",
        "((())) () ()",
        "(((())))",
        "() () ()"
    };

    @Test
    public void test_0() {
        assertEquals(parseNestedParens(testCases[0]), analyze_parentheses_depth(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(parseNestedParens(testCases[1]), analyze_parentheses_depth(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(parseNestedParens(testCases[2]), analyze_parentheses_depth(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(parseNestedParens(testCases[3]), analyze_parentheses_depth(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(parseNestedParens(testCases[4]), analyze_parentheses_depth(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(parseNestedParens(testCases[5]), analyze_parentheses_depth(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(parseNestedParens(testCases[6]), analyze_parentheses_depth(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(parseNestedParens(testCases[7]), analyze_parentheses_depth(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(parseNestedParens(testCases[8]), analyze_parentheses_depth(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(parseNestedParens(testCases[9]), analyze_parentheses_depth(testCases[9]));
    }
}