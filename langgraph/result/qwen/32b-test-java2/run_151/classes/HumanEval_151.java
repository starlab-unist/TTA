// Source Code
class HumanEval_151_Source {
    public static int doubleTheDifference(List<Integer> lst) {
        int sum = 0;
        for (int i : lst) {
            if (i > 0 && i % 2 != 0) {
                sum += i * i;
            }
        }
        return sum;
    }
}

// Transformed Code
class HumanEval_151_Transformed {
    public static int calculateModifiedSum(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            if (num > 0 && num % 2 != 0) {
                total += num * num;
            }
        }
        return total;
    }
}

// Test Cases
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HumanEval_151 {

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5), new int[]{1, 2, 3, 4, 5}),         // Mixed positive odd/even integers
            Arguments.of(Arrays.asList(-1, -3, -5, 0, 2, 4), new int[]{-1, -3, -5, 0, 2, 4}),   // Negative numbers and zero
            Arguments.of(Arrays.asList(7, 11, 13, 17), new int[]{7, 11, 13, 17}),         // Only positive odd integers
            Arguments.of(Arrays.asList(8, 10, 12, 14), new int[]{8, 10, 12, 14}),         // Only positive even integers
            Arguments.of(Arrays.asList(), new int[]{}),                      // Empty list
            Arguments.of(Arrays.asList(1, 1, 3, 3, 5, 5), new int[]{1, 1, 3, 3, 5, 5}),      // Mixed integers and floats (converted to int)
            Arguments.of(Arrays.asList(21, 23, 25, 0, -27), new int[]{21, 23, 25, 0, -27}),    // Positive odd integers with zero and negative
            Arguments.of(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1), new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}), // Descending order mixed odd/even integers
            Arguments.of(Arrays.asList(0), new int[]{0}),                      // Single element zero,
            Arguments.of(Arrays.asList(15, 20, 25, 30, 35), new int[]{15, 20, 25, 30, 35})     // Additional test case: only positive odd integers
        );
    }

    @DisplayName("Compare doubleTheDifference and calculateModifiedSum")
    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("provideTestCases")
    void testDoubleTheDifference_vs_calculateModifiedSum(List<Integer> inputList, int[] inputArray) {
        assertEquals(
            HumanEval_151_Source.doubleTheDifference(inputList),
            HumanEval_151_Transformed.calculateModifiedSum(inputArray)
        );
    }
}