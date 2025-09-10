import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;  // Added import statement for Arrays

public class HumanEval_69 {

    // Source Code
    static class HumanEval_69_Source {
        public static int search(int[] lst) {
            int maxVal = 0;
            for (int num : lst) {
                if (num > maxVal) {
                    maxVal = num;
                }
            }

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
    static class HumanEval_69_Transformed {
        public int findMaxFrequencyIndex(int[] numbers) {
            int maxValue = 0;
            for (int number : numbers) {
                if (number > maxValue) {
                    maxValue = number;
                }
            }
            
            int[] frequencyArray = new int[maxValue + 1];
            
            for (int number : numbers) {
                frequencyArray[number] += 1;
            }

            int result = -1;
            int index = 1;
            while (index < frequencyArray.length) {
                if (frequencyArray[index] >= index) {
                    result = index;
                }
                index += 1;
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
        {}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void search_vs_findMaxFrequencyIndex(int[] input) {
        assertEquals(
            HumanEval_69_Source.search(input),
            new HumanEval_69_Transformed().findMaxFrequencyIndex(input)
        );
    }
}