import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_69 {

    // Source Code
    static class SourceCode {
        public static int search(int[] lst) {
            int maxVal = Arrays.stream(lst).max().orElse(0);
            int[] frq = new int[maxVal + 1];
            
            for (int i : lst) {
                frq[i]++;
            }

            int ans = -1;
            for (int i = 1; i < frq.length; i++) {
                if (frq[i] >= i) {
                    ans = i;
                }
            }
            
            return ans;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int findMaxFrequencyIndex(int[] numbers) {
            int maxValue = Arrays.stream(numbers).max().orElse(0);
            int[] frequencyArray = new int[maxValue + 1];
            
            for (int number : numbers) {
                frequencyArray[number]++;
            }

            int result = -1;
            int index = 1;
            while (index < frequencyArray.length) {
                if (frequencyArray[index] >= index) {
                    result = index;
                }
                index++;
            }

            return result;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 2, 3, 3, 3},
        {4, 5, 6, 7, 8, 9, 10},
        {1, 1, 1, 1, 1},
        {2, 2, 3, 3, 4, 4, 4, 4},
        {1, 2, 3, 4, 5},
        {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
        {1, 1, 2, 2, 2, 3, 3, 3, 3},
        {5, 5, 5, 5, 5, 5},
        {1},
        {},
        {6, 6, 6, 6, 6, 6, 6},
        {2, 3, 4, 5, 6, 7},
        {8, 8, 8, 8, 8, 8, 8, 8},
        {1, 1, 1, 2, 2, 2, 2, 2, 3},
        {9}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void search_vs_findMaxFrequencyIndex(int[] inputArray) {
        assertEquals(
            SourceCode.search(inputArray),
            TransformedCode.findMaxFrequencyIndex(inputArray)
        );
    }
}