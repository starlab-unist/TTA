import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream; // Added import for Stream

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_6 {

    // Source Code
    static class HumanEval_6_Source {
        public static List<Integer> parseNestedParens(String parenString) {
            List<Integer> result = new ArrayList<>();
            
            for (String s : parenString.split(" ")) {
                if (!s.isEmpty()) {
                    result.add(parseParenGroup(s));
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
                } else {
                    depth--;
                }
            }
            
            return maxDepth;
        }
    }

    // Transformed Code
    static class HumanEval_6_Transformed {
        public List<Integer> analyzeParenthesesDepth(String parenSequence) {
            List<Integer> result = new ArrayList<>();
            
            for (String segment : parenSequence.split("\\s+")) {
                if (!segment.isEmpty()) {
                    result.add(calculateMaxNestingLevel(segment));
                }
            }
            
            return result;
        }

        private int calculateMaxNestingLevel(String substring) {
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
        "(()) ()",       // Expected: [2, 1]
        "((())) (()) ()",// Expected: [3, 2, 1]
        "()",            // Expected: [1]
        "((( ))) (( )) ( )", // Expected: [3, 2, 1]
        "",              // Expected: []
        "(()(()))",      // Expected: [3]
        "((()()()))",    // Expected: [3]
        "((())) () ()",  // Expected: [3, 1, 1]
        "(((())))",      // Expected: [4]
        "() () ()"       // Expected: [1, 1, 1]
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing parseNestedParens vs analyzeParenthesesDepth equivalence")
    void testEquivalence(String inputText) {
        assertEquals(
            HumanEval_6_Source.parseNestedParens(inputText),
            new HumanEval_6_Transformed().analyzeParenthesesDepth(inputText)
        );
    }
}