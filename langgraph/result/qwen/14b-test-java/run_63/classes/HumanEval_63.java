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
    static class HumanEval_63_Source {
        public static int fibfib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 0;
            }
            if (n == 2) {
                return 1;
            }
            return fibfib(n - 1) + fibfib(n - 2) + fibfib(n - 3);
        }
    }

    // Transformed Code
    static class HumanEval_63_Transformed {
        public static int calculate_modified_fibonacci(int index) {
            if (index == 0) {
                return 0;
            } else if (index == 1) {
                return 0;
            } else if (index == 2) {
                return 1;
            } else {
                return (calculate_modified_fibonacci(index - 1) +
                        calculate_modified_fibonacci(index - 2) +
                        calculate_modified_fibonacci(index - 3));
            }
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
        assertEquals(HumanEval_63_Source.fibfib(testCases[0]), 
                     HumanEval_63_Transformed.calculate_modified_fibonacci(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_63_Source.fibfib(testCases[1]), 
                     HumanEval_63_Transformed.calculate_modified_fibonacci(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_63_Source.fibfib(testCases[2]), 
                     HumanEval_63_Transformed.calculate_modified_fibonacci(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_63_Source.fibfib(testCases[3]), 
                     HumanEval_63_Transformed.calculate_modified_fibonacci(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_63_Source.fibfib(testCases[4]), 
                     HumanEval_63_Transformed.calculate_modified_fibonacci(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_63_Source.fibfib(testCases[5]), 
                     HumanEval_63_Transformed.calculate_modified_fibonacci(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_63_Source.fibfib(testCases[6]), 
                     HumanEval_63_Transformed.calculate_modified_fibonacci(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_63_Source.fibfib(testCases[7]), 
                     HumanEval_63_Transformed.calculate_modified_fibonacci(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_63_Source.fibfib(testCases[8]), 
                     HumanEval_63_Transformed.calculate_modified_fibonacci(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_63_Source.fibfib(testCases[9]), 
                     HumanEval_63_Transformed.calculate_modified_fibonacci(testCases[9]));
    }
}