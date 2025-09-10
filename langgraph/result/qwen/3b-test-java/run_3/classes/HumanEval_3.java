import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_3 {

    // Source Code
    static class HumanEval_3_Source {
        public static boolean belowZero(List<Integer> operations) {
            int balance = 0;

            for (int op : operations) {
                balance += op;
                if (balance < 0) {
                    return true;
                }
            }

            return false;
        }
    }

    // Transformed Code
    static class HumanEval_3_Transformed {
        public static boolean checkNegativeBalance(List<Integer> transactions) {
            int currentBalance = 0;

            int index = 0;
            while (index < transactions.size()) {
                currentBalance += transactions.get(index);
                if (currentBalance < 0) {
                    return true;
                }
                index++;
            }

            return false;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(), false},
        {List.of(1, 2, 3), false},
        {List.of(-1, -2, -3), true},
        {List.of(10, -5, -6), true},
        {List.of(10, -5, 5), false},
        {List.of(0, 0, 0), false},
        {List.of(1, -1, 1, -1, 1, -2), true},
        {List.of(-1, 1, -1, 1, -1, 1), true},
        {List.of(1, 2, 3, -7), true},
        {List.of(5, 5, 5, 5, -20), true}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_3_Source.belowZero((List<Integer>) testCases[0][0]), 
                     HumanEval_3_Transformed.checkNegativeBalance((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_3_Source.belowZero((List<Integer>) testCases[1][0]), 
                     HumanEval_3_Transformed.checkNegativeBalance((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_3_Source.belowZero((List<Integer>) testCases[2][0]), 
                     HumanEval_3_Transformed.checkNegativeBalance((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_3_Source.belowZero((List<Integer>) testCases[3][0]), 
                     HumanEval_3_Transformed.checkNegativeBalance((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_3_Source.belowZero((List<Integer>) testCases[4][0]), 
                     HumanEval_3_Transformed.checkNegativeBalance((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_3_Source.belowZero((List<Integer>) testCases[5][0]), 
                     HumanEval_3_Transformed.checkNegativeBalance((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_3_Source.belowZero((List<Integer>) testCases[6][0]), 
                     HumanEval_3_Transformed.checkNegativeBalance((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_3_Source.belowZero((List<Integer>) testCases[7][0]), 
                     HumanEval_3_Transformed.checkNegativeBalance((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_3_Source.belowZero((List<Integer>) testCases[8][0]), 
                     HumanEval_3_Transformed.checkNegativeBalance((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_3_Source.belowZero((List<Integer>) testCases[9][0]), 
                     HumanEval_3_Transformed.checkNegativeBalance((List<Integer>) testCases[9][0]));
    }
}