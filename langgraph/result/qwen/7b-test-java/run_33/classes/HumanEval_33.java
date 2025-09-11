import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_33 {

    // Source Code
    static class HumanEval_33_Source {
        public static int[] sortThird(int[] arr) {
            int[] thirdElements = new int[arr.length / 3];
            for (int i = 0; i < thirdElements.length; i++) {
                thirdElements[i] = arr[i * 3];
            }
            Arrays.sort(thirdElements);
            for (int i = 0; i < thirdElements.length; i++) {
                arr[i * 3] = thirdElements[i];
            }
            return arr;
        }
    }

    // Transformed Code
    static class HumanEval_33_Transformed {
        public static ArrayList<Integer> sortThird(ArrayList<Integer> l) {
            ArrayList<Integer> elementsToSort = new ArrayList<>();
            for (int i = 0; i < l.size(); i += 3) {
                elementsToSort.add(l.get(i));
            }
            Collections.sort(elementsToSort);
            ArrayList<Integer> resultList = new ArrayList<>(l);
            for (int i = 0, j = 0; i < resultList.size(); i += 3, ++j) {
                resultList.set(i, elementsToSort.get(j));
            }
            return resultList;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {9, 2, 3, 6, 5, 4, 1, 8, 7},
        {10, 20, 30, 40, 50, 60, 70, 80, 90},
        {1, 2, 3},
        {3, 2, 1, 6, 5, 4, 9, 8, 7},
        {},
        {5},
        {5, 10},
        {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5},
        {7, 8, 9, 1, 2, 3, 4, 5, 6},
        {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    @Test
    public void test_0() {
        int[] input = testCases[0];
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int value : input) {
            inputList.add(value);
        }
        assertEquals(Arrays.toString(HumanEval_33_Source.sortThird(input)), 
                     HumanEval_33_Transformed.sortThird(new ArrayList<>(inputList)).toString());
    }

    @Test
    public void test_1() {
        int[] input = testCases[1];
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int value : input) {
            inputList.add(value);
        }
        assertEquals(Arrays.toString(HumanEval_33_Source.sortThird(input)), 
                     HumanEval_33_Transformed.sortThird(new ArrayList<>(inputList)).toString());
    }

    @Test
    public void test_2() {
        int[] input = testCases[2];
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int value : input) {
            inputList.add(value);
        }
        assertEquals(Arrays.toString(HumanEval_33_Source.sortThird(input)), 
                     HumanEval_33_Transformed.sortThird(new ArrayList<>(inputList)).toString());
    }

    @Test
    public void test_3() {
        int[] input = testCases[3];
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int value : input) {
            inputList.add(value);
        }
        assertEquals(Arrays.toString(HumanEval_33_Source.sortThird(input)), 
                     HumanEval_33_Transformed.sortThird(new ArrayList<>(inputList)).toString());
    }

    @Test
    public void test_4() {
        int[] input = testCases[4];
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int value : input) {
            inputList.add(value);
        }
        assertEquals(Arrays.toString(HumanEval_33_Source.sortThird(input)), 
                     HumanEval_33_Transformed.sortThird(new ArrayList<>(inputList)).toString());
    }

    @Test
    public void test_5() {
        int[] input = testCases[5];
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int value : input) {
            inputList.add(value);
        }
        assertEquals(Arrays.toString(HumanEval_33_Source.sortThird(input)), 
                     HumanEval_33_Transformed.sortThird(new ArrayList<>(inputList)).toString());
    }

    @Test
    public void test_6() {
        int[] input = testCases[6];
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int value : input) {
            inputList.add(value);
        }
        assertEquals(Arrays.toString(HumanEval_33_Source.sortThird(input)), 
                     HumanEval_33_Transformed.sortThird(new ArrayList<>(inputList)).toString());
    }

    @Test
    public void test_7() {
        int[] input = testCases[7];
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int value : input) {
            inputList.add(value);
        }
        assertEquals(Arrays.toString(HumanEval_33_Source.sortThird(input)), 
                     HumanEval_33_Transformed.sortThird(new ArrayList<>(inputList)).toString());
    }

    @Test
    public void test_8() {
        int[] input = testCases[8];
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int value : input) {
            inputList.add(value);
        }
        assertEquals(Arrays.toString(HumanEval_33_Source.sortThird(input)), 
                     HumanEval_33_Transformed.sortThird(new ArrayList<>(inputList)).toString());
    }

    @Test
    public void test_9() {
        int[] input = testCases[9];
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int value : input) {
            inputList.add(value);
        }
        assertEquals(Arrays.toString(HumanEval_33_Source.sortThird(input)), 
                     HumanEval_33_Transformed.sortThird(new ArrayList<>(inputList)).toString());
    }

}