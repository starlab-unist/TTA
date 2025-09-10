import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_61 {

    // Source Code
    static class HumanEval_61_Source {
        public static boolean correctBracketing(String brackets) {
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
    }

    // Transformed Code
    static class HumanEval_61_Transformed {
        public static boolean validateParentheses(String sequence) {
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
    }

    // Test Cases
    private static final String[][] testCases = {
        {"()"},
        {"(())"},
        {"((()))"},
        {"(()())"},
        {")("},
        {"(()"},
        {"())"},
        {""},
        {"((((()))))"},
        {"(()))(()"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test equivalence of correctBracketing and validateParentheses")
    void testCorrectBracketing_vs_validateParentheses(String inputText) {
        assertEquals(
            HumanEval_61_Source.correctBracketing(inputText),
            HumanEval_61_Transformed.validateParentheses(inputText)
        );
    }
}