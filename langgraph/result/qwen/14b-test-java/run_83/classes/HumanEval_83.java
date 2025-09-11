import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_83 {

    // Source Code
    public static int startsOneEnds(int n) {
        if (n == 1) return 1;
        return 18 * (int) Math.pow(10, n - 2);
    }

    // Transformed Code
    public static int calculateSpecialNumber(int length) {
        if (length == 1) {
            return 1;
        }
        int multiplier = 18;
        int base = (int) Math.pow(10, length - 2);
        return multiplier * base;
    }

    // Test Cases
    private static final int[] testCases = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void test_0() {
        assertEquals(startsOneEnds(testCases[0]), calculateSpecialNumber(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(startsOneEnds(testCases[1]), calculateSpecialNumber(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(startsOneEnds(testCases[2]), calculateSpecialNumber(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(startsOneEnds(testCases[3]), calculateSpecialNumber(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(startsOneEnds(testCases[4]), calculateSpecialNumber(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(startsOneEnds(testCases[5]), calculateSpecialNumber(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(startsOneEnds(testCases[6]), calculateSpecialNumber(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(startsOneEnds(testCases[7]), calculateSpecialNumber(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(startsOneEnds(testCases[8]), calculateSpecialNumber(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(startsOneEnds(testCases[9]), calculateSpecialNumber(testCases[9]));
    }
}