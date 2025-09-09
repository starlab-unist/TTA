import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HumanEval_31 {

    // Source Code Class
    static class HumanEval_31 {
        public boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }
            for (int k = 2; k < n - 1; k++) {
                if (n % k == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code Class
    static class HumanEval_31_Transformed {
        public boolean checkPrime(int number) {
            if (number < 2) {
                return false;
            }
            int divisor = 2;
            while (divisor < number - 1) {
                if (number % divisor == 0) {
                    return false;
                }
                divisor += 1;
            }
            return true;
        }
    }

    // Test Cases
    private static final int[] testCases = {
        0,      // Not prime (less than 2)
        1,      // Not prime (less than 2)
        2,      // Prime
        3,      // Prime
        4,      // Not prime
        5,      // Prime
        9,      // Not prime
        11,     // Prime
        16,     // Not prime
        17,     // Prime
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_31().isPrime(testCases[0]), new HumanEval_31_Transformed().checkPrime(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_31().isPrime(testCases[1]), new HumanEval_31_Transformed().checkPrime(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_31().isPrime(testCases[2]), new HumanEval_31_Transformed().checkPrime(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_31().isPrime(testCases[3]), new HumanEval_31_Transformed().checkPrime(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_31().isPrime(testCases[4]), new HumanEval_31_Transformed().checkPrime(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_31().isPrime(testCases[5]), new HumanEval_31_Transformed().checkPrime(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_31().isPrime(testCases[6]), new HumanEval_31_Transformed().checkPrime(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_31().isPrime(testCases[7]), new HumanEval_31_Transformed().checkPrime(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_31().isPrime(testCases[8]), new HumanEval_31_Transformed().checkPrime(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_31().isPrime(testCases[9]), new HumanEval_31_Transformed().checkPrime(testCases[9]));
    }
}