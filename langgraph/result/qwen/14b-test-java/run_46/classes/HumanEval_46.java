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
    static class HumanEval_46_Source {
        public static int fib4(int n) {
            int[] results = {0, 0, 2, 0};
            if (n < 4) {
                return results[n];
            }

            for (int i = 4; i <= n; i++) {
                int nextValue = results[3] + results[2] + results[1] + results[0];
                results[0] = results[1];
                results[1] = results[2];
                results[2] = results[3];
                results[3] = nextValue;
            }

            return results[3];
        }
    }

    // Transformed Code
    static class HumanEval_46_Transformed {
        public int calculateCustomFibonacci(int index) {
            int[] sequence = {0, 0, 2, 0};
            if (index < 4) {
                return sequence[index];
            }

            int currentIndex = 4;
            while (currentIndex <= index) {
                int nextValue = sequence[3] + sequence[2] + sequence[1] + sequence[0];
                for (int i = 0; i < 3; i++) {
                    sequence[i] = sequence[i + 1];
                }
                sequence[3] = nextValue;
                currentIndex++;
            }

            return sequence[3];
        }
    }

    // Test Cases
    private static final int[] testCases = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void test_0() {
        assertEquals(HumanEval_46_Source.fib4(testCases[0]), new HumanEval_46_Transformed().calculateCustomFibonacci(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_46_Source.fib4(testCases[1]), new HumanEval_46_Transformed().calculateCustomFibonacci(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_46_Source.fib4(testCases[2]), new HumanEval_46_Transformed().calculateCustomFibonacci(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_46_Source.fib4(testCases[3]), new HumanEval_46_Transformed().calculateCustomFibonacci(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_46_Source.fib4(testCases[4]), new HumanEval_46_Transformed().calculateCustomFibonacci(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_46_Source.fib4(testCases[5]), new HumanEval_46_Transformed().calculateCustomFibonacci(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_46_Source.fib4(testCases[6]), new HumanEval_46_Transformed().calculateCustomFibonacci(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_46_Source.fib4(testCases[7]), new HumanEval_46_Transformed().calculateCustomFibonacci(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_46_Source.fib4(testCases[8]), new HumanEval_46_Transformed().calculateCustomFibonacci(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_46_Source.fib4(testCases[9]), new HumanEval_46_Transformed().calculateCustomFibonacci(testCases[9]));
    }
}