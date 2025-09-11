import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_24 {

    // Source Code
    public static int largestDivisor(int n) {
        for (int i = n - 1; i > 0; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1; // In case n is 1 or negative
    }

    // Transformed Code
    public static int findGreatestDivisor(int number) {
        int divisor = number - 1;
        while (divisor > 0) {
            if (number % divisor == 0) {
                return divisor;
            }
            divisor--;
        }
        return 1; // In case the input is 1 or less, the greatest divisor is 1
    }

    // Test Cases
    private static final Object[][] testCases = {
        {1, 1},       // Edge case: no divisors for 1 (original function will return 1)
        {2, 1},
        {3, 1},
        {4, 2},
        {5, 1},
        {6, 3},
        {10, 5},
        {15, 5},
        {20, 10},
        {25, 5}
    };

    @Test
    public void test_0() {
        assertEquals(largestDivisor((int) testCases[0][0]), findGreatestDivisor((int) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(largestDivisor((int) testCases[1][0]), findGreatestDivisor((int) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(largestDivisor((int) testCases[2][0]), findGreatestDivisor((int) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(largestDivisor((int) testCases[3][0]), findGreatestDivisor((int) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(largestDivisor((int) testCases[4][0]), findGreatestDivisor((int) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(largestDivisor((int) testCases[5][0]), findGreatestDivisor((int) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(largestDivisor((int) testCases[6][0]), findGreatestDivisor((int) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(largestDivisor((int) testCases[7][0]), findGreatestDivisor((int) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(largestDivisor((int) testCases[8][0]), findGreatestDivisor((int) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(largestDivisor((int) testCases[9][0]), findGreatestDivisor((int) testCases[9][0]));
    }
}