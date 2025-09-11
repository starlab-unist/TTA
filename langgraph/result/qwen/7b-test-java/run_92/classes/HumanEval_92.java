import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_92 {

    // Source Code
    public static boolean anyInt(int x, int y, int z) {
        if ((x + y == z) || (x + z == y) || (y + z == x)) {
            return true;
        }
        return false;
    }

    // Transformed Code
    public static boolean checkSumOfTwoEqualsThird(int x, int y, int z) {
        if (x + y == z || x + z == y || y + z == x) {
            return true;
        }
        return false;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {1, 2, 3},   // True: 1 + 2 == 3
        {5, 3, 2},   // True: 3 + 2 == 5
        {4, 6, 10},  // True: 4 + 6 == 10
        {7, 3, 4},   // True: 3 + 4 == 7
        {1, 1, 2},   // True: 1 + 1 == 2
        {10, 5, 5},  // False: No two numbers sum to the third
        {0, 0, 0},   // True: 0 + 0 == 0
        {-1, -2, -3},// True: -1 + -2 == -3
        // The last two test cases from Python are not valid in Java as they involve non-integer types.
        // They are omitted here.
    };

    @Test
    public void test_0() {
        assertEquals(anyInt((int) testCases[0][0], (int) testCases[0][1], (int) testCases[0][2]), 
                     checkSumOfTwoEqualsThird((int) testCases[0][0], (int) testCases[0][1], (int) testCases[0][2]));
    }

    @Test
    public void test_1() {
        assertEquals(anyInt((int) testCases[1][0], (int) testCases[1][1], (int) testCases[1][2]), 
                     checkSumOfTwoEqualsThird((int) testCases[1][0], (int) testCases[1][1], (int) testCases[1][2]));
    }

    @Test
    public void test_2() {
        assertEquals(anyInt((int) testCases[2][0], (int) testCases[2][1], (int) testCases[2][2]), 
                     checkSumOfTwoEqualsThird((int) testCases[2][0], (int) testCases[2][1], (int) testCases[2][2]));
    }

    @Test
    public void test_3() {
        assertEquals(anyInt((int) testCases[3][0], (int) testCases[3][1], (int) testCases[3][2]), 
                     checkSumOfTwoEqualsThird((int) testCases[3][0], (int) testCases[3][1], (int) testCases[3][2]));
    }

    @Test
    public void test_4() {
        assertEquals(anyInt((int) testCases[4][0], (int) testCases[4][1], (int) testCases[4][2]), 
                     checkSumOfTwoEqualsThird((int) testCases[4][0], (int) testCases[4][1], (int) testCases[4][2]));
    }

    @Test
    public void test_5() {
        assertEquals(anyInt((int) testCases[5][0], (int) testCases[5][1], (int) testCases[5][2]), 
                     checkSumOfTwoEqualsThird((int) testCases[5][0], (int) testCases[5][1], (int) testCases[5][2]));
    }

    @Test
    public void test_6() {
        assertEquals(anyInt((int) testCases[6][0], (int) testCases[6][1], (int) testCases[6][2]), 
                     checkSumOfTwoEqualsThird((int) testCases[6][0], (int) testCases[6][1], (int) testCases[6][2]));
    }

    @Test
    public void test_7() {
        assertEquals(anyInt((int) testCases[7][0], (int) testCases[7][1], (int) testCases[7][2]), 
                     checkSumOfTwoEqualsThird((int) testCases[7][0], (int) testCases[7][1], (int) testCases[7][2]));
    }
}