import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_25 {

    // Source Code
    public static List<Integer> factorize(int n) {
        List<Integer> fact = new ArrayList<>();
        int i = 2;
        while (i <= Math.sqrt(n) + 1) {
            if (n % i == 0) {
                fact.add(i);
                n /= i;
            } else {
                i++;
            }
        }

        if (n > 1) {
            fact.add(n);
        }
        return fact;
    }

    // Transformed Code
    public static List<Integer> decomposeNumber(int number) {
        List<Integer> factors = new ArrayList<>();
        int divisor = 2;
        while (divisor <= Math.sqrt(number)) {
            if (number % divisor == 0) {
                factors.add(divisor);
                number /= divisor;
            } else {
                divisor++;
            }
        }

        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }

    // Test Cases
    private static final int[] testCases = {
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        15
    };

    @Test
    public void test_0() {
        assertEquals(factorize(testCases[0]), decomposeNumber(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(factorize(testCases[1]), decomposeNumber(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(factorize(testCases[2]), decomposeNumber(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(factorize(testCases[3]), decomposeNumber(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(factorize(testCases[4]), decomposeNumber(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(factorize(testCases[5]), decomposeNumber(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(factorize(testCases[6]), decomposeNumber(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(factorize(testCases[7]), decomposeNumber(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(factorize(testCases[8]), decomposeNumber(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(factorize(testCases[9]), decomposeNumber(testCases[9]));
    }
}