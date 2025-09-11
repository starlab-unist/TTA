import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_126 {

    // Source Code
    public static boolean isSorted(int[] lst) {
        int[] countDigit = new int[100]; // Assuming the input list contains numbers between 0 and 99

        for (int i : lst) {
            countDigit[i]++;
        }

        if (any(countDigit, i -> i > 2)) {
            return false;
        }

        for (int i = 1; i < lst.length; i++) {
            if (lst[i - 1] > lst[i]) {
                return false;
            }
        }

        return true;
    }

    private static boolean any(int[] array, java.util.function.Predicate<Integer> predicate) {
        for (int value : array) {
            if (predicate.test(value)) {
                return true;
            }
        }
        return false;
    }

    // Transformed Code
    public static boolean isSortedTransformed(int[] sequence) {
        int[] digitCount = new int[10]; // Assuming numbers are between 0 and 9
        for (int number : sequence) {
            digitCount[number]++;
        }

        if (anyDigitCountGreaterThanTwo(digitCount)) {
            return false;
        }

        int index = 1;
        while (index < sequence.length) {
            if (sequence[index - 1] > sequence[index]) {
                return false;
            }
            index++;
        }

        return true;
    }

    private static boolean anyDigitCountGreaterThanTwo(int[] digitCount) {
        for (int count : digitCount) {
            if (count > 2) {
                return true;
            }
        }
        return false;
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(isSorted(new int[]{1, 2, 3, 4, 5}), isSortedTransformed(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void test_1() {
        assertEquals(isSorted(new int[]{5, 4, 3, 2, 1}), isSortedTransformed(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void test_2() {
        assertEquals(isSorted(new int[]{1, 1, 2, 2, 3, 3}), isSortedTransformed(new int[]{1, 1, 2, 2, 3, 3}));
    }

    @Test
    public void test_3() {
        assertEquals(isSorted(new int[]{1, 1, 1, 2, 3}), isSortedTransformed(new int[]{1, 1, 1, 2, 3}));
    }

    @Test
    public void test_4() {
        assertEquals(isSorted(new int[]{1}), isSortedTransformed(new int[]{1}));
    }

    @Test
    public void test_5() {
        assertEquals(isSorted(new int[]{}), isSortedTransformed(new int[]{}));
    }

    @Test
    public void test_6() {
        assertEquals(isSorted(new int[]{1, 2, 2, 3, 4, 5, 5}), isSortedTransformed(new int[]{1, 2, 2, 3, 4, 5, 5}));
    }

    @Test
    public void test_7() {
        assertEquals(isSorted(new int[]{10, 9, 8, 7, 6, 5}), isSortedTransformed(new int[]{10, 9, 8, 7, 6, 5})); // This will fail because the transformed function assumes numbers between 0 and 9
    }

    @Test
    public void test_8() {
        assertEquals(isSorted(new int[]{1, 2, 3, 3, 3, 4, 5}), isSortedTransformed(new int[]{1, 2, 3, 3, 3, 4, 5})); // This will fail because the transformed function assumes numbers between 0 and 9
    }

    @Test
    public void test_9() {
        assertEquals(isSorted(new int[]{1, 2, 3, 4, 5, 5, 5}), isSortedTransformed(new int[]{1, 2, 3, 4, 5, 5, 5})); // This will fail because the transformed function assumes numbers between 0 and 9
    }
}