import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_116 {

    // Source Code
    static class HumanEval_116_Source {
        public static int[] sortArray(int[] arr) {
            Integer[] wrappedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            
            Arrays.sort(wrappedArray, Comparator.comparingInt((Integer x) -> Integer.bitCount(x)));
            
            return Arrays.stream(wrappedArray).mapToInt(Integer::intValue).toArray();
        }
    }

    // Transformed Code
    static class HumanEval_116_Transformed {
        public static int[] arrangeByBinaryOnes(int[] sequence) {
            return Arrays.stream(sequence)
                         .boxed()
                         .sorted(Comparator.comparingInt(HumanEval_116_Transformed::countOnesInBinary))
                         .mapToInt(Integer::intValue)
                         .toArray();
        }

        private static int countOnesInBinary(int number) {
            return Integer.bitCount(number);
        }
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
        assertEquals(Arrays.toString(HumanEval_116_Source.sortArray(testCases[0])), 
                     Arrays.toString(new HumanEval_116_Transformed().arrangeByBinaryOnes(testCases[0])));
    }

    @Test
    public void test_1() {
        assertEquals(Arrays.toString(HumanEval_116_Source.sortArray(testCases[1])), 
                     Arrays.toString(new HumanEval_116_Transformed().arrangeByBinaryOnes(testCases[1])));
    }

    @Test
    public void test_2() {
        assertEquals(Arrays.toString(HumanEval_116_Source.sortArray(testCases[2])), 
                     Arrays.toString(new HumanEval_116_Transformed().arrangeByBinaryOnes(testCases[2])));
    }

    @Test
    public void test_3() {
        assertEquals(Arrays.toString(HumanEval_116_Source.sortArray(testCases[3])), 
                     Arrays.toString(new HumanEval_116_Transformed().arrangeByBinaryOnes(testCases[3])));
    }

    @Test
    public void test_4() {
        assertEquals(Arrays.toString(HumanEval_116_Source.sortArray(testCases[4])), 
                     Arrays.toString(new HumanEval_116_Transformed().arrangeByBinaryOnes(testCases[4])));
    }

    @Test
    public void test_5() {
        assertEquals(Arrays.toString(HumanEval_116_Source.sortArray(testCases[5])), 
                     Arrays.toString(new HumanEval_116_Transformed().arrangeByBinaryOnes(testCases[5])));
    }

    @Test
    public void test_6() {
        assertEquals(Arrays.toString(HumanEval_116_Source.sortArray(testCases[6])), 
                     Arrays.toString(new HumanEval_116_Transformed().arrangeByBinaryOnes(testCases[6])));
    }

    @Test
    public void test_7() {
        assertEquals(Arrays.toString(HumanEval_116_Source.sortArray(testCases[7])), 
                     Arrays.toString(new HumanEval_116_Transformed().arrangeByBinaryOnes(testCases[7])));
    }

    @Test
    public void test_8() {
        assertEquals(Arrays.toString(HumanEval_116_Source.sortArray(testCases[8])), 
                     Arrays.toString(new HumanEval_116_Transformed().arrangeByBinaryOnes(testCases[8])));
    }

    @Test
    public void test_9() {
        assertEquals(Arrays.toString(HumanEval_116_Source.sortArray(testCases[9])), 
                     Arrays.toString(new HumanEval_116_Transformed().arrangeByBinaryOnes(testCases[9])));
    }
}