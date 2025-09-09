import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_119 {

    // Source Code
    static class HumanEval_119_Source {
        public String matchParens(String[] lst) {
            String S1 = lst[0] + lst[1];
            String S2 = lst[1] + lst[0];
            return (check(S1) || check(S2)) ? "Yes" : "No";
        }

        private boolean check(String s) {
            int val = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    val++;
                } else {
                    val--;
                }
                if (val < 0) {
                    return false;
                }
            }
            return val == 0;
        }
    }

    // Transformed Code
    static class HumanEval_119_Transformed {
        public String validateParenthesesCombinations(String[] strings) {
            boolean isBalanced(String expression) {
                int balance = 0;
                for (char ch : expression.toCharArray()) {
                    if (ch == '(') {
                        balance++;
                    } else if (ch == ')') {
                        balance--;
                    }
                    if (balance < 0) {
                        return false;
                    }
                }
                return balance == 0;
            }

            String combinedFirstSecond = strings[0] + strings[1];
            String combinedSecondFirst = strings[1] + strings[0];

            return isBalanced(combinedFirstSecond) || isBalanced(combinedSecondFirst) ? "Yes" : "No";
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new String[]{"()", "()"}, "Yes"},
        {new String[]{"(", ")"}, "Yes"},
        {new String[]{"(()", "())"}, "Yes"},
        {new String[]{"(", "("}, "No"},
        {new String[]{"))", "(("}, "No"},
        {new String[]{"(())", "()"}, "Yes"},
        {new String[]{"((()))", ""}, "Yes"},
        {new String[]{"", ""}, "Yes"},
        {new String[]{"()(", ")"}, "Yes"},
        {new String[]{"(()", "()())"}, "Yes"},
        {new String[]{"(())", "((()))"}, "No"},
        {new String[]{"(()", ")()("}, "No"},
        {new String[]{"(()))", "(())"}, "No"},
        {new String[]{"()", "(()"}, "No"},
        {new String[]{"((", "))"}, "Yes"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> Arguments.of((String[]) args[0], (String) args[1]));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void matchParens_vs_validateParenthesesCombinations(String[] input, String expectedOutput) {
        assertEquals(
            new HumanEval_119_Source().matchParens(input),
            new HumanEval_119_Transformed().validateParenthesesCombinations(input)
        );
    }
}