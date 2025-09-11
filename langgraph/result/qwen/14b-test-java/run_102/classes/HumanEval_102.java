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
    public static int chooseNum(int x, int y) {
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

    // Transformed Code
    public static int select_number(int a, int b) {
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
        assertEquals(chooseNum(testCases[0][0], testCases[0][1]), select_number(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(chooseNum(testCases[1][0], testCases[1][1]), select_number(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(chooseNum(testCases[2][0], testCases[2][1]), select_number(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(chooseNum(testCases[3][0], testCases[3][1]), select_number(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(chooseNum(testCases[4][0], testCases[4][1]), select_number(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(chooseNum(testCases[5][0], testCases[5][1]), select_number(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(chooseNum(testCases[6][0], testCases[6][1]), select_number(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(chooseNum(testCases[7][0], testCases[7][1]), select_number(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(chooseNum(testCases[8][0], testCases[8][1]), select_number(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(chooseNum(testCases[9][0], testCases[9][1]), select_number(testCases[9][0], testCases[9][1]));
    }
}