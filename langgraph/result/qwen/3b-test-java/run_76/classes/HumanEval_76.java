import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_76 {

    // Source Code
    public static boolean isSimplePower(int x, int n) {
        if (n == 1) {
            return (x == 1);
        }
        int power = 1;
        while (power < x) {
            power *= n;
        }
        return (power == x);
    }

    // Transformed Code
    public static boolean isSimplePowerTransformed(int base, int exponent) {
        if (exponent == 1) {
            return base == 1;
        }

        int power = 1;
        while (power < base) {
            power *= exponent;
        }

        return power == base;
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 1},     // True: 1^1 = 1
        {8, 2},     // False: No power of 2 equals 8 exactly within the loop
        {9, 3},     // True: 3^2 = 9
        {27, 3},    // True: 3^3 = 27
        {16, 4},    // True: 4^2 = 16
        {10, 10},   // True: 10^1 = 10
        {256, 2},   // True: 2^8 = 256
        {1, 5},     // False: 5^0 = 1, but loop condition fails for x > 1 when n > 1
        {0, 2},     // False: No power of 2 equals 0
        {7, 3}      // False: No power of 3 equals 7 exactly within the loop
    };

    @Test
    public void test_0() {
        assertEquals(isSimplePower(testCases[0][0], testCases[0][1]), 
                     isSimplePowerTransformed(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(isSimplePower(testCases[1][0], testCases[1][1]), 
                     isSimplePowerTransformed(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(isSimplePower(testCases[2][0], testCases[2][1]), 
                     isSimplePowerTransformed(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(isSimplePower(testCases[3][0], testCases[3][1]), 
                     isSimplePowerTransformed(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(isSimplePower(testCases[4][0], testCases[4][1]), 
                     isSimplePowerTransformed(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(isSimplePower(testCases[5][0], testCases[5][1]), 
                     isSimplePowerTransformed(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(isSimplePower(testCases[6][0], testCases[6][1]), 
                     isSimplePowerTransformed(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(isSimplePower(testCases[7][0], testCases[7][1]), 
                     isSimplePowerTransformed(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(isSimplePower(testCases[8][0], testCases[8][1]), 
                     isSimplePowerTransformed(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(isSimplePower(testCases[9][0], testCases[9][1]), 
                     isSimplePowerTransformed(testCases[9][0], testCases[9][1]));
    }
}