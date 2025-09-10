import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_61 {

    // Source Code
    static class SourceCode {
        public static boolean correct_bracketing(String brackets) {
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
    static class TransformedCode {
        public static boolean validate_parentheses(String sequence) {
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
    @DisplayName("Compare correct_bracketing and validate_parentheses outputs")
    void correct_bracketing_vs_validate_parentheses(String inputText) {
        assertEquals(
            SourceCode.correct_bracketing(inputText),
            TransformedCode.validate_parentheses(inputText)
        );
    }
}