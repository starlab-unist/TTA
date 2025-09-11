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
        StringBuilder expression = new StringBuilder();
        expression.append(operand[0]);

        for (int i = 0; i < operator.length; i++) {
            expression.append(operator[i]).append(operand[i + 1]);
        }

        try {
            return Integer.parseInt(expression.toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }

    // Transformed Code
    public static double evaluateExpression(String[] operators, double[] values) {
        String resultString = String.valueOf(values[0]);
        int index = 0;
        while (index < operators.length) {
            resultString += operators[index] + String.valueOf(values[index + 1]);
            index++;
        }
        try {
            return Double.parseDouble(resultString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid expression");
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
        {new String[]{"**", "*", "+"}, new int[]{2, 3, 4, 5}},
    };

    @Test
    public void test_0() {
        assertEquals(doAlgebra((String[]) testCases[0][0], (int[]) testCases[0][1]), 
                     evaluateExpression((String[]) testCases[0][0], convertIntToDoubleArray((int[]) testCases[0][1])));
    }

    @Test
    public void test_1() {
        assertEquals(doAlgebra((String[]) testCases[1][0], (int[]) testCases[1][1]), 
                     evaluateExpression((String[]) testCases[1][0], convertIntToDoubleArray((int[]) testCases[1][1])));
    }

    @Test
    public void test_2() {
        assertEquals(doAlgebra((String[]) testCases[2][0], (int[]) testCases[2][1]), 
                     evaluateExpression((String[]) testCases[2][0], convertIntToDoubleArray((int[]) testCases[2][1])));
    }

    @Test
    public void test_3() {
        assertEquals(doAlgebra((String[]) testCases[3][0], (int[]) testCases[3][1]), 
                     evaluateExpression((String[]) testCases[3][0], convertIntToDoubleArray((int[]) testCases[3][1])));
    }

    @Test
    public void test_4() {
        assertEquals(doAlgebra((String[]) testCases[4][0], (int[]) testCases[4][1]), 
                     evaluateExpression((String[]) testCases[4][0], convertIntToDoubleArray((int[]) testCases[4][1])));
    }

    @Test
    public void test_5() {
        assertEquals(doAlgebra((String[]) testCases[5][0], (int[]) testCases[5][1]), 
                     evaluateExpression((String[]) testCases[5][0], convertIntToDoubleArray((int[]) testCases[5][1])));
    }

    @Test
    public void test_6() {
        assertEquals(doAlgebra((String[]) testCases[6][0], (int[]) testCases[6][1]), 
                     evaluateExpression((String[]) testCases[6][0], convertIntToDoubleArray((int[]) testCases[6][1])));
    }

    @Test
    public void test_7() {
        assertEquals(doAlgebra((String[]) testCases[7][0], (int[]) testCases[7][1]), 
                     evaluateExpression((String[]) testCases[7][0], convertIntToDoubleArray((int[]) testCases[7][1])));
    }

    @Test
    public void test_8() {
        assertEquals(doAlgebra((String[]) testCases[8][0], (int[]) testCases[8][1]), 
                     evaluateExpression((String[]) testCases[8][0], convertIntToDoubleArray((int[]) testCases[8][1])));
    }

    @Test
    public void test_9() {
        assertEquals(doAlgebra((String[]) testCases[9][0], (int[]) testCases[9][1]), 
                     evaluateExpression((String[]) testCases[9][0], convertIntToDoubleArray((int[]) testCases[9][1])));
    }

    private double[] convertIntToDoubleArray(int[] intArray) {
        double[] doubleArray = new double[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            doubleArray[i] = intArray[i];
        }
        return doubleArray;
    }
}