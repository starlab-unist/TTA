import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_139 {

    // Source Code
    static class HumanEval_139_Source {
        public static long specialFactorial(int n) {
            long factI = 1;
            long specialFact = 1;
            for (int i = 1; i <= n; i++) {
                factI *= i;
                specialFact *= factI;
            }
            return specialFact;
        }
    }

    // Transformed Code
    static class HumanEval_139_Transformed {
        public static long computeSpecialProduct(int n) {
            long currentFactorial = 1;
            long cumulativeProduct = 1;
            int index = 1;

            while (index <= n) {
                currentFactorial *= index;
                cumulativeProduct *= currentFactorial;
                index++;
            }

            return cumulativeProduct;
        }
    }

    // Test Cases
    private static final int[] testCases = {
        0,      // Edge case: n = 0
        1,      // Simple case: n = 1
        2,      // Simple case: n = 2
        3,      // Simple case: n = 3
        4,      // Simple case: n = 4
        5,      // Simple case: n = 5
        6,      // Simple case: n = 6
        10,     // Larger number: n = 10
        20,     // Larger number: n = 20
        100     // Very large number: n = 100
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_139_Source.specialFactorial(testCases[0]), 
                     HumanEval_139_Transformed.computeSpecialProduct(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_139_Source.specialFactorial(testCases[1]), 
                     HumanEval_139_Transformed.computeSpecialProduct(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_139_Source.specialFactorial(testCases[2]), 
                     HumanEval_139_Transformed.computeSpecialProduct(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_139_Source.specialFactorial(testCases[3]), 
                     HumanEval_139_Transformed.computeSpecialProduct(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_139_Source.specialFactorial(testCases[4]), 
                     HumanEval_139_Transformed.computeSpecialProduct(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_139_Source.specialFactorial(testCases[5]), 
                     HumanEval_139_Transformed.computeSpecialProduct(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_139_Source.specialFactorial(testCases[6]), 
                     HumanEval_139_Transformed.computeSpecialProduct(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_139_Source.specialFactorial(testCases[7]), 
                     HumanEval_139_Transformed.computeSpecialProduct(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_139_Source.specialFactorial(testCases[8]), 
                     HumanEval_139_Transformed.computeSpecialProduct(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_139_Source.specialFactorial(testCases[9]), 
                     HumanEval_139_Transformed.computeSpecialProduct(testCases[9]));
    }
}