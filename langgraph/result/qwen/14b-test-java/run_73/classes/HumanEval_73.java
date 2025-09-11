import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_73 {

    // Source Code
    public static int smallestChange(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                ans += 1;
            }
        }
        return ans;
    }

    // Transformed Code
    public static int minimalAdjustments(int[] sequence) {
        int adjustmentsNeeded = 0;
        int index = 0;
        while (index < sequence.length / 2) {
            if (sequence[index] != sequence[sequence.length - index - 1]) {
                adjustmentsNeeded += 1;
            }
            index += 1;
        }
        return adjustmentsNeeded;
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 2, 1},       // Palindrome with odd length
        {1, 2, 3, 4, 5},       // Not a palindrome
        {1, 1, 1, 1, 1},       // All elements are the same
        {1, 2, 2, 1},          // Palindrome with even length
        {1, 2, 3},             // Not a palindrome
        {},                    // Empty list
        {1},                   // Single element
        {1, 2},                // Not a palindrome
        {1, 2, 3, 4}           // Not a palindrome
    };

    @Test
    public void test_0() {
        assertEquals(smallestChange(testCases[0]), minimalAdjustments(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(smallestChange(testCases[1]), minimalAdjustments(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(smallestChange(testCases[2]), minimalAdjustments(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(smallestChange(testCases[3]), minimalAdjustments(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(smallestChange(testCases[4]), minimalAdjustments(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(smallestChange(testCases[5]), minimalAdjustments(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(smallestChange(testCases[6]), minimalAdjustments(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(smallestChange(testCases[7]), minimalAdjustments(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(smallestChange(testCases[8]), minimalAdjustments(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(smallestChange(testCases[9]), minimalAdjustments(testCases[9]));
    }
}