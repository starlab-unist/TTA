import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_15 {

    // Source Code
    public static String stringSequence(int n) {
        StringBuilder result = new StringBuilder();
        for (int x = 0; x <= n; x++) {
            result.append(x).append(" ");
        }
        return result.toString().trim();
    }

    // Transformed Code
    public static String generateNumberSeries(int length) {
        StringBuilder numberList = new StringBuilder();
        int index = 0;

        while (index <= length) {
            numberList.append(index);
            numberList.append(" ");
            index++;
        }

        return numberList.toString().trim();
    }

    // Test Cases
    private static final int[] testCases = {
        0,
        1,
        5,
        10,
        20,
        100,
        -1,  // Edge case: negative input
        3,
        7,
        15
    };

    @Test
    public void test_0() {
        assertEquals(stringSequence(testCases[0]), generateNumberSeries(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(stringSequence(testCases[1]), generateNumberSeries(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(stringSequence(testCases[2]), generateNumberSeries(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(stringSequence(testCases[3]), generateNumberSeries(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(stringSequence(testCases[4]), generateNumberSeries(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(stringSequence(testCases[5]), generateNumberSeries(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(stringSequence(testCases[6]), generateNumberSeries(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(stringSequence(testCases[7]), generateNumberSeries(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(stringSequence(testCases[8]), generateNumberSeries(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(stringSequence(testCases[9]), generateNumberSeries(testCases[9]));
    }
}