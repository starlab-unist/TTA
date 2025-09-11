import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_35 {

    // Source Code
    static class HumanEval_35_Source {
        public static int maxElement(int[] l) {
            int m = l[0];
            for (int e : l) {
                if (e > m) {
                    m = e;
                }
            }
            return m;
        }
    }

    // Transformed Code
    static class HumanEval_35_Transformed {
        public static int maxElement(int[] l) {
            int m = l[0];
            int index = 1;
            while (index < l.length) {
                if (l[index] > m) {
                    m = l[index];
                }
                index += 1;
            }
            return m;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5},
        {-7, -1, -5, -3, -9},
        {10, 20, 30, 40, 50},
        {100},
        {0, 0, 0, 0},
        {5, 5, 5, 5, 6},
        {-1, -2, -3, -4, -5, -6},
        {1},
        {2, 2, 2, 1, 1, 1},
        {9, 8, 7, 6, 5, 4, 3, 2, 1}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_35_Source.maxElement(testCases[0]), HumanEval_35_Transformed.maxElement(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_35_Source.maxElement(testCases[1]), HumanEval_35_Transformed.maxElement(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_35_Source.maxElement(testCases[2]), HumanEval_35_Transformed.maxElement(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_35_Source.maxElement(testCases[3]), HumanEval_35_Transformed.maxElement(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_35_Source.maxElement(testCases[4]), HumanEval_35_Transformed.maxElement(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_35_Source.maxElement(testCases[5]), HumanEval_35_Transformed.maxElement(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_35_Source.maxElement(testCases[6]), HumanEval_35_Transformed.maxElement(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_35_Source.maxElement(testCases[7]), HumanEval_35_Transformed.maxElement(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_35_Source.maxElement(testCases[8]), HumanEval_35_Transformed.maxElement(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_35_Source.maxElement(testCases[9]), HumanEval_35_Transformed.maxElement(testCases[9]));
    }
}