import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_116 {

    // Source Code
    public static int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(arr, (a, b) -> Integer.bitCount(a) - Integer.bitCount(b));
        return arr;
    }

    // Transformed Code
    public static ArrayList<Integer> arrangeByBinaryOnes(ArrayList<Integer> sequence) {
        ArrayList<Integer> sortedSequence = new ArrayList<>(sequence);
        Collections.sort(sortedSequence, (a, b) -> Integer.compare(countOnesInBinary(a), countOnesInBinary(b)));
        return sortedSequence;
    }

    private static int countOnesInBinary(int number) {
        return Integer.bitCount(number);
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{3, 7, 8, 9}},
        {new int[]{5, 3, 15, 7, 2}},
        {new int[]{0, 1, 2, 3, 4, 5, 6}},
        {new int[]{10, 20, 30, 40, 50}},
        {new int[]{31, 14, 7, 3, 1}},
        {new int[]{64, 128, 256, 512}},
        {new int[]{1, 1, 1, 1}},
        {new int[]{0, 0, 0, 0}},
        {new int[]{13, 9, 5, 7, 11}},
        {new int[]{2, 4, 8, 16, 32}}
    };

    @Test
    public void test_0() {
        assertEquals(Arrays.toString(sortArray((int[]) testCases[0][0])), 
                     arrangeByBinaryOnes(new ArrayList<>(Arrays.asList(Arrays.stream((int[]) testCases[0][0]).boxed().toArray(Integer[]::new)))).toString());
    }

    @Test
    public void test_1() {
        assertEquals(Arrays.toString(sortArray((int[]) testCases[1][0])), 
                     arrangeByBinaryOnes(new ArrayList<>(Arrays.asList(Arrays.stream((int[]) testCases[1][0]).boxed().toArray(Integer[]::new)))).toString());
    }

    @Test
    public void test_2() {
        assertEquals(Arrays.toString(sortArray((int[]) testCases[2][0])), 
                     arrangeByBinaryOnes(new ArrayList<>(Arrays.asList(Arrays.stream((int[]) testCases[2][0]).boxed().toArray(Integer[]::new)))).toString());
    }

    @Test
    public void test_3() {
        assertEquals(Arrays.toString(sortArray((int[]) testCases[3][0])), 
                     arrangeByBinaryOnes(new ArrayList<>(Arrays.asList(Arrays.stream((int[]) testCases[3][0]).boxed().toArray(Integer[]::new)))).toString());
    }

    @Test
    public void test_4() {
        assertEquals(Arrays.toString(sortArray((int[]) testCases[4][0])), 
                     arrangeByBinaryOnes(new ArrayList<>(Arrays.asList(Arrays.stream((int[]) testCases[4][0]).boxed().toArray(Integer[]::new)))).toString());
    }

    @Test
    public void test_5() {
        assertEquals(Arrays.toString(sortArray((int[]) testCases[5][0])), 
                     arrangeByBinaryOnes(new ArrayList<>(Arrays.asList(Arrays.stream((int[]) testCases[5][0]).boxed().toArray(Integer[]::new)))).toString());
    }

    @Test
    public void test_6() {
        assertEquals(Arrays.toString(sortArray((int[]) testCases[6][0])), 
                     arrangeByBinaryOnes(new ArrayList<>(Arrays.asList(Arrays.stream((int[]) testCases[6][0]).boxed().toArray(Integer[]::new)))).toString());
    }

    @Test
    public void test_7() {
        assertEquals(Arrays.toString(sortArray((int[]) testCases[7][0])), 
                     arrangeByBinaryOnes(new ArrayList<>(Arrays.asList(Arrays.stream((int[]) testCases[7][0]).boxed().toArray(Integer[]::new)))).toString());
    }

    @Test
    public void test_8() {
        assertEquals(Arrays.toString(sortArray((int[]) testCases[8][0])), 
                     arrangeByBinaryOnes(new ArrayList<>(Arrays.asList(Arrays.stream((int[]) testCases[8][0]).boxed().toArray(Integer[]::new)))).toString());
    }

    @Test
    public void test_9() {
        assertEquals(Arrays.toString(sortArray((int[]) testCases[9][0])), 
                     arrangeByBinaryOnes(new ArrayList<>(Arrays.asList(Arrays.stream((int[]) testCases[9][0]).boxed().toArray(Integer[]::new)))).toString());
    }
}