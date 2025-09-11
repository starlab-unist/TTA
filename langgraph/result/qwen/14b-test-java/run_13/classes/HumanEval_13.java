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
        public static int find_highest_common_factor(int num1, int num2) {
            while (num2 != 0) {
                int remainder = num1 % num2;
                num1 = num2;
                num2 = remainder;
            }
            return num1;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
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
        assertEquals(HumanEval_13_Source.greatestCommonDivisor(testCases[0][0], testCases[0][1]), 
                     HumanEval_13_Transformed.find_highest_common_factor(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor(testCases[1][0], testCases[1][1]), 
                     HumanEval_13_Transformed.find_highest_common_factor(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor(testCases[2][0], testCases[2][1]), 
                     HumanEval_13_Transformed.find_highest_common_factor(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor(testCases[3][0], testCases[3][1]), 
                     HumanEval_13_Transformed.find_highest_common_factor(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor(testCases[4][0], testCases[4][1]), 
                     HumanEval_13_Transformed.find_highest_common_factor(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor(testCases[5][0], testCases[5][1]), 
                     HumanEval_13_Transformed.find_highest_common_factor(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor(testCases[6][0], testCases[6][1]), 
                     HumanEval_13_Transformed.find_highest_common_factor(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor(testCases[7][0], testCases[7][1]), 
                     HumanEval_13_Transformed.find_highest_common_factor(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor(testCases[8][0], testCases[8][1]), 
                     HumanEval_13_Transformed.find_highest_common_factor(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_13_Source.greatestCommonDivisor(testCases[9][0], testCases[9][1]), 
                     HumanEval_13_Transformed.find_highest_common_factor(testCases[9][0], testCases[9][1]));
    }
}