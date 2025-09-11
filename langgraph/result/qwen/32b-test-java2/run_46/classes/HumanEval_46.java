import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_46 {

    // Source Code
    public int fib4(int n) {
        int[] results = {0, 0, 2, 0};
        if (n < 4) {
            return results[n];
        }

        for (int i = 4; i <= n; i++) {
            int nextValue = results[0] + results[1] + results[2] + results[3];
            results[0] = results[1];
            results[1] = results[2];
            results[2] = results[3];
            results[3] = nextValue;
        }

        return results[3];
    }

    // Transformed Code
    public int calculateCustomFibonacci(int index) {
        int[] sequence = {0, 0, 2, 0};
        if (index < 4) {
            return sequence[index];
        }

        int currentIndex = 4;
        while (currentIndex <= index) {
            int nextValue = sequence[3] + sequence[2] + sequence[1] + sequence[0];
            sequence[0] = sequence[1];
            sequence[1] = sequence[2];
            sequence[2] = sequence[3];
            sequence[3] = nextValue;
            currentIndex++;
        }

        return sequence[3];
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(fib4(0), calculateCustomFibonacci(0));
    }

    @Test
    public void test_1() {
        assertEquals(fib4(1), calculateCustomFibonacci(1));
    }

    @Test
    public void test_2() {
        assertEquals(fib4(2), calculateCustomFibonacci(2));
    }

    @Test
    public void test_3() {
        assertEquals(fib4(3), calculateCustomFibonacci(3));
    }

    @Test
    public void test_4() {
        assertEquals(fib4(4), calculateCustomFibonacci(4));
    }

    @Test
    public void test_5() {
        assertEquals(fib4(5), calculateCustomFibonacci(5));
    }

    @Test
    public void test_6() {
        assertEquals(fib4(6), calculateCustomFibonacci(6));
    }

    @Test
    public void test_7() {
        assertEquals(fib4(7), calculateCustomFibonacci(7));
    }

    @Test
    public void test_8() {
        assertEquals(fib4(8), calculateCustomFibonacci(8));
    }

    @Test
    public void test_9() {
        assertEquals(fib4(9), calculateCustomFibonacci(9));
    }
}