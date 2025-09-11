import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Test Class
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HumanEval_6 {

    // Original Implementation
    static class OriginalImpl {
        public static List<Integer> parseNestedParens(String parenString) {
            List<Integer> result = new ArrayList<>();

            for (String group : parenString.split(" ")) {
                int maxDepth = parseParenGroup(group);
                result.add(maxDepth);
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

    // Transformed Implementation
    static class TransformedImpl {
        public static List<Integer> analyzeParenthesesDepth(String parenSequence) {
            return Arrays.stream(parenSequence.split("\\s+"))
                    .map(TransformedImpl::calculateMaxNestingLevel)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
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

    // Provide test cases as a stream of arguments
    private Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("(()) ()"),
            Arguments.of("((())) (()) ()"),
            Arguments.of("()"),
            Arguments.of("((( ))) (( )) ( )"),
            Arguments.of(""),
            Arguments.of("(()(()))"),
            Arguments.of("((()()()))"),
            Arguments.of("((())) () ()"),
            Arguments.of("(((())))"),
            Arguments.of("() () ()")
        );
    }

    // Parameterized test method
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testParseNestedParens(String input) {
        assertEquals(OriginalImpl.parseNestedParens(input), TransformedImpl.analyzeParenthesesDepth(input));
    }
}