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
    static class HumanEval_55_Source {
        public static int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            return fib(n - 1) + fib(n - 2);
        }
    }

    // Transformed Code
    static class HumanEval_55_Transformed {
        public static int calculate_fibonacci(int sequence_index) {
            if (sequence_index == 0) {
                return 0;
            } else if (sequence_index == 1) {
                return 1;
            }

            int previous = 0, current = 1;
            int index = 2;
            while (index <= sequence_index) {
                int next = current + previous;
                previous = current;
                current = next;
                index++;
            }

            return current;
        }
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
        assertEquals(HumanEval_55_Source.fib(testCases[0]), HumanEval_55_Transformed.calculate_fibonacci(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_55_Source.fib(testCases[1]), HumanEval_55_Transformed.calculate_fibonacci(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_55_Source.fib(testCases[2]), HumanEval_55_Transformed.calculate_fibonacci(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_55_Source.fib(testCases[3]), HumanEval_55_Transformed.calculate_fibonacci(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_55_Source.fib(testCases[4]), HumanEval_55_Transformed.calculate_fibonacci(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_55_Source.fib(testCases[5]), HumanEval_55_Transformed.calculate_fibonacci(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_55_Source.fib(testCases[6]), HumanEval_55_Transformed.calculate_fibonacci(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_55_Source.fib(testCases[7]), HumanEval_55_Transformed.calculate_fibonacci(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_55_Source.fib(testCases[8]), HumanEval_55_Transformed.calculate_fibonacci(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_55_Source.fib(testCases[9]), HumanEval_55_Transformed.calculate_fibonacci(testCases[9]));
    }
}