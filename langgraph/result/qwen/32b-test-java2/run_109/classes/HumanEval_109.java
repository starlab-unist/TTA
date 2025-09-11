import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
// Source Code
static class OriginalImpl {
    public static boolean moveOneBall(List<Integer> arr) {
        if (arr.isEmpty()) {
            return true;
        }
        
        Integer[] sortedArray = arr.toArray(new Integer[0]);
        Arrays.sort(sortedArray);
        
        int minValue = Collections.min(arr);
        int minIndex = arr.indexOf(minValue);
        
        List<Integer> myArr = new ArrayList<>(arr.subList(minIndex, arr.size()));
        myArr.addAll(arr.subList(0, minIndex));
        
        for (int i = 0; i < arr.size(); i++) {
            if (!myArr.get(i).equals(sortedArray[i])) {
                return false;
            }
        }
        return true;
    }
}

// Transformed Code
static class TransformedImpl {
    public static boolean checkSortedAfterRotation(int[] sequence) {
        if (sequence.length == 0) {
            return true;
        }

        int[] orderedSequence = Arrays.copyOf(sequence, sequence.length);
        Arrays.sort(orderedSequence);
        int smallestElement = Arrays.stream(sequence).min().getAsInt();
        int pivotIndex = findPivotIndex(sequence, smallestElement);

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

    private static int findPivotIndex(int[] sequence, int smallestElement) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == smallestElement) {
                return i;
            }
        }
        return -1; // This line should never be reached if input assumptions are correct
    }
}

// Test Cases
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_109 {

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new ArrayList<Integer>()),
            Arguments.of(List.of(1)),
            Arguments.of(List.of(2, 1)),
            Arguments.of(List.of(3, 2, 1)),
            Arguments.of(List.of(1, 2, 3)),
            Arguments.of(List.of(4, 5, 6, 1, 2, 3)),
            Arguments.of(List.of(2, 3, 4, 5, 6, 1)),
            Arguments.of(List.of(1, 3, 2)),
            Arguments.of(List.of(5, 1, 2, 3, 4)),
            Arguments.of(List.of(10, 20, 30, 40, 50))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMoveOneBallAndCheckSortedAfterRotation(List<Integer> input) {
        boolean originalResult = OriginalImpl.moveOneBall(input);
        boolean transformedResult = TransformedImpl.checkSortedAfterRotation(input.stream().mapToInt(i -> i).toArray());
        
        assertEquals(originalResult, transformedResult);
    }
}