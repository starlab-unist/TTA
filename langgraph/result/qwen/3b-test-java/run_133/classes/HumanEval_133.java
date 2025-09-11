import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_133 {

    // Source Code
    public static int sumSquares(double[] lst) {
        int squared = 0;
        for (double i : lst) {
            squared += Math.ceil(i) * Math.ceil(i);
        }
        return squared;
    }

    // Transformed Code (modified to accept double[])
    public static int calculateTotalSquaredCeilings(double[] numbers) {
        int total = 0;
        for (double number : numbers) {
            total += Math.ceil(number) * Math.ceil(number);
        }
        return total;
    }

    // Test Cases
    private static final double[][] testCases = {
        {1, 2, 3},
        {-1.5, 2.3, -3.7},
        {0, 0, 0},
        {4.9, 5.1, 6.5},
        {10, -10, 20},
        {1.1, 1.9, 2.5},
        {-1, -2, -3},
        {},
        {0.99, 1.01, 2.99},
        {5}
    };

    @Test
    public void test_0() {
        assertEquals(sumSquares(testCases[0]), calculateTotalSquaredCeilings(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(sumSquares(testCases[1]), calculateTotalSquaredCeilings(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(sumSquares(testCases[2]), calculateTotalSquaredCeilings(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(sumSquares(testCases[3]), calculateTotalSquaredCeilings(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(sumSquares(testCases[4]), calculateTotalSquaredCeilings(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(sumSquares(testCases[5]), calculateTotalSquaredCeilings(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(sumSquares(testCases[6]), calculateTotalSquaredCeilings(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(sumSquares(testCases[7]), calculateTotalSquaredCeilings(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(sumSquares(testCases[8]), calculateTotalSquaredCeilings(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(sumSquares(testCases[9]), calculateTotalSquaredCeilings(testCases[9]));
    }
}