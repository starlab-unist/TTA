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
    public static int sumToN(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // Transformed Code
    public static int calculateTotalUpTo(int number) {
        int totalSum = 0;
        int current = 0;
        
        while (current <= number) {
            totalSum += current;
            current += 1;
        }
        
        return totalSum;
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
        assertEquals(sumToN(testCases[0]), calculateTotalUpTo(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(sumToN(testCases[1]), calculateTotalUpTo(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(sumToN(testCases[2]), calculateTotalUpTo(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(sumToN(testCases[3]), calculateTotalUpTo(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(sumToN(testCases[4]), calculateTotalUpTo(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(sumToN(testCases[5]), calculateTotalUpTo(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(sumToN(testCases[6]), calculateTotalUpTo(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(sumToN(testCases[7]), calculateTotalUpTo(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(sumToN(testCases[8]), calculateTotalUpTo(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(sumToN(testCases[9]), calculateTotalUpTo(testCases[9]));
    }
}