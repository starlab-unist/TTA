import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays; // Added import statement for Arrays
import java.util.stream.Stream;

public class HumanEval_43 {

    // Source Code
    static class HumanEval_43_Source {
        public static boolean pairsSumToZero(int[] l) {
            for (int i = 0; i < l.length; i++) {
                for (int j = i + 1; j < l.length; j++) {
                    if (l[i] + l[j] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class HumanEval_43_Transformed {
        public boolean checkForZeroSumPairs(int[] numbers) {
            int index = 0;
            while (index < numbers.length) {
                int currentNumber = numbers[index];
                int nextIndex = index + 1;
                while (nextIndex < numbers.length) {
                    if (currentNumber + numbers[nextIndex] == 0) {
                        return true;
                    }
                    nextIndex++;
                }
                index++;
            }
            return false;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{}, false},
        {new int[]{1, -1}, true},
        {new int[]{2, 3, -2}, true},
        {new int[]{0, 0}, true},
        {new int[]{5, 7, 9}, false},
        {new int[]{-5, -7, -9}, false},
        {new int[]{1, 2, 3, -3}, true},
        {new int[]{10, 20, -10, 30}, true},
        {new int[]{4, 5, 6, 7, 8}, false},
        {new int[]{0, 1, 2, 3, 4, 5, -5}, true}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void pairsSumToZero_vs_checkForZeroSumPairs(int[] inputArray, boolean expected) {
        assertEquals(
            HumanEval_43_Source.pairsSumToZero(inputArray),
            new HumanEval_43_Transformed().checkForZeroSumPairs(inputArray)
        );
    }
}