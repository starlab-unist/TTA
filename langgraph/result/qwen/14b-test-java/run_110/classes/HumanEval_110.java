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
                odd++;
            }
        }
        for (int i : lst2) {
            if (i % 2 == 0) {
                even++;
            }
        }
        if (even >= odd) {
            return "YES";
        }
        return "NO";
    }

    // Transformed Code
    public static String compare_parity(int[] list_a, int[] list_b) {
        int odd_count = 0;
        int even_count = 0;
        int index = 0;

        while (index < list_a.length) {
            if (list_a[index] % 2 != 0) {
                odd_count += 1;
            }
            index += 1;
        }

        index = 0;
        while (index < list_b.length) {
            if (list_b[index] % 2 == 0) {
                even_count += 1;
            }
            index += 1;
        }

        return even_count >= odd_count ? "YES" : "NO";
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 3, 5}, new int[]{2, 4, 6}},    // odd: 3, even: 3 -> YES
        {new int[]{1, 2, 3}, new int[]{4, 5, 6}},    // odd: 2, even: 2 -> YES
        {new int[]{1, 1, 1}, new int[]{2, 4, 6}},    // odd: 3, even: 3 -> YES
        {new int[]{1, 3, 5}, new int[]{1, 3, 5}},    // odd: 3, even: 0 -> NO
        {new int[]{2, 4, 6}, new int[]{1, 3, 5}},    // odd: 0, even: 3 -> YES
        {new int[]{}, new int[]{}},                  // odd: 0, even: 0 -> YES
        {new int[]{1}, new int[]{2}},                // odd: 1, even: 1 -> YES
        {new int[]{1, 3, 5, 7}, new int[]{2}},       // odd: 4, even: 1 -> NO
        {new int[]{2, 4, 6, 8}, new int[]{1, 3, 5}}, // odd: 3, even: 4 -> YES
        {new int[]{}, new int[]{1, 3, 5}},           // odd: 0, even: 0 -> YES (since even >= odd)
    };

    @Test
    public void test_0() {
        assertEquals(exchange((int[]) testCases[0][0], (int[]) testCases[0][1]), 
                     compare_parity((int[]) testCases[0][0], (int[]) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(exchange((int[]) testCases[1][0], (int[]) testCases[1][1]), 
                     compare_parity((int[]) testCases[1][0], (int[]) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(exchange((int[]) testCases[2][0], (int[]) testCases[2][1]), 
                     compare_parity((int[]) testCases[2][0], (int[]) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(exchange((int[]) testCases[3][0], (int[]) testCases[3][1]), 
                     compare_parity((int[]) testCases[3][0], (int[]) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(exchange((int[]) testCases[4][0], (int[]) testCases[4][1]), 
                     compare_parity((int[]) testCases[4][0], (int[]) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(exchange((int[]) testCases[5][0], (int[]) testCases[5][1]), 
                     compare_parity((int[]) testCases[5][0], (int[]) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(exchange((int[]) testCases[6][0], (int[]) testCases[6][1]), 
                     compare_parity((int[]) testCases[6][0], (int[]) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(exchange((int[]) testCases[7][0], (int[]) testCases[7][1]), 
                     compare_parity((int[]) testCases[7][0], (int[]) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(exchange((int[]) testCases[8][0], (int[]) testCases[8][1]), 
                     compare_parity((int[]) testCases[8][0], (int[]) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(exchange((int[]) testCases[9][0], (int[]) testCases[9][1]), 
                     compare_parity((int[]) testCases[9][0], (int[]) testCases[9][1]));
    }
}