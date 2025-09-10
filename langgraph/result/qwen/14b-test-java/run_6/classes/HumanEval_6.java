import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_6 {

    // Source Code
    static class SourceCode {
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
    }

    // Transformed Code
    static class TransformedCode {
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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void parseNestedParens_vs_analyze_parentheses_depth(String inputText) {
        assertEquals(
            SourceCode.parseNestedParens(inputText),
            TransformedCode.analyze_parentheses_depth(inputText)
        );
    }
}