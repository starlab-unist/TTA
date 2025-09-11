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
    public static int maxElement(int[] l) {
        int m = l[0];
        for (int e : l) {
            if (e > m) {
                m = e;
            }
        }
        return m;
    }

    // Transformed Code
    public int find_maximum_value(int[] elements) {
        int currentMax = elements[0];
        int index = 1;
        while (index < elements.length) {
            if (elements[index] > currentMax) {
                currentMax = elements[index];
            }
            index++;
        }
        return currentMax;
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
        assertEquals(maxElement(testCases[0]), new HumanEval_35().find_maximum_value(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(maxElement(testCases[1]), new HumanEval_35().find_maximum_value(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(maxElement(testCases[2]), new HumanEval_35().find_maximum_value(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(maxElement(testCases[3]), new HumanEval_35().find_maximum_value(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(maxElement(testCases[4]), new HumanEval_35().find_maximum_value(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(maxElement(testCases[5]), new HumanEval_35().find_maximum_value(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(maxElement(testCases[6]), new HumanEval_35().find_maximum_value(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(maxElement(testCases[7]), new HumanEval_35().find_maximum_value(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(maxElement(testCases[8]), new HumanEval_35().find_maximum_value(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(maxElement(testCases[9]), new HumanEval_35().find_maximum_value(testCases[9]));
    }
}