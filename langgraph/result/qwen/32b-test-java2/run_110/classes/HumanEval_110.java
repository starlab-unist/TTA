import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_110 {

    // Source Code
    public static String exchange(int[] lst1, int[] lst2) {
        int odd = 0;
        int even = 0;
        for (int i : lst1) {
            if (i % 2 == 1) {
                odd += 1;
            }
        }
        for (int i : lst2) {
            if (i % 2 == 0) {
                even += 1;
            }
        }
        if (even >= odd) {
            return "YES";
        }
        return "NO";
    }

    // Transformed Code
    public String compareParity(int[] listA, int[] listB) {
        int oddCount = 0;
        int evenCount = 0;
        int index = 0;

        while (index < listA.length) {
            if (listA[index] % 2 != 0) {
                oddCount += 1;
            }
            index += 1;
        }

        index = 0;
        while (index < listB.length) {
            if (listB[index] % 2 == 0) {
                evenCount += 1;
            }
            index += 1;
        }

        return evenCount >= oddCount ? "YES" : "NO";
    }

    // Test Cases
    private static final int[][][] testCases = {
        {{1, 3, 5}, {2, 4, 6}},
        {{1, 2, 3}, {4, 5, 6}},
        {{1, 1, 1}, {2, 4, 6}},
        {{1, 3, 5}, {1, 3, 5}},
        {{2, 4, 6}, {1, 3, 5}},
        {{}, {}},
        {{1}, {2}},
        {{1, 3, 5, 7}, {2}},
        {{2, 4, 6, 8}, {1, 3, 5}},
        {{}, {1, 3, 5}}
    };

    @Test
    public void test_0() {
        assertEquals(exchange(testCases[0][0], testCases[0][1]), new HumanEval_110().compareParity(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(exchange(testCases[1][0], testCases[1][1]), new HumanEval_110().compareParity(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(exchange(testCases[2][0], testCases[2][1]), new HumanEval_110().compareParity(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(exchange(testCases[3][0], testCases[3][1]), new HumanEval_110().compareParity(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(exchange(testCases[4][0], testCases[4][1]), new HumanEval_110().compareParity(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(exchange(testCases[5][0], testCases[5][1]), new HumanEval_110().compareParity(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(exchange(testCases[6][0], testCases[6][1]), new HumanEval_110().compareParity(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(exchange(testCases[7][0], testCases[7][1]), new HumanEval_110().compareParity(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(exchange(testCases[8][0], testCases[8][1]), new HumanEval_110().compareParity(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(exchange(testCases[9][0], testCases[9][1]), new HumanEval_110().compareParity(testCases[9][0], testCases[9][1]));
    }
}