import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_57 {

    // Source Code
    public static boolean monotonic(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        int[] reversedSortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(reversedSortedArr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sortedArr[i] && arr[i] != reversedSortedArr[i]) {
                return false;
            }
        }
        return true;
    }

    // Transformed Code
    public static boolean checkMonotonicSequence(int[] sequence) {
        int[] ascending = sequence.clone();
        int[] descending = sequence.clone();

        Arrays.sort(ascending);
        Arrays.sort(descending);
        reverseArray(descending);

        if (Arrays.equals(sequence, ascending) || Arrays.equals(sequence, descending)) {
            return true;
        }
        return false;
    }

    private static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3, 4, 5}},       // strictly increasing
        {new int[]{5, 4, 3, 2, 1}},       // strictly decreasing
        {new int[]{1, 1, 1, 1, 1}},       // all elements are the same
        {new int[]{1, 2, 2, 3, 4}},       // non-decreasing
        {new int[]{5, 5, 4, 4, 3, 2, 1}}, // non-increasing
        {new int[]{1, 3, 2}},             // not monotonic
        {new int[]{}},                    // empty list
        {new int[]{10}},                  // single element
        {new int[]{3, 3, 2, 1, 1, 1}},    // decreasing with duplicates
        {new int[]{1, 1, 2, 2, 3, 3}}     // increasing with duplicates
    };

    @Test
    public void test_0() {
        assertEquals(monotonic((int[]) testCases[0][0]), 
                     checkMonotonicSequence((int[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(monotonic((int[]) testCases[1][0]), 
                     checkMonotonicSequence((int[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(monotonic((int[]) testCases[2][0]), 
                     checkMonotonicSequence((int[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(monotonic((int[]) testCases[3][0]), 
                     checkMonotonicSequence((int[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(monotonic((int[]) testCases[4][0]), 
                     checkMonotonicSequence((int[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(monotonic((int[]) testCases[5][0]), 
                     checkMonotonicSequence((int[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(monotonic((int[]) testCases[6][0]), 
                     checkMonotonicSequence((int[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(monotonic((int[]) testCases[7][0]), 
                     checkMonotonicSequence((int[]) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(monotonic((int[]) testCases[8][0]), 
                     checkMonotonicSequence((int[]) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(monotonic((int[]) testCases[9][0]), 
                     checkMonotonicSequence((int[]) testCases[9][0]));
    }
}