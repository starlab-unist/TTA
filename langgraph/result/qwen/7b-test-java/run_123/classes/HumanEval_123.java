import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_123 {

    // Source Code
    static class HumanEval_123_Source {
        public static ArrayList<Integer> getOddCollatz(int n) {
            ArrayList<Integer> oddCollatz = new ArrayList<>();
            if (n % 2 != 0) {
                oddCollatz.add(n);
            }
            while (n > 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = n * 3 + 1;
                }
                if (n % 2 == 1) {
                    oddCollatz.add(n);
                }
            }
            Collections.sort(oddCollatz);
            return oddCollatz;
        }
    }

    // Transformed Code
    static class HumanEval_123_Transformed {
        public static ArrayList<Integer> getOddCollatz(int n) {
            ArrayList<Integer> oddCollatz = new ArrayList<>();
            if (n % 2 == 0) {
                // Do nothing
            } else {
                oddCollatz.add(n);
            }

            int currentValue = n;
            while (currentValue > 1) {
                if (currentValue % 2 == 0) {
                    currentValue /= 2;
                } else {
                    currentValue = currentValue * 3 + 1;
                }

                if (currentValue % 2 != 0) {
                    oddCollatz.add(currentValue);
                }
            }

            Collections.sort(oddCollatz);
            return oddCollatz;
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
        10
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_123_Source.getOddCollatz(testCases[0]), HumanEval_123_Transformed.getOddCollatz(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_123_Source.getOddCollatz(testCases[1]), HumanEval_123_Transformed.getOddCollatz(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_123_Source.getOddCollatz(testCases[2]), HumanEval_123_Transformed.getOddCollatz(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_123_Source.getOddCollatz(testCases[3]), HumanEval_123_Transformed.getOddCollatz(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_123_Source.getOddCollatz(testCases[4]), HumanEval_123_Transformed.getOddCollatz(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_123_Source.getOddCollatz(testCases[5]), HumanEval_123_Transformed.getOddCollatz(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_123_Source.getOddCollatz(testCases[6]), HumanEval_123_Transformed.getOddCollatz(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_123_Source.getOddCollatz(testCases[7]), HumanEval_123_Transformed.getOddCollatz(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_123_Source.getOddCollatz(testCases[8]), HumanEval_123_Transformed.getOddCollatz(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_123_Source.getOddCollatz(testCases[9]), HumanEval_123_Transformed.getOddCollatz(testCases[9]));
    }
}