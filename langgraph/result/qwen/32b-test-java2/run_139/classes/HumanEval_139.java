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
    public static long specialFactorial(int n) {
        long factI = 1;
        long specialFact = 1;
        for (int i = 1; i <= n; i++) {
            factI *= i;
            specialFact *= factI;
        }
        return specialFact;
    }

    // Transformed Code
    public long computeSpecialProduct(int n) {
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
        assertEquals(specialFactorial(testCases[0]), new HumanEval_139().computeSpecialProduct(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(specialFactorial(testCases[1]), new HumanEval_139().computeSpecialProduct(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(specialFactorial(testCases[2]), new HumanEval_139().computeSpecialProduct(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(specialFactorial(testCases[3]), new HumanEval_139().computeSpecialProduct(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(specialFactorial(testCases[4]), new HumanEval_139().computeSpecialProduct(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(specialFactorial(testCases[5]), new HumanEval_139().computeSpecialProduct(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(specialFactorial(testCases[6]), new HumanEval_139().computeSpecialProduct(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(specialFactorial(testCases[7]), new HumanEval_139().computeSpecialProduct(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(specialFactorial(testCases[8]), new HumanEval_139().computeSpecialProduct(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(specialFactorial(testCases[9]), new HumanEval_139().computeSpecialProduct(testCases[9]));
    }
}