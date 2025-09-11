import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HumanEval_116 {

    // Source Code
    public static int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(arr, Comparator.comparingInt(x -> Integer.bitCount(x)));
        return arr;
    }

    // Transformed Code
    public static int[] arrangeByBinaryOnes(int[] sequence) {
        Arrays.sort(sequence);
        Arrays.sort(sequence, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return countOnesInBinary(a) - countOnesInBinary(b);
            }
        });
        return sequence;
    }

    private static int countOnesInBinary(int number) {
        return Integer.bitCount(number);
    }

    // Test Cases
    private static final int[][] testCases = {
        {3, 7, 8, 9},          // Mixed numbers with different binary '1' counts
        {5, 3, 15, 7, 2},      // Numbers with varying binary '1' counts
        {0, 1, 2, 3, 4, 5, 6}, // Sequential numbers starting from 0
        {10, 20, 30, 40, 50},  // Multiples of 10
        {31, 14, 7, 3, 1},     // Descending powers of 2 minus 1
        {64, 128, 256, 512},   // Powers of 2
        {1, 1, 1, 1},          // All ones
        {0, 0, 0, 0},          // All zeros
        {13, 9, 5, 7, 11},     // Mixed numbers with same '1' count in binary
        {2, 4, 8, 16, 32}      // Powers of 2 starting from 2^1
    };

    @Test
    public void test_0() {
        assertArrayEquals(sortArray(testCases[0]), arrangeByBinaryOnes(testCases[0]));
    }

    @Test
    public void test_1() {
        assertArrayEquals(sortArray(testCases[1]), arrangeByBinaryOnes(testCases[1]));
    }

    @Test
    public void test_2() {
        assertArrayEquals(sortArray(testCases[2]), arrangeByBinaryOnes(testCases[2]));
    }

    @Test
    public void test_3() {
        assertArrayEquals(sortArray(testCases[3]), arrangeByBinaryOnes(testCases[3]));
    }

    @Test
    public void test_4() {
        assertArrayEquals(sortArray(testCases[4]), arrangeByBinaryOnes(testCases[4]));
    }

    @Test
    public void test_5() {
        assertArrayEquals(sortArray(testCases[5]), arrangeByBinaryOnes(testCases[5]));
    }

    @Test
    public void test_6() {
        assertArrayEquals(sortArray(testCases[6]), arrangeByBinaryOnes(testCases[6]));
    }

    @Test
    public void test_7() {
        assertArrayEquals(sortArray(testCases[7]), arrangeByBinaryOnes(testCases[7]));
    }

    @Test
    public void test_8() {
        assertArrayEquals(sortArray(testCases[8]), arrangeByBinaryOnes(testCases[8]));
    }

    @Test
    public void test_9() {
        assertArrayEquals(sortArray(testCases[9]), arrangeByBinaryOnes(testCases[9]));
    }
}