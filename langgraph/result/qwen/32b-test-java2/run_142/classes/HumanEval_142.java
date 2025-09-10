import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_142 {

    // Source Code
    static class HumanEval_142_Source {
        public static int sumSquares(List<Integer> lst) {
            int sum = 0;
            for (int i = 0; i < lst.size(); i++) {
                int value;
                if (i % 3 == 0) {
                    value = lst.get(i) * lst.get(i);
                } else if (i % 4 == 0) {
                    value = lst.get(i) * lst.get(i) * lst.get(i);
                } else {
                    value = lst.get(i);
                }
                sum += value;
            }
            return sum;
        }
    }

    // Transformed Code
    static class HumanEval_142_Transformed {
        public static int calculateModifiedSum(int[] numbers) {
            int total = 0;
            int index = 0;
            while (index < numbers.length) {
                if (index % 3 == 0) {
                    total += Math.pow(numbers[index], 2);
                } else if (index % 4 == 0) {
                    total += Math.pow(numbers[index], 3);
                } else {
                    total += numbers[index];
                }
                index++;
            }
            return total;
        }
    }

    // Test Cases
    private static final Integer[][] testCases = {
        {1, 2, 3, 4, 5},          // Simple list with small integers
        {0, 0, 0, 0, 0},          // List of zeros
        {1, 1, 1, 1, 1},          // List of ones
        {-1, -2, -3, -4, -5},     // Simple list with negative integers
        {10, 20, 30, 40, 50},     // List of larger integers
        {9, 8, 7, 6, 5},          // Decreasing list of integers
        {1, -1, 1, -1, 1},        // Alternating positive and negative integers
        {},                       // Empty list
        {2, 3, 4, 5, 6, 7, 8},    // Simple list with small integers
        {5, 0, 10, 0, 15}         // List containing zeros
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("provideTestCases")
    void sumSquares_vs_calculateModifiedSum(Integer[] inputArray) {
        List<Integer> inputList = Arrays.asList(inputArray);
        int[] inputIntArray = Arrays.stream(inputArray).mapToInt(i -> i).toArray();
        
        assertEquals(
            HumanEval_142_Source.sumSquares(inputList),
            HumanEval_142_Transformed.calculateModifiedSum(inputIntArray)
        );
    }
}