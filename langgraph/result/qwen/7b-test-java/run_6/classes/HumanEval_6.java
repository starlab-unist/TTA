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
    static class HumanEval_6_Source {
        public static List<Integer> parseNestedParens(String parenString) {
            List<Integer> result = new ArrayList<>();
            String[] groups = parenString.split(" ");

            for (String group : groups) {
                if (!group.isEmpty()) {
                    int maxDepth = 0;
                    int currentDepth = 0;
                    for (char c : group.toCharArray()) {
                        if (c == '(') {
                            currentDepth++;
                            maxDepth = Math.max(maxDepth, currentDepth);
                        } else if (c == ')') {
                            currentDepth--;
                        }
                    }
                    result.add(maxDepth);
                }
            }

            return result;
        }
    }

    // Transformed Code
    static class HumanEval_6_Transformed {
        public static List<Integer> analyzeParenthesesDepth(String parenSequence) {
            String[] segments = parenSequence.trim().split("\\s+");
            List<Integer> result = new ArrayList<>();

            for (String segment : segments) {
                result.add(calculateMaxNestingLevel(segment));
            }

            return result;
        }

        private static int calculateMaxNestingLevel(String substring) {
            int currentLevel = 0;
            int peakLevel = 0;
            for (char character : substring.toCharArray()) {
                if (character == '(') {
                    currentLevel++;
                    peakLevel = Math.max(currentLevel, peakLevel);
                } else if (character == ')') {
                    currentLevel--;
                }
            }

            return peakLevel;
        }
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
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[0]), HumanEval_6_Transformed.analyzeParenthesesDepth(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[1]), HumanEval_6_Transformed.analyzeParenthesesDepth(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[2]), HumanEval_6_Transformed.analyzeParenthesesDepth(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[3]), HumanEval_6_Transformed.analyzeParenthesesDepth(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[4]), HumanEval_6_Transformed.analyzeParenthesesDepth(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[5]), HumanEval_6_Transformed.analyzeParenthesesDepth(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[6]), HumanEval_6_Transformed.analyzeParenthesesDepth(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[7]), HumanEval_6_Transformed.analyzeParenthesesDepth(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[8]), HumanEval_6_Transformed.analyzeParenthesesDepth(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_6_Source.parseNestedParens(testCases[9]), HumanEval_6_Transformed.analyzeParenthesesDepth(testCases[9]));
    }
}