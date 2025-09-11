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
    public static int doAlgebra(String[] operator, int[] operand) {
        StringBuilder expression = new StringBuilder(Integer.toString(operand[0]));
        for (int i = 0; i < operator.length; i++) {
            expression.append(operator[i]).append(Integer.toString(operand[i + 1]));
        }
        return evaluateExpression(expression.toString());
    }

    private static int evaluateExpression(String expression) {
        try {
            return (int) java.lang.reflect.MethodHandles.lookup().findStatic(java.lang.Math.class, "parseInt", java.lang.reflect.MethodType.methodType(int.class, String.class)).invokeExact(expression);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    // Transformed Code
    public static int evaluateExpression(char[] operators, int[] values) {
        StringBuilder resultString = new StringBuilder(String.valueOf(values[0]));
        int index = 0;
        while (index < operators.length) {
            resultString.append(operators[index]).append(values[index + 1]);
            index++;
        }
        return (int) eval(resultString.toString());
    }

    private static double eval(String expression) {
        javax.script.ScriptEngine engine = new javax.script.ScriptEngineManager().getEngineByName("JavaScript");
        try {
            return Double.parseDouble(engine.eval(expression).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
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

    @Test
    public void test_0() {
        assertEquals(doAlgebra((String[]) testCases[0][0], (int[]) testCases[0][1]), 
                     evaluateExpression(((String[]) testCases[0][0])[0].toCharArray(), (int[]) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(doAlgebra((String[]) testCases[1][0], (int[]) testCases[1][1]), 
                     evaluateExpression(((String[]) testCases[1][0])[0].toCharArray(), (int[]) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(doAlgebra((String[]) testCases[2][0], (int[]) testCases[2][1]), 
                     evaluateExpression(((String[]) testCases[2][0])[0].toCharArray(), (int[]) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(doAlgebra((String[]) testCases[3][0], (int[]) testCases[3][1]), 
                     evaluateExpression(((String[]) testCases[3][0])[0].toCharArray(), (int[]) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(doAlgebra((String[]) testCases[4][0], (int[]) testCases[4][1]), 
                     evaluateExpression(((String[]) testCases[4][0])[0].toCharArray(), (int[]) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(doAlgebra((String[]) testCases[5][0], (int[]) testCases[5][1]), 
                     evaluateExpression(((String[]) testCases[5][0])[0].toCharArray(), (int[]) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(doAlgebra((String[]) testCases[6][0], (int[]) testCases[6][1]), 
                     evaluateExpression(((String[]) testCases[6][0])[0].toCharArray(), (int[]) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(doAlgebra((String[]) testCases[7][0], (int[]) testCases[7][1]), 
                     evaluateExpression(((String[]) testCases[7][0])[0].toCharArray(), (int[]) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(doAlgebra((String[]) testCases[8][0], (int[]) testCases[8][1]), 
                     evaluateExpression(((String[]) testCases[8][0])[0].toCharArray(), (int[]) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(doAlgebra((String[]) testCases[9][0], (int[]) testCases[9][1]), 
                     evaluateExpression(((String[]) testCases[9][0])[0].toCharArray(), (int[]) testCases[9][1]));
    }
}