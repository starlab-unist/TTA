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
    public static boolean isEqualToSumEven(int n) {
        return n % 2 == 0 && n >= 8;
    }

    // Transformed Code
    public static boolean checkEvenAndMinimumEight(int number) {
        return number % 2 == 0 && number >= 8;
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
        assertEquals(isEqualToSumEven((Integer) testCases[0][0]), checkEvenAndMinimumEight((Integer) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(isEqualToSumEven((Integer) testCases[1][0]), checkEvenAndMinimumEight((Integer) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(isEqualToSumEven((Integer) testCases[2][0]), checkEvenAndMinimumEight((Integer) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(isEqualToSumEven((Integer) testCases[3][0]), checkEvenAndMinimumEight((Integer) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(isEqualToSumEven((Integer) testCases[4][0]), checkEvenAndMinimumEight((Integer) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(isEqualToSumEven((Integer) testCases[5][0]), checkEvenAndMinimumEight((Integer) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(isEqualToSumEven((Integer) testCases[6][0]), checkEvenAndMinimumEight((Integer) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(isEqualToSumEven((Integer) testCases[7][0]), checkEvenAndMinimumEight((Integer) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(isEqualToSumEven((Integer) testCases[8][0]), checkEvenAndMinimumEight((Integer) testCases[8][0]));
    }

    @Test
    public void test_9() {
        // Edge case: float that is an integer
        assertEquals(isEqualToSumEven(((Double) testCases[9][0]).intValue()), checkEvenAndMinimumEight(((Double) testCases[9][0]).intValue()));
    }

    @Test
    public void test_10() {
        // Edge case: non-integer float
        assertEquals(isEqualToSumEven(((Double) testCases[10][0]).intValue()), checkEvenAndMinimumEight(((Double) testCases[10][0]).intValue()));
    }
}