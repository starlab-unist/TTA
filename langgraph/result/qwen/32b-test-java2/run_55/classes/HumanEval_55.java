import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_55 {

    // Source Code
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // Transformed Code
    public static int calculateFibonacci(int sequenceIndex) {
        if (sequenceIndex == 0) {
            return 0;
        } else if (sequenceIndex == 1) {
            return 1;
        }

        int previous = 0, current = 1;
        int index = 2;
        while (index <= sequenceIndex) {
            int next = previous + current;
            previous = current;
            current = next;
            index++;
        }

        return current;
    }

    // Test Cases
    private static final int[] testCases = {
        0,
        1,
        2,
        3,
        4,
        5,
        10,
        15,
        20,
        25
    };

    @Test
    public void test_0() {
        assertEquals(fib(testCases[0]), calculateFibonacci(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(fib(testCases[1]), calculateFibonacci(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(fib(testCases[2]), calculateFibonacci(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(fib(testCases[3]), calculateFibonacci(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(fib(testCases[4]), calculateFibonacci(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(fib(testCases[5]), calculateFibonacci(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(fib(testCases[6]), calculateFibonacci(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(fib(testCases[7]), calculateFibonacci(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(fib(testCases[8]), calculateFibonacci(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(fib(testCases[9]), calculateFibonacci(testCases[9]));
    }
}