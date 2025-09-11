import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_160 {

    // Source Code
    static class HumanEval_160_Source {
        public static double doAlgebra(String[] operator, double[] operand) {
            StringBuilder expression = new StringBuilder();
            expression.append(operand[0]);
            for (int i = 0; i < operator.length; i++) {
                expression.append(operator[i]).append(operand[i + 1]);
            }
            try {
                return Double.parseDouble(new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression.toString()).toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Transformed Code
    static class HumanEval_160_Transformed {
        public static double evaluateExpression(String[] operators, double[] values) {
            StringBuilder resultString = new StringBuilder();
            resultString.append(values[0]);
            int index = 0;
            while (index < operators.length) {
                resultString.append(operators[index]).append(values[index + 1]);
                index++;
            }
            try {
                return Double.parseDouble(new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(resultString.toString()).toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new String[]{"+", "*", "-"}, new double[]{2, 3, 4, 5}},  // (2 + 3) * 4 - 5 = 9
        {new String[]{"-", "/"}, new double[]{10, 5, 2}},         // 10 - 5 / 2 = 7.5
        {new String[]{"*", "+", "/"}, new double[]{1, 2, 3, 4}},   // (1 * 2) + 3 / 4 = 2.75
        {new String[]{"+", "-", "*", "/"}, new double[]{10, 5, 3, 2, 4}},  // ((10 + 5) - 3) * 2 / 4 = 4.0
        {new String[]{"**", "+"}, new double[]{2, 3, 4}},          // 2 ** 3 + 4 = 12
        {new String[]{"+", "-", "+"}, new double[]{1, 1, 1, 1}},   // 1 + 1 - 1 + 1 = 2
        {new String[]{"*", "*", "*"}, new double[]{2, 2, 2, 2}},   // 2 * 2 * 2 * 2 = 16
        {new String[]{"/", "+", "-"}, new double[]{8, 4, 2, 1}},   // 8 / 4 + 2 - 1 = 3.0
        {new String[]{"+", "-", "*", "/"}, new double[]{0, 1, 1, 1, 1}},  // (0 + 1) - 1 * 1 / 1 = 0.0
        {new String[]{"**", "*", "+"}, new double[]{2, 3, 4, 5}},   // (2 ** 3) * 4 + 5 = 37
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_160_Source.doAlgebra((String[]) testCases[0][0], (double[]) testCases[0][1]), 
                     HumanEval_160_Transformed.evaluateExpression((String[]) testCases[0][0], (double[]) testCases[0][1]), 0.0001);
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_160_Source.doAlgebra((String[]) testCases[1][0], (double[]) testCases[1][1]), 
                     HumanEval_160_Transformed.evaluateExpression((String[]) testCases[1][0], (double[]) testCases[1][1]), 0.0001);
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_160_Source.doAlgebra((String[]) testCases[2][0], (double[]) testCases[2][1]), 
                     HumanEval_160_Transformed.evaluateExpression((String[]) testCases[2][0], (double[]) testCases[2][1]), 0.0001);
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_160_Source.doAlgebra((String[]) testCases[3][0], (double[]) testCases[3][1]), 
                     HumanEval_160_Transformed.evaluateExpression((String[]) testCases[3][0], (double[]) testCases[3][1]), 0.0001);
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_160_Source.doAlgebra((String[]) testCases[4][0], (double[]) testCases[4][1]), 
                     HumanEval_160_Transformed.evaluateExpression((String[]) testCases[4][0], (double[]) testCases[4][1]), 0.0001);
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_160_Source.doAlgebra((String[]) testCases[5][0], (double[]) testCases[5][1]), 
                     HumanEval_160_Transformed.evaluateExpression((String[]) testCases[5][0], (double[]) testCases[5][1]), 0.0001);
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_160_Source.doAlgebra((String[]) testCases[6][0], (double[]) testCases[6][1]), 
                     HumanEval_160_Transformed.evaluateExpression((String[]) testCases[6][0], (double[]) testCases[6][1]), 0.0001);
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_160_Source.doAlgebra((String[]) testCases[7][0], (double[]) testCases[7][1]), 
                     HumanEval_160_Transformed.evaluateExpression((String[]) testCases[7][0], (double[]) testCases[7][1]), 0.0001);
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_160_Source.doAlgebra((String[]) testCases[8][0], (double[]) testCases[8][1]), 
                     HumanEval_160_Transformed.evaluateExpression((String[]) testCases[8][0], (double[]) testCases[8][1]), 0.0001);
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_160_Source.doAlgebra((String[]) testCases[9][0], (double[]) testCases[9][1]), 
                     HumanEval_160_Transformed.evaluateExpression((String[]) testCases[9][0], (double[]) testCases[9][1]), 0.0001);
    }
}