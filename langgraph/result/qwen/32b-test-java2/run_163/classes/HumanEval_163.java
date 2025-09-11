import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_163 {

    // Source Code
    public List<Integer> generateIntegers(int a, int b) {
        int lower = Math.max(2, Math.min(a, b));
        int upper = Math.min(8, Math.max(a, b));

        List<Integer> result = new ArrayList<>();
        for (int i = lower; i <= upper; i++) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }
        return result;
    }

    // Transformed Code
    public List<Integer> produceEvenNumbers(int x, int y) {
        int start = Math.max(2, Math.min(x, y));
        int end = Math.min(8, Math.max(x, y));

        List<Integer> evenNumbers = new ArrayList<>();
        int current = start;
        while (current <= end) {
            if (current % 2 == 0) {
                evenNumbers.add(current);
            }
            current++;
        }

        return evenNumbers;
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 5},
        {3, 9},
        {6, 2},
        {8, 8},
        {0, 4},
        {7, 7},
        {2, 2},
        {10, 1},
        {5, 5},
        {4, 4}
    };

    @Test
    public void test_0() {
        assertEquals(generateIntegers(testCases[0][0], testCases[0][1]), produceEvenNumbers(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(generateIntegers(testCases[1][0], testCases[1][1]), produceEvenNumbers(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(generateIntegers(testCases[2][0], testCases[2][1]), produceEvenNumbers(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(generateIntegers(testCases[3][0], testCases[3][1]), produceEvenNumbers(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(generateIntegers(testCases[4][0], testCases[4][1]), produceEvenNumbers(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(generateIntegers(testCases[5][0], testCases[5][1]), produceEvenNumbers(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(generateIntegers(testCases[6][0], testCases[6][1]), produceEvenNumbers(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(generateIntegers(testCases[7][0], testCases[7][1]), produceEvenNumbers(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(generateIntegers(testCases[8][0], testCases[8][1]), produceEvenNumbers(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(generateIntegers(testCases[9][0], testCases[9][1]), produceEvenNumbers(testCases[9][0], testCases[9][1]));
    }
}