import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_109 {

    // Source Code
    public static boolean moveOneBall(int[] arr) {
        if (arr.length == 0) {
            return true;
        }
        
        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArray);
        
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }
        
        int[] myArr = new int[arr.length];
        System.arraycopy(arr, minIndex, myArr, 0, arr.length - minIndex);
        System.arraycopy(arr, 0, myArr, arr.length - minIndex, minIndex);
        
        for (int i = 0; i < arr.length; i++) {
            if (myArr[i] != sortedArray[i]) {
                return false;
            }
        }
        
        return true;
    }

    // Transformed Code
    public static boolean checkSortedAfterRotation(int[] sequence) {
        if (sequence.length == 0) {
            return true;
        }

        int[] orderedSequence = sequence.clone();
        Arrays.sort(orderedSequence);
        int smallestElement = orderedSequence[0];
        int pivotIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == smallestElement) {
                pivotIndex = i;
                break;
            }
        }

        int[] rotatedSequence = new int[sequence.length];
        System.arraycopy(sequence, pivotIndex, rotatedSequence, 0, sequence.length - pivotIndex);
        System.arraycopy(sequence, 0, rotatedSequence, sequence.length - pivotIndex, pivotIndex);

        for (int i = 0; i < sequence.length; i++) {
            if (rotatedSequence[i] != orderedSequence[i]) {
                return false;
            }
        }

        return true;
    }

    // Test Cases
    private static final int[][] testCases = {
        {},
        {1},
        {2, 1},
        {3, 2, 1},
        {1, 2, 3},
        {4, 5, 6, 1, 2, 3},
        {2, 3, 4, 5, 6, 1},
        {1, 3, 2},
        {5, 1, 2, 3, 4},
        {10, 20, 30, 40, 50}
    };

    @Test
    public void test_0() {
        assertEquals(moveOneBall(testCases[0]), checkSortedAfterRotation(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(moveOneBall(testCases[1]), checkSortedAfterRotation(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(moveOneBall(testCases[2]), checkSortedAfterRotation(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(moveOneBall(testCases[3]), checkSortedAfterRotation(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(moveOneBall(testCases[4]), checkSortedAfterRotation(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(moveOneBall(testCases[5]), checkSortedAfterRotation(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(moveOneBall(testCases[6]), checkSortedAfterRotation(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(moveOneBall(testCases[7]), checkSortedAfterRotation(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(moveOneBall(testCases[8]), checkSortedAfterRotation(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(moveOneBall(testCases[9]), checkSortedAfterRotation(testCases[9]));
    }
}