import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_150 {

    // Source Code
    static class HumanEval_150_Source {
        public static int xOrY(int n, int x, int y) {
            if (n == 1) {
                return y;
            }
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return y;
                }
            }
            return x;
        }
    }

    // Transformed Code
    static class HumanEval_150_Transformed {
        public static int determineValueBasedOnDivisibility(int number, int valueIfNotPrime, int valueIfPrime) {
            if (number == 1) {
                return valueIfPrime;
            }

            int divisor = 2;
            while (divisor < number) {
                if (number % divisor == 0) {
                    return valueIfPrime;
                }
                divisor++;
            }
            return valueIfNotPrime;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {1, 0, 1},
        {2, 1, 0},
        {3, 1, 0},
        {4, 0, 1},
        {5, 1, 0},
        {6, 0, 1},
        {7, 1, 0},
        {8, 0, 1},
        {9, 0, 1},
        {10, 0, 1}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_150_Source.xOrY((int) testCases[0][0], (int) testCases[0][1], (int) testCases[0][2]), 
                     HumanEval_150_Transformed.determineValueBasedOnDivisibility((int) testCases[0][0], (int) testCases[0][1], (int) testCases[0][2]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_150_Source.xOrY((int) testCases[1][0], (int) testCases[1][1], (int) testCases[1][2]), 
                     HumanEval_150_Transformed.determineValueBasedOnDivisibility((int) testCases[1][0], (int) testCases[1][1], (int) testCases[1][2]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_150_Source.xOrY((int) testCases[2][0], (int) testCases[2][1], (int) testCases[2][2]), 
                     HumanEval_150_Transformed.determineValueBasedOnDivisibility((int) testCases[2][0], (int) testCases[2][1], (int) testCases[2][2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_150_Source.xOrY((int) testCases[3][0], (int) testCases[3][1], (int) testCases[3][2]), 
                     HumanEval_150_Transformed.determineValueBasedOnDivisibility((int) testCases[3][0], (int) testCases[3][1], (int) testCases[3][2]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_150_Source.xOrY((int) testCases[4][0], (int) testCases[4][1], (int) testCases[4][2]), 
                     HumanEval_150_Transformed.determineValueBasedOnDivisibility((int) testCases[4][0], (int) testCases[4][1], (int) testCases[4][2]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_150_Source.xOrY((int) testCases[5][0], (int) testCases[5][1], (int) testCases[5][2]), 
                     HumanEval_150_Transformed.determineValueBasedOnDivisibility((int) testCases[5][0], (int) testCases[5][1], (int) testCases[5][2]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_150_Source.xOrY((int) testCases[6][0], (int) testCases[6][1], (int) testCases[6][2]), 
                     HumanEval_150_Transformed.determineValueBasedOnDivisibility((int) testCases[6][0], (int) testCases[6][1], (int) testCases[6][2]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_150_Source.xOrY((int) testCases[7][0], (int) testCases[7][1], (int) testCases[7][2]), 
                     HumanEval_150_Transformed.determineValueBasedOnDivisibility((int) testCases[7][0], (int) testCases[7][1], (int) testCases[7][2]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_150_Source.xOrY((int) testCases[8][0], (int) testCases[8][1], (int) testCases[8][2]), 
                     HumanEval_150_Transformed.determineValueBasedOnDivisibility((int) testCases[8][0], (int) testCases[8][1], (int) testCases[8][2]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_150_Source.xOrY((int) testCases[9][0], (int) testCases[9][1], (int) testCases[9][2]), 
                     HumanEval_150_Transformed.determineValueBasedOnDivisibility((int) testCases[9][0], (int) testCases[9][1], (int) testCases[9][2]));
    }
}