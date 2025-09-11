import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_109 {

    // Original Implementation
    public static class OriginalImpl {
        public static boolean moveOneBall(int[] arr) {
            if (arr.length == 0) {
                return true;
            }
            
            int[] sortedArray = Arrays.copyOf(arr, arr.length);
            Arrays.sort(sortedArray);
            
            int minValue = Arrays.stream(arr).min().orElse(0);
            int minIndex = findIndex(arr, minValue);
            
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
        
        private static int findIndex(int[] arr, int value) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == value) {
                    return i;
                }
            }
            return -1; // Should never reach here if minValue is in arr
        }
    }

    // Transformed Implementation
    public static class TransformedImpl {
        public static boolean checkSortedAfterRotation(int[] sequence) {
            if (sequence.length == 0) {
                return true;
            }

            int[] orderedSequence = Arrays.copyOf(sequence, sequence.length);
            Arrays.sort(orderedSequence);
            int smallestElement = Arrays.stream(sequence).min().orElse(Integer.MAX_VALUE);
            int pivotIndex = findIndex(sequence, smallestElement);

            int[] rotatedSequence = new int[sequence.length];
            System.arraycopy(sequence, pivotIndex, rotatedSequence, 0, sequence.length - pivotIndex);
            System.arraycopy(sequence, 0, rotatedSequence, sequence.length - pivotIndex, pivotIndex);

            for (int idx = 0; idx < sequence.length; idx++) {
                if (rotatedSequence[idx] != orderedSequence[idx]) {
                    return false;
                }
            }

            return true;
        }

        private static int findIndex(int[] array, int value) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value) {
                    return i;
                }
            }
            return -1;
        }
    }

    // Test Cases
    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.arguments(new int[]{}),
            Arguments.arguments(new int[]{1}),
            Arguments.arguments(new int[]{2, 1}),
            Arguments.arguments(new int[]{3, 2, 1}),
            Arguments.arguments(new int[]{1, 2, 3}),
            Arguments.arguments(new int[]{4, 5, 6, 1, 2, 3}),
            Arguments.arguments(new int[]{2, 3, 4, 5, 6, 1}),
            Arguments.arguments(new int[]{1, 3, 2}),
            Arguments.arguments(new int[]{5, 1, 2, 3, 4}),
            Arguments.arguments(new int[]{10, 20, 30, 40, 50})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMoveOneBallAndCheckSortedAfterRotation(int[] input) {
        assertEquals(OriginalImpl.moveOneBall(input), TransformedImpl.checkSortedAfterRotation(input));
    }
}