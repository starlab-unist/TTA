import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_109 {

    // Source Code
    static class HumanEval_109_Source {
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
    static class HumanEval_109_Transformed {
        public boolean checkSortedAfterRotation(int[] sequence) {
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

        private int findPivotIndex(int[] sequence, int smallestElement) {
            for (int i = 0; i < sequence.length; i++) {
                if (sequence[i] == smallestElement) {
                    return i;
                }
            }
            return -1; // This line should never be reached if input assumptions are correct
        }
    }

    // Test Cases
    private static final Integer[][] testCases = {
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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void moveOneBall_vs_checkSortedAfterRotation(Integer[] inputArray) {
        boolean sourceResult = HumanEval_109_Source.moveOneBall(Arrays.asList(inputArray));
        boolean transformedResult = new HumanEval_109_Transformed().checkSortedAfterRotation(toIntArray(inputArray));
        assertEquals(sourceResult, transformedResult);
    }

    private static int[] toIntArray(Integer[] array) {
        if (array == null) return new int[0];
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] != null ? array[i] : 0;
        }
        return result;
    }
}