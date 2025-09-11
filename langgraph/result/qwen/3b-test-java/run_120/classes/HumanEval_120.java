import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_120 {

    // Source Code
    public static int[] maximum(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, arr.length - k, arr.length);
    }

    // Transformed Code
    public static List<Integer> findTopKElements(List<Integer> sequence, int count) {
        if (count == 0) {
            return new ArrayList<>();
        }

        List<Integer> sortedSequence = new ArrayList<>(sequence);
        Collections.sort(sortedSequence);
        List<Integer> topElements = sortedSequence.subList(sortedSequence.size() - count, sortedSequence.size());

        return topElements;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3, 4, 5}, 3},
        {new int[]{5, 4, 3, 2, 1}, 2},
        {new int[]{10, 9, 8, 7, 6}, 5},
        {new int[]{1, 1, 1, 1, 1}, 3},
        {new int[]{}, 1},
        {new int[]{1, 2, 3}, 0},
        {new int[]{-1, -2, -3, -4}, 2},
        {new int[]{100, 200, 300, 400, 500}, 0},
        {new int[]{5, 5, 5, 5, 5, 5}, 6},
        {new int[]{10, 20, 30, 40, 50}, 1}
    };

    @Test
    public void test_0() {
        assertEquals(arrayToList(maximum((int[]) testCases[0][0], (int) testCases[0][1])), 
                     findTopKElements(intArrayToList((int[]) testCases[0][0]), (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(arrayToList(maximum((int[]) testCases[1][0], (int) testCases[1][1])), 
                     findTopKElements(intArrayToList((int[]) testCases[1][0]), (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(arrayToList(maximum((int[]) testCases[2][0], (int) testCases[2][1])), 
                     findTopKElements(intArrayToList((int[]) testCases[2][0]), (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(arrayToList(maximum((int[]) testCases[3][0], (int) testCases[3][1])), 
                     findTopKElements(intArrayToList((int[]) testCases[3][0]), (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(arrayToList(maximum((int[]) testCases[4][0], (int) testCases[4][1])), 
                     findTopKElements(intArrayToList((int[]) testCases[4][0]), (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(arrayToList(maximum((int[]) testCases[5][0], (int) testCases[5][1])), 
                     findTopKElements(intArrayToList((int[]) testCases[5][0]), (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(arrayToList(maximum((int[]) testCases[6][0], (int) testCases[6][1])), 
                     findTopKElements(intArrayToList((int[]) testCases[6][0]), (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(arrayToList(maximum((int[]) testCases[7][0], (int) testCases[7][1])), 
                     findTopKElements(intArrayToList((int[]) testCases[7][0]), (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(arrayToList(maximum((int[]) testCases[8][0], (int) testCases[8][1])), 
                     findTopKElements(intArrayToList((int[]) testCases[8][0]), (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(arrayToList(maximum((int[]) testCases[9][0], (int) testCases[9][1])), 
                     findTopKElements(intArrayToList((int[]) testCases[9][0]), (int) testCases[9][1]));
    }

    // Helper method to convert int array to List<Integer>
    private static List<Integer> intArrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

    // Helper method to convert int array to List<Integer>
    private static List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
}