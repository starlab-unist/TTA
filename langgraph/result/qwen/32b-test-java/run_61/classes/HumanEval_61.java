import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_61 {

    // Source Code
    static class HumanEval_61_Source {
        public boolean correctBracketing(String brackets) {
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
        public boolean validateParentheses(String sequence) {
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
    private static final String[] testCases = {
        "()",
        "(())",
        "((()))",
        "(()())",
        ")(",
        "(()",
        "())",
        "",
        "((((()))))",
        "(()))(()"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Testing correctBracketing vs validateParentheses")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void correctBracketing_vs_validateParentheses(String input) {
        assertEquals(
            HumanEval_61_Source.correctBracketing(input),
            HumanEval_61_Transformed.validateParentheses(input)
        );
    }
}