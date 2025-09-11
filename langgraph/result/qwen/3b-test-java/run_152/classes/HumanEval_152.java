import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_152 {

    // Source Code
    public static int[] compare(int[] game, int[] guess) {
        int[] result = new int[game.length];
        for (int i = 0; i < game.length; i++) {
            result[i] = Math.abs(game[i] - guess[i]);
        }
        return result;
    }

    // Transformed Code
    public static List<Double> evaluateDifference(double[] actual, double[] playerGuess) {
        List<Double> differences = new ArrayList<>();
        int index = 0;
        while (index < actual.length) {
            differences.add(Math.abs(actual[index] - playerGuess[index]));
            index++;
        }
        return differences;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3}, new int[]{1, 2, 3}},
        {new int[]{4, 5, 6}, new int[]{7, 8, 9}},
        {new int[]{0, 0, 0}, new int[]{1, 1, 1}},
        {new int[]{-1, -2, -3}, new int[]{-1, -2, -3}},
        {new int[]{10, 20, 30}, new int[]{30, 20, 10}},
        {new int[]{100, 200, 300}, new int[]{150, 250, 350}},
        {new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}},
        {new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}},
        {new int[]{0, 1, 2, 3, 4}, new int[]{4, 3, 2, 1, 0}},
        {new int[]{-5, -10, -15}, new int[]{-15, -10, -5}}
    };

    @Test
    public void test_0() {
        assertEquals(intArrayToList(compare((int[]) testCases[0][0], (int[]) testCases[0][1])), 
                     evaluateDifference(toDoubleArray((int[]) testCases[0][0]), toDoubleArray((int[]) testCases[0][1])));
    }

    @Test
    public void test_1() {
        assertEquals(intArrayToList(compare((int[]) testCases[1][0], (int[]) testCases[1][1])), 
                     evaluateDifference(toDoubleArray((int[]) testCases[1][0]), toDoubleArray((int[]) testCases[1][1])));
    }

    @Test
    public void test_2() {
        assertEquals(intArrayToList(compare((int[]) testCases[2][0], (int[]) testCases[2][1])), 
                     evaluateDifference(toDoubleArray((int[]) testCases[2][0]), toDoubleArray((int[]) testCases[2][1])));
    }

    @Test
    public void test_3() {
        assertEquals(intArrayToList(compare((int[]) testCases[3][0], (int[]) testCases[3][1])), 
                     evaluateDifference(toDoubleArray((int[]) testCases[3][0]), toDoubleArray((int[]) testCases[3][1])));
    }

    @Test
    public void test_4() {
        assertEquals(intArrayToList(compare((int[]) testCases[4][0], (int[]) testCases[4][1])), 
                     evaluateDifference(toDoubleArray((int[]) testCases[4][0]), toDoubleArray((int[]) testCases[4][1])));
    }

    @Test
    public void test_5() {
        assertEquals(intArrayToList(compare((int[]) testCases[5][0], (int[]) testCases[5][1])), 
                     evaluateDifference(toDoubleArray((int[]) testCases[5][0]), toDoubleArray((int[]) testCases[5][1])));
    }

    @Test
    public void test_6() {
        assertEquals(intArrayToList(compare((int[]) testCases[6][0], (int[]) testCases[6][1])), 
                     evaluateDifference(toDoubleArray((int[]) testCases[6][0]), toDoubleArray((int[]) testCases[6][1])));
    }

    @Test
    public void test_7() {
        assertEquals(intArrayToList(compare((int[]) testCases[7][0], (int[]) testCases[7][1])), 
                     evaluateDifference(toDoubleArray((int[]) testCases[7][0]), toDoubleArray((int[]) testCases[7][1])));
    }

    @Test
    public void test_8() {
        assertEquals(intArrayToList(compare((int[]) testCases[8][0], (int[]) testCases[8][1])), 
                     evaluateDifference(toDoubleArray((int[]) testCases[8][0]), toDoubleArray((int[]) testCases[8][1])));
    }

    @Test
    public void test_9() {
        assertEquals(intArrayToList(compare((int[]) testCases[9][0], (int[]) testCases[9][1])), 
                     evaluateDifference(toDoubleArray((int[]) testCases[9][0]), toDoubleArray((int[]) testCases[9][1])));
    }

    private List<Double> intArrayToList(int[] array) {
        List<Double> list = new ArrayList<>();
        for (int value : array) {
            list.add((double) value);
        }
        return list;
    }

    private double[] toDoubleArray(int[] array) {
        double[] doubleArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            doubleArray[i] = (double) array[i];
        }
        return doubleArray;
    }
}