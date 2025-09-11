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

import java.util.List;
import java.util.stream.Stream;

public class HumanEval_142 {

    // Source Code
    static class OriginalImpl {
        public static int sumSquares(List<Integer> lst) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < lst.size(); i++) {
                if (i % 3 == 0) {
                    result.add(lst.get(i) * lst.get(i));
                } else if (i % 4 == 0 && i % 3 != 0) {
                    result.add(lst.get(i) * lst.get(i) * lst.get(i));
                } else {
                    result.add(lst.get(i));
                }
            }
            int sum = 0;
            for (int num : result) {
                sum += num;
            }
            return sum;
        }
    }

    // Transformed Code
    static class TransformedImpl {
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
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, List.of(1, 2, 3, 4, 5)),          // Simple list with small integers
            Arguments.of(new int[]{0, 0, 0, 0, 0}, List.of(0, 0, 0, 0, 0)),          // List of zeros
            Arguments.of(new int[]{1, 1, 1, 1, 1}, List.of(1, 1, 1, 1, 1)),          // List of ones
            Arguments.of(new int[]{-1, -2, -3, -4, -5}, List.of(-1, -2, -3, -4, -5)),// Simple list with negative integers
            Arguments.of(new int[]{10, 20, 30, 40, 50}, List.of(10, 20, 30, 40, 50)), // List of larger integers
            Arguments.of(new int[]{9, 8, 7, 6, 5}, List.of(9, 8, 7, 6, 5)),          // Decreasing list of integers
            Arguments.of(new int[]{1, -1, 1, -1, 1}, List.of(1, -1, 1, -1, 1)),      // Alternating positive and negative integers
            Arguments.of(new int[]{}, List.of()),                                    // Empty list
            Arguments.of(new int[]{2, 3, 4, 5, 6, 7, 8}, List.of(2, 3, 4, 5, 6, 7, 8)),// Simple list with small integers
            Arguments.of(new int[]{5, 0, 10, 0, 15}, List.of(5, 0, 10, 0, 15))       // List containing zeros
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testSumSquares(int[] inputArray, List<Integer> inputList) {
        assertEquals(
            OriginalImpl.sumSquares(inputList), 
            TransformedImpl.calculateModifiedSum(inputArray)
        );
    }
}