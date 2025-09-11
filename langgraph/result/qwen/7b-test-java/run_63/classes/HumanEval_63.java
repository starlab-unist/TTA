import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_63 {

    // Source Code
    public static int fibfib(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibfib(n - 1) + fibfib(n - 2) + fibfib(n - 3);
    }

    // Transformed Code
    public static int calculateModifiedFibonacci(int index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 0;
        } else if (index == 2) {
            return 1;
        } else {
            return calculateModifiedFibonacci(index - 1) + 
                   calculateModifiedFibonacci(index - 2) + 
                   calculateModifiedFibonacci(index - 3);
        }
    }

    // Test Cases
    private static final int[] testCases = {
        0,  // Base case
        1,  // Base case
        2,  // Base case
        3,  // Simple case
        4,  // Slightly larger input
        5,  // Further recursion
        6,  // Further recursion
        7,  // Further recursion
        8,  // Further recursion
        9   // Larger input to test deeper recursion
    };

    @Test
    public void test_0() {
        assertEquals(fibfib(testCases[0]), calculateModifiedFibonacci(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(fibfib(testCases[1]), calculateModifiedFibonacci(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(fibfib(testCases[2]), calculateModifiedFibonacci(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(fibfib(testCases[3]), calculateModifiedFibonacci(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(fibfib(testCases[4]), calculateModifiedFibonacci(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(fibfib(testCases[5]), calculateModifiedFibonacci(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(fibfib(testCases[6]), calculateModifiedFibonacci(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(fibfib(testCases[7]), calculateModifiedFibonacci(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(fibfib(testCases[8]), calculateModifiedFibonacci(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(fibfib(testCases[9]), calculateModifiedFibonacci(testCases[9]));
    }
}