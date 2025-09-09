import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HumanEval_1 {

    // Source Code
    static class HumanEval_1_Source {
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
    }

    // Transformed Code
    static class HumanEval_1_Transformed {
        public static List<String> extractBalancedParentheses(String inputSequence) {
            List<String> outputGroups = new ArrayList<>();
            StringBuilder tempGroup = new StringBuilder();
            int nestingLevel = 0;

            int index = 0;
            while (index < inputSequence.length()) {
                char character = inputSequence.charAt(index);
                if (character == '(') {
                    nestingLevel++;
                    tempGroup.append(character);
                } else if (character == ')') {
                    nestingLevel--;
                    tempGroup.append(character);

                    if (nestingLevel == 0) {
                        outputGroups.add(tempGroup.toString());
                        tempGroup.setLength(0); // Reset tempGroup
                    }
                }

                index++;
            }

            return outputGroups;
        }
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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Test separateParenGroups vs extractBalancedParentheses")
    @ParameterizedTest(name = "{index} => input={0}")
    @MethodSource("provideTestCases")
    void testSeparateParenGroups_vs_extractBalancedParentheses(String input) {
        assertEquals(
            HumanEval_1_Source.separateParenGroups(input),
            HumanEval_1_Transformed.extractBalancedParentheses(input)
        );
    }
}