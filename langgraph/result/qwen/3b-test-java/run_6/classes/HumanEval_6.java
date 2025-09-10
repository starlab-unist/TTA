import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_6 {

    // Source Code
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

    // Transformed Code
    static class TransformedImpl {
        public static List<Integer> analyzeParenthesesDepth(String parenSequence) {
            return Stream.of(parenSequence.split("\\s+"))
                    .map(TransformedImpl::calculateMaxNestingLevel)
                    .collect(Collectors.toList());
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
    private static Stream<Arguments> provideTestCases() {
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

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(String testCase) {
        assertEquals(OriginalImpl.parseNestedParens(testCase), TransformedImpl.analyzeParenthesesDepth(testCase));
    }
}