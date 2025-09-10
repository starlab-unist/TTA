import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Necessary imports for Stream and Arrays
import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_160 {

    // Source Code
    static class SourceCode {
        public static int doAlgebra(String[] operator, int[] operand) {
            StringBuilder expression = new StringBuilder(Integer.toString(operand[0]));
            for (int i = 0; i < operator.length; i++) {
                expression.append(operator[i]).append(operand[i + 1]);
            }
            return evaluateExpression(expression.toString());
        }

        private static int evaluateExpression(String expression) {
            try {
                // Ensure the result of eval is cast to an integer
                return ((Number)new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression)).intValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int evaluateExpression(String[] operators, int[] values) {
            StringBuilder resultString = new StringBuilder(Integer.toString(values[0]));
            int index = 0;
            while (index < operators.length) {
                resultString.append(operators[index]).append(Integer.toString(values[index + 1]));
                index++;
            }
            return evaluate(resultString.toString());
        }

        private static int evaluate(String expression) {
            try {
                // Ensure the result of eval is cast to an integer
                return ((Number)new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression)).intValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new String[]{"+"}, new int[]{1, 2}},
        {new String[]{"-"}, new int[]{3, 1}},
        {new String[]{"*"}, new int[]{4, 5}},
        {new String[]{"/"}, new int[]{8, 2}},
        {new String[]{"+", "+"}, new int[]{1, 2, 3}},
        {new String[]{"-", "-"}, new int[]{5, 3, 1}},
        {new String[]{"*", "*"}, new int[]{2, 3, 4}},
        {new String[]{"/", "/"}, new int[]{8, 2, 2}},
        {new String[]{"+", "-", "*"}, new int[]{2, 3, 1, 4}},
        {new String[]{"-", "+", "/", "*"}, new int[]{10, 5, 2, 4, 2}}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test equivalence of doAlgebra and evaluateExpression functions")
    void doAlgebra_vs_evaluateExpression(Object[] testCase) {
        String[] operators = (String[]) testCase[0];
        int[] values = (int[]) testCase[1];

        assertEquals(
            SourceCode.doAlgebra(operators, values),
            TransformedCode.evaluateExpression(operators, values)
        );
    }
}