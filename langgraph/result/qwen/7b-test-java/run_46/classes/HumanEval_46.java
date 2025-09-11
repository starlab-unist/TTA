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
    public static int fib4(int n) {
        List<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(2);
        results.add(0);

        if (n < 4) {
            return results.get(n);
        }

        for (int i = 4; i <= n; i++) {
            results.add(results.get(i - 1) + results.get(i - 2) + results.get(i - 3) + results.get(i - 4));
            results.remove(0);
        }

        return results.get(results.size() - 1);
    }

    // Transformed Code
    public static int calculateCustomFibonacci(int index) {
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
    private static final int[] testCases = {
        0,  // Base case
        1,  // Base case
        2,  // Base case
        3,  // Base case
        4,  // First calculated value
        5,  // Continue calculation
        6,  // Continue calculation
        7,  // Continue calculation
        8,  // Continue calculation
        9   // Continue calculation
    };

    @Test
    public void test_0() {
        assertEquals(fib4(testCases[0]), calculateCustomFibonacci(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(fib4(testCases[1]), calculateCustomFibonacci(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(fib4(testCases[2]), calculateCustomFibonacci(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(fib4(testCases[3]), calculateCustomFibonacci(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(fib4(testCases[4]), calculateCustomFibonacci(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(fib4(testCases[5]), calculateCustomFibonacci(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(fib4(testCases[6]), calculateCustomFibonacci(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(fib4(testCases[7]), calculateCustomFibonacci(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(fib4(testCases[8]), calculateCustomFibonacci(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(fib4(testCases[9]), calculateCustomFibonacci(testCases[9]));
    }
}