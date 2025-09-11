import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_120 {

    // Source Code
    public static List<Integer> maximum(int[] arr, int k) {
        if (k == 0) {
            return Arrays.asList();
        }
        Arrays.sort(arr);
        List<Integer> ans = Arrays.stream(arr).skip(Math.max(0, arr.length - k)).boxed().collect(Collectors.toList());
        return ans;
    }

    // Transformed Code
    public static int[] findTopKElements(int[] sequence, int count) {
        if (count == 0) {
            return new int[0];
        }

        int[] sortedSequence = Arrays.copyOf(sequence, sequence.length);
        Arrays.sort(sortedSequence);
        int[] topElements = new int[count];
        System.arraycopy(sortedSequence, sortedSequence.length - count, topElements, 0, count);

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
        assertEquals(maximum((int[]) testCases[0][0], (int) testCases[0][1]).toString(), 
                     Arrays.toString(findTopKElements((int[]) testCases[0][0], (int) testCases[0][1])));
    }

    @Test
    public void test_1() {
        assertEquals(maximum((int[]) testCases[1][0], (int) testCases[1][1]).toString(), 
                     Arrays.toString(findTopKElements((int[]) testCases[1][0], (int) testCases[1][1])));
    }

    @Test
    public void test_2() {
        assertEquals(maximum((int[]) testCases[2][0], (int) testCases[2][1]).toString(), 
                     Arrays.toString(findTopKElements((int[]) testCases[2][0], (int) testCases[2][1])));
    }

    @Test
    public void test_3() {
        assertEquals(maximum((int[]) testCases[3][0], (int) testCases[3][1]).toString(), 
                     Arrays.toString(findTopKElements((int[]) testCases[3][0], (int) testCases[3][1])));
    }

    @Test
    public void test_4() {
        assertEquals(maximum((int[]) testCases[4][0], (int) testCases[4][1]).toString(), 
                     Arrays.toString(findTopKElements((int[]) testCases[4][0], (int) testCases[4][1])));
    }

    @Test
    public void test_5() {
        assertEquals(maximum((int[]) testCases[5][0], (int) testCases[5][1]).toString(), 
                     Arrays.toString(findTopKElements((int[]) testCases[5][0], (int) testCases[5][1])));
    }

    @Test
    public void test_6() {
        assertEquals(maximum((int[]) testCases[6][0], (int) testCases[6][1]).toString(), 
                     Arrays.toString(findTopKElements((int[]) testCases[6][0], (int) testCases[6][1])));
    }

    @Test
    public void test_7() {
        assertEquals(maximum((int[]) testCases[7][0], (int) testCases[7][1]).toString(), 
                     Arrays.toString(findTopKElements((int[]) testCases[7][0], (int) testCases[7][1])));
    }

    @Test
    public void test_8() {
        assertEquals(maximum((int[]) testCases[8][0], (int) testCases[8][1]).toString(), 
                     Arrays.toString(findTopKElements((int[]) testCases[8][0], (int) testCases[8][1])));
    }

    @Test
    public void test_9() {
        assertEquals(maximum((int[]) testCases[9][0], (int) testCases[9][1]).toString(), 
                     Arrays.toString(findTopKElements((int[]) testCases[9][0], (int) testCases[9][1])));
    }
}