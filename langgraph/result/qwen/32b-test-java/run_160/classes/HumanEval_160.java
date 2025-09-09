import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                return new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression).intValue();
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
                return new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression).intValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new String[]{"+", "*", "-"}, new int[]{2, 3, 4, 5}},
        {new String[]{"-", "/"}, new int[]{10, 5, 2}},
        {new String[]{"*", "+", "/"}, new int[]{1, 2, 3, 4}},
        {new String[]{"+", "-", "*", "/"}, new int[]{10, 5, 3, 2, 4}},
        {new String[]{"**", "+"}, new int[]{2, 3, 4}},
        {new String[]{"+", "-", "+"}, new int[]{1, 1, 1, 1}},
        {new String[]{"*", "*", "*"}, new int[]{2, 2, 2, 2}},
        {new String[]{"/", "+", "-"}, new int[]{8, 4, 2, 1}},
        {new String[]{"+", "-", "*", "/"}, new int[]{0, 1, 1, 1, 1}},
        {new String[]{"**", "*", "+"}, new int[]{2, 3, 4, 5}}
    };

    private static Stream<Object[]> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void doAlgebra_vs_evaluateExpression(String[] operators, int[] values) {
        assertEquals(
            SourceCode.doAlgebra(operators, values),
            TransformedCode.evaluateExpression(operators, values)
        );
    }
}