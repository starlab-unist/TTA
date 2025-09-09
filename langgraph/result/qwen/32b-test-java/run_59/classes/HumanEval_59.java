import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_59 {

    // Source Code
    static class SourceCode {
        public static int largestPrimeFactor(int n) {
            int largest = 1;
            for (int j = 2; j <= n; j++) {
                if (n % j == 0 && isPrime(j)) {
                    largest = Math.max(largest, j);
                }
            }
            return largest;
        }

        private static boolean isPrime(int k) {
            if (k < 2) {
                return false;
            }
            for (int i = 2; i < k; i++) {
                if (k % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_59_Transformed {
        public int findMaxPrimeDivisor(int number) {
            boolean checkPrime(int candidate) {
                if (candidate < 2) {
                    return false;
                }
                int divisor = 2;
                while (divisor * divisor <= candidate) {
                    if (candidate % divisor == 0) {
                        return false;
                    }
                    divisor++;
                }
                return true;
            }

            int maxPrime = 1;
            int factor = 2;
            while (factor <= number) {
                if (number % factor == 0 && checkPrime(factor)) {
                    maxPrime = factor;
                }
                factor++;
            }
            return maxPrime;
        }
    }

    // Test Cases
    private static final int[] testCases = {
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        11,
        12,
        13,
        14,
        15,
        16,
        17,
        18,
        19,
        20
    };

    @Test
    public void test_0() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[0]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[1]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[2]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[3]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[4]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[5]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[6]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[7]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[8]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[9]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[9]));
    }

    @Test
    public void test_10() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[10]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[10]));
    }

    @Test
    public void test_11() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[11]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[11]));
    }

    @Test
    public void test_12() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[12]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[12]));
    }

    @Test
    public void test_13() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[13]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[13]));
    }

    @Test
    public void test_14() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[14]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[14]));
    }

    @Test
    public void test_15() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[15]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[15]));
    }

    @Test
    public void test_16() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[16]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[16]));
    }

    @Test
    public void test_17() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[17]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[17]));
    }

    @Test
    public void test_18() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[18]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[18]));
    }

    @Test
    public void test_19() {
        assertEquals(SourceCode.largestPrimeFactor(testCases[19]), new HumanEval_59_Transformed().findMaxPrimeDivisor(testCases[19]));
    }
}