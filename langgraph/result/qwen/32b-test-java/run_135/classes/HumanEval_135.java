import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

public class HumanEval_135 {

    // Source Code
    static class HumanEval_135 {
        public int canArrange(int[] arr) {
            int ind = -1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    ind = i;
                }
            }
            return ind;
        }
    }

    // Transformed Code
    static class HumanEval_135_Transformed {
        public int findFirstDecreaseIndex(int[] sequence) {
            int position = -1;
            int index = 1;
            while (index < sequence.length) {
                if (sequence[index] < sequence[index - 1]) {
                    position = index;
                }
                index++;
            }
            return position;
        }
    }

    // Test Cases
    private static final Integer[][] testCases = {
        {1, 2, 3, 4, 5},
        {5, 4, 3, 2, 1},
        {1, 3, 2, 4, 5},
        {10, 20, 30, 25, 40},
        {1, 1, 1, 1, 1},
        {1, 2, 3, 3, 2},
        {1},
        {},
        {7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1},
        {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void canArrange_vs_findFirstDecreaseIndex(Integer[] input) {
        int[] inputArray = toIntArray(input);
        assertEquals(
            new HumanEval_135().canArrange(inputArray),
            new HumanEval_135_Transformed().findFirstDecreaseIndex(inputArray)
        );
    }

    private static int[] toIntArray(Integer[] array) {
        if (array == null) return new int[0];
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                result[i] = array[i];
            } else {
                result[i] = 0; // or handle as needed
            }
        }
        return result;
    }
}