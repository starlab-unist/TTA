import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_60 {

    // Source Code
    static class HumanEval_60_Source {
        public static int sumToN(int n) {
            return n * (n + 1) / 2;
        }
    }

    // Transformed Code
    static class HumanEval_60_Transformed {
        public static int calculateTotalUpTo(int number) {
            int totalSum = 0;
            int current = 0;

            while (current <= number) {
                totalSum += current;
                current += 1;
            }

            return totalSum;
        }
    }

    // Test Cases
    private static final int[] testCases = {
        0,      // Edge case: smallest possible input
        1,      // Simple case
        5,      // Small positive integer
        10,     // Medium positive integer
        20,     // Larger positive integer
        100,    // Large positive integer
        -1,     // Negative number (edge case)
        -5,     // Another negative number
        1000,   // Very large positive integer
        1       // Repeated simple case
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_60_Source.sumToN(testCases[0]), HumanEval_60_Transformed.calculateTotalUpTo(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_60_Source.sumToN(testCases[1]), HumanEval_60_Transformed.calculateTotalUpTo(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_60_Source.sumToN(testCases[2]), HumanEval_60_Transformed.calculateTotalUpTo(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_60_Source.sumToN(testCases[3]), HumanEval_60_Transformed.calculateTotalUpTo(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_60_Source.sumToN(testCases[4]), HumanEval_60_Transformed.calculateTotalUpTo(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_60_Source.sumToN(testCases[5]), HumanEval_60_Transformed.calculateTotalUpTo(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_60_Source.sumToN(testCases[6]), HumanEval_60_Transformed.calculateTotalUpTo(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_60_Source.sumToN(testCases[7]), HumanEval_60_Transformed.calculateTotalUpTo(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_60_Source.sumToN(testCases[8]), HumanEval_60_Transformed.calculateTotalUpTo(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_60_Source.sumToN(testCases[9]), HumanEval_60_Transformed.calculateTotalUpTo(testCases[9]));
    }
}