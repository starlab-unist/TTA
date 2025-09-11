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

    // Transformed Code
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

    // Test Cases
    private static final Object[][] testCases = {
        {1, 0, 1},   // n=1, x=0 (not_prime), y=1 (prime)
        {2, 0, 1},   // n=2, x=0 (not_prime), y=1 (prime)
        {3, 0, 1},   // n=3, x=0 (not_prime), y=1 (prime)
        {4, 0, 1},   // n=4, x=0 (not_prime), y=1 (prime)
        {5, 0, 1},   // n=5, x=0 (not_prime), y=1 (prime)
        {6, 0, 1},   // n=6, x=0 (not_prime), y=1 (prime)
        {7, 0, 1},   // n=7, x=0 (not_prime), y=1 (prime)
        {8, 0, 1},   // n=8, x=0 (not_prime), y=1 (prime)
        {9, 0, 1},   // n=9, x=0 (not_prime), y=1 (prime)
        {10, 0, 1}   // n=10, x=0 (not_prime), y=1 (prime)
    };

    @Test
    public void test_0() {
        assertEquals(xOrY((int) testCases[0][0], (int) testCases[0][1], (int) testCases[0][2]), 
                     determineValueBasedOnDivisibility((int) testCases[0][0], (int) testCases[0][1], (int) testCases[0][2]));
    }

    @Test
    public void test_1() {
        assertEquals(xOrY((int) testCases[1][0], (int) testCases[1][1], (int) testCases[1][2]), 
                     determineValueBasedOnDivisibility((int) testCases[1][0], (int) testCases[1][1], (int) testCases[1][2]));
    }

    @Test
    public void test_2() {
        assertEquals(xOrY((int) testCases[2][0], (int) testCases[2][1], (int) testCases[2][2]), 
                     determineValueBasedOnDivisibility((int) testCases[2][0], (int) testCases[2][1], (int) testCases[2][2]));
    }

    @Test
    public void test_3() {
        assertEquals(xOrY((int) testCases[3][0], (int) testCases[3][1], (int) testCases[3][2]), 
                     determineValueBasedOnDivisibility((int) testCases[3][0], (int) testCases[3][1], (int) testCases[3][2]));
    }

    @Test
    public void test_4() {
        assertEquals(xOrY((int) testCases[4][0], (int) testCases[4][1], (int) testCases[4][2]), 
                     determineValueBasedOnDivisibility((int) testCases[4][0], (int) testCases[4][1], (int) testCases[4][2]));
    }

    @Test
    public void test_5() {
        assertEquals(xOrY((int) testCases[5][0], (int) testCases[5][1], (int) testCases[5][2]), 
                     determineValueBasedOnDivisibility((int) testCases[5][0], (int) testCases[5][1], (int) testCases[5][2]));
    }

    @Test
    public void test_6() {
        assertEquals(xOrY((int) testCases[6][0], (int) testCases[6][1], (int) testCases[6][2]), 
                     determineValueBasedOnDivisibility((int) testCases[6][0], (int) testCases[6][1], (int) testCases[6][2]));
    }

    @Test
    public void test_7() {
        assertEquals(xOrY((int) testCases[7][0], (int) testCases[7][1], (int) testCases[7][2]), 
                     determineValueBasedOnDivisibility((int) testCases[7][0], (int) testCases[7][1], (int) testCases[7][2]));
    }

    @Test
    public void test_8() {
        assertEquals(xOrY((int) testCases[8][0], (int) testCases[8][1], (int) testCases[8][2]), 
                     determineValueBasedOnDivisibility((int) testCases[8][0], (int) testCases[8][1], (int) testCases[8][2]));
    }

    @Test
    public void test_9() {
        assertEquals(xOrY((int) testCases[9][0], (int) testCases[9][1], (int) testCases[9][2]), 
                     determineValueBasedOnDivisibility((int) testCases[9][0], (int) testCases[9][1], (int) testCases[9][2]));
    }
}