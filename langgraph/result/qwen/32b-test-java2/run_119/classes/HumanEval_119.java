{source_code}
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

{transformed_code}
static class HumanEval_119_Transformed {
    public String validateParenthesesCombinations(String[] strings) {
        String combinedFirstSecond = strings[0] + strings[1];
        String combinedSecondFirst = strings[1] + strings[0];

        return isBalanced(combinedFirstSecond) || isBalanced(combinedSecondFirst) ? "Yes" : "No";
    }

    private boolean isBalanced(String expression) {
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
}

{test_cases}
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_119 {

    private static final Arguments[][] testCases = {
        {Arguments.of(new String[]{"()", "()"}, "Yes")},
        {Arguments.of(new String[]{"(", ")"}, "Yes")},
        {Arguments.of(new String[]{"(()", "())"}, "Yes")},
        {Arguments.of(new String[]{"(", "("}, "No")},
        {Arguments.of(new String[]{"))", "(("}, "No")},
        {Arguments.of(new String[]{"(())", "()"}, "Yes")},
        {Arguments.of(new String[]{"((()))", ""}, "Yes")},
        {Arguments.of(new String[]{"", ""}, "Yes")},
        {Arguments.of(new String[]{"()(", ")"}, "Yes")},
        {Arguments.of(new String[]{"(()", "()())"}, "No")}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> args[0]);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void matchParens_vs_validateParenthesesCombinations(Arguments testCase) {
        String[] input = (String[]) testCase.get()[0];
        String expectedOutput = (String) testCase.get()[1];

        assertEquals(
            HumanEval_119_Source.matchParens(input),
            HumanEval_119_Transformed.validateParenthesesCombinations(input)
        );
    }
}