import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_25 {

    // Source Code
    static class HumanEval_25_Source {
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
    }

    // Transformed Code
    static class HumanEval_25_Transformed {
        public static List<Integer> decomposeNumber(int number) {
            List<Integer> factors = new ArrayList<>();
            int divisor = 2;
            while (divisor <= Math.sqrt(number)) { // Note: Java does not have isqrt, using sqrt instead
                if (number % divisor == 0) {
                    factors.add(divisor);
                    number /= divisor;
                } else {
                    divisor += 1;
                }
            }

            if (number > 1) {
                factors.add(number);
            }
            return factors;
        }
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
        assertEquals(HumanEval_25_Source.factorize(testCases[0]), HumanEval_25_Transformed.decomposeNumber(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_25_Source.factorize(testCases[1]), HumanEval_25_Transformed.decomposeNumber(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_25_Source.factorize(testCases[2]), HumanEval_25_Transformed.decomposeNumber(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_25_Source.factorize(testCases[3]), HumanEval_25_Transformed.decomposeNumber(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_25_Source.factorize(testCases[4]), HumanEval_25_Transformed.decomposeNumber(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_25_Source.factorize(testCases[5]), HumanEval_25_Transformed.decomposeNumber(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_25_Source.factorize(testCases[6]), HumanEval_25_Transformed.decomposeNumber(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_25_Source.factorize(testCases[7]), HumanEval_25_Transformed.decomposeNumber(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_25_Source.factorize(testCases[8]), HumanEval_25_Transformed.decomposeNumber(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_25_Source.factorize(testCases[9]), HumanEval_25_Transformed.decomposeNumber(testCases[9]));
    }
}