import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_102 {

    // Source Code
    static class HumanEval_102_Source {
        public int chooseNum(int x, int y) {
            if (x > y) {
                return -1;
            }
            if (y % 2 == 0) {
                return y;
            }
            if (x == y) {
                return -1;
            }
            return y - 1;
        }
    }

    // Transformed Code
    static class HumanEval_102_Transformed {
        public int selectNumber(int a, int b) {
            if (a > b) {
                return -1;
            } else if (b % 2 == 0) {
                return b;
            } else if (a == b) {
                return -1;
            } else {
                return b - 1;
            }
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {3, 5},     // y > x and y is odd
        {4, 4},     // x == y
        {2, 6},     // y > x and y is even
        {7, 8},     // y > x and y is even
        {10, 10},   // x == y
        {5, 3},     // x > y
        {0, 2},     // y > x and y is even
        {1, 1},     // x == y
        {9, 11},    // y > x and y is odd
        {6, 7}      // y > x and y is odd
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_102_Source().chooseNum(testCases[0][0], testCases[0][1]), 
                     new HumanEval_102_Transformed().selectNumber(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_102_Source().chooseNum(testCases[1][0], testCases[1][1]), 
                     new HumanEval_102_Transformed().selectNumber(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_102_Source().chooseNum(testCases[2][0], testCases[2][1]), 
                     new HumanEval_102_Transformed().selectNumber(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_102_Source().chooseNum(testCases[3][0], testCases[3][1]), 
                     new HumanEval_102_Transformed().selectNumber(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_102_Source().chooseNum(testCases[4][0], testCases[4][1]), 
                     new HumanEval_102_Transformed().selectNumber(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_102_Source().chooseNum(testCases[5][0], testCases[5][1]), 
                     new HumanEval_102_Transformed().selectNumber(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_102_Source().chooseNum(testCases[6][0], testCases[6][1]), 
                     new HumanEval_102_Transformed().selectNumber(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_102_Source().chooseNum(testCases[7][0], testCases[7][1]), 
                     new HumanEval_102_Transformed().selectNumber(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_102_Source().chooseNum(testCases[8][0], testCases[8][1]), 
                     new HumanEval_102_Transformed().selectNumber(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_102_Source().chooseNum(testCases[9][0], testCases[9][1]), 
                     new HumanEval_102_Transformed().selectNumber(testCases[9][0], testCases[9][1]));
    }
}