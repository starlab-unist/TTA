import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_13 {

    // Source Code
    static class HumanEval_13_Source {
        public static int greatestCommonDivisor(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }

    // Transformed Code
    static class HumanEval_13_Transformed {
        public int findHighestCommonFactor(int num1, int num2) {
            while (num2 != 0) {
                int remainder = num1 % num2;
                num1 = num2;
                num2 = remainder;
            }
            return num1;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {48, 18},   // GCD is 6
        {56, 98},   // GCD is 14
        {101, 103}, // GCD is 1 (prime numbers)
        {270, 192}, // GCD is 6
        {0, 5},     // GCD is 5
        {5, 0},     // GCD is 5
        {0, 0},     // GCD is 0
        {20, 30},   // GCD is 10
        {7, 3},     // GCD is 1
        {100, 10}   // GCD is 10
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor((int) testCases[0][0], (int) testCases[0][1]), 
                     new HumanEval_13_Transformed().findHighestCommonFactor((int) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor((int) testCases[1][0], (int) testCases[1][1]), 
                     new HumanEval_13_Transformed().findHighestCommonFactor((int) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor((int) testCases[2][0], (int) testCases[2][1]), 
                     new HumanEval_13_Transformed().findHighestCommonFactor((int) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor((int) testCases[3][0], (int) testCases[3][1]), 
                     new HumanEval_13_Transformed().findHighestCommonFactor((int) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor((int) testCases[4][0], (int) testCases[4][1]), 
                     new HumanEval_13_Transformed().findHighestCommonFactor((int) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor((int) testCases[5][0], (int) testCases[5][1]), 
                     new HumanEval_13_Transformed().findHighestCommonFactor((int) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor((int) testCases[6][0], (int) testCases[6][1]), 
                     new HumanEval_13_Transformed().findHighestCommonFactor((int) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor((int) testCases[7][0], (int) testCases[7][1]), 
                     new HumanEval_13_Transformed().findHighestCommonFactor((int) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor((int) testCases[8][0], (int) testCases[8][1]), 
                     new HumanEval_13_Transformed().findHighestCommonFactor((int) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor((int) testCases[9][0], (int) testCases[9][1]), 
                     new HumanEval_13_Transformed().findHighestCommonFactor((int) testCases[9][0], (int) testCases[9][1]));
    }
}