import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_1 {

    // Source Code
    static class SourceCode {
        public static List<String> separateParenGroups(String parenString) {
            List<String> result = new ArrayList<>();
            StringBuilder currentString = new StringBuilder();
            int currentDepth = 0;

            for (char c : parenString.toCharArray()) {
                if (c == '(') {
                    currentDepth += 1;
                    currentString.append(c);
                } else if (c == ')') {
                    currentDepth -= 1;
                    currentString.append(c);

                    if (currentDepth == 0) {
                        result.add(currentString.toString());
                        currentString.setLength(0); // Clear the StringBuilder
                    }
                }
            }

            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<String> extractBalancedParentheses(String inputSequence) {
            List<String> outputGroups = new ArrayList<>();
            List<Character> tempGroup = new ArrayList<>();
            int nestingLevel = 0;

            int index = 0;
            while (index < inputSequence.length()) {
                char character = inputSequence.charAt(index);
                if (character == '(') {
                    nestingLevel += 1;
                    tempGroup.add(character);
                } else if (character == ')') {
                    nestingLevel -= 1;
                    tempGroup.add(character);

                    if (nestingLevel == 0) {
                        StringBuilder sb = new StringBuilder();
                        for (char c : tempGroup) {
                            sb.append(c);
                        }
                        outputGroups.add(sb.toString());
                        tempGroup.clear();
                    }
                }

                index += 1;
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

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if separateParenGroups and extractBalancedParentheses produce the same output for the same inputs.")
    void separateParenGroups_vs_extractBalancedParentheses(String inputText) {
        assertEquals(
            SourceCode.separateParenGroups(inputText),
            TransformedCode.extractBalancedParentheses(inputText)
        );
    }
}