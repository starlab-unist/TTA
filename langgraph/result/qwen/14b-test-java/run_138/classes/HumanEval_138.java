import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_138 {

    // Source Code
    static class HumanEval_138_Source {
        public static boolean isEqualToSumEven(int n) {
            return n % 2 == 0 && n >= 8;
        }
    }

    // Transformed Code
    static class HumanEval_138_Transformed {
        public static boolean checkEvenAndMinimumEight(int number) {
            return number % 2 == 0 && number >= 8;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {4, false},
        {6, false},
        {8, true},
        {10, true},
        {12, true},
        {7, false},
        {9, false},
        {0, false},
        {-2, false},
        {8.0, true},  // Edge case: float that is an integer
        {10.5, false}  // Edge case: non-integer float
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_138_Source.isEqualToSumEven((int) (double) testCases[0][0]), 
                     HumanEval_138_Transformed.checkEvenAndMinimumEight((int) (double) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_138_Source.isEqualToSumEven((int) (double) testCases[1][0]), 
                     HumanEval_138_Transformed.checkEvenAndMinimumEight((int) (double) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_138_Source.isEqualToSumEven((int) (double) testCases[2][0]), 
                     HumanEval_138_Transformed.checkEvenAndMinimumEight((int) (double) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_138_Source.isEqualToSumEven((int) (double) testCases[3][0]), 
                     HumanEval_138_Transformed.checkEvenAndMinimumEight((int) (double) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_138_Source.isEqualToSumEven((int) (double) testCases[4][0]), 
                     HumanEval_138_Transformed.checkEvenAndMinimumEight((int) (double) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_138_Source.isEqualToSumEven((int) (double) testCases[5][0]), 
                     HumanEval_138_Transformed.checkEvenAndMinimumEight((int) (double) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_138_Source.isEqualToSumEven((int) (double) testCases[6][0]), 
                     HumanEval_138_Transformed.checkEvenAndMinimumEight((int) (double) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_138_Source.isEqualToSumEven((int) (double) testCases[7][0]), 
                     HumanEval_138_Transformed.checkEvenAndMinimumEight((int) (double) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_138_Source.isEqualToSumEven((int) (double) testCases[8][0]), 
                     HumanEval_138_Transformed.checkEvenAndMinimumEight((int) (double) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_138_Source.isEqualToSumEven((int) (double) testCases[9][0]), 
                     HumanEval_138_Transformed.checkEvenAndMinimumEight((int) (double) testCases[9][0]));
    }

    @Test
    public void test_10() {
        assertEquals(HumanEval_138_Source.isEqualToSumEven((int) (double) testCases[10][0]), 
                     HumanEval_138_Transformed.checkEvenAndMinimumEight((int) (double) testCases[10][0]));
    }
}