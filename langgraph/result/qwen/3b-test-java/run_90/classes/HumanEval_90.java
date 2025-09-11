import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_90 {

    // Source Code
    public static Integer nextSmallest(List<Integer> lst) {
        List<Integer> sortedSet = new ArrayList<>(new HashSet<>(lst));
        Collections.sort(sortedSet);
        return sortedSet.size() < 2 ? null : sortedSet.get(1);
    }

    // Transformed Code
    public static Integer findSecondMinimum(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        // Convert the array to a set to remove duplicates and sort it
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            uniqueNumbers.add(number);
        }
        List<Integer> sortedUniqueNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(sortedUniqueNumbers);

        // Check if there are at least two unique numbers
        if (sortedUniqueNumbers.size() < 2) {
            return null;
        }

        // Return the second smallest number
        return sortedUniqueNumbers.get(1);
    }

    // Nested static classes for original and transformed implementations
    public static class OriginalImpl {
        public static Integer nextSmallest(List<Integer> lst) {
            List<Integer> sortedSet = new ArrayList<>(new HashSet<>(lst));
            Collections.sort(sortedSet);
            return sortedSet.size() < 2 ? null : sortedSet.get(1);
        }
    }

    public static class TransformedImpl {
        public static Integer findSecondMinimum(int[] numbers) {
            if (numbers == null || numbers.length < 2) {
                return null;
            }

            // Convert the array to a set to remove duplicates and sort it
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (int number : numbers) {
                uniqueNumbers.add(number);
            }
            List<Integer> sortedUniqueNumbers = new ArrayList<>(uniqueNumbers);
            Collections.sort(sortedUniqueNumbers);

            // Check if there are at least two unique numbers
            if (sortedUniqueNumbers.size() < 2) {
                return null;
            }

            // Return the second smallest number
            return sortedUniqueNumbers.get(1);
        }
    }

    // Test cases provider method
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(3, 1, 4, 1, 5, 9), new int[]{3, 1, 4, 1, 5, 9}, 3),
            Arguments.of(List.of(10, 20, 20, 10, 30), new int[]{10, 20, 20, 10, 30}, 20),
            Arguments.of(List.of(1, 2, 3, 4, 5), new int[]{1, 2, 3, 4, 5}, 2),
            Arguments.of(List.of(5, 5, 5, 5, 5), new int[]{5, 5, 5, 5, 5}, null),
            Arguments.of(List.of(7), new int[]{7}, null),
            Arguments.of(List.of(), new int[]{}, null),
            Arguments.of(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1), new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 2),
            Arguments.of(List.of(0, -1, -2, -3, -4), new int[]{0, -1, -2, -3, -4}, -3),
            Arguments.of(List.of(-10, -20, -10, -30, -20), new int[]{-10, -20, -10, -30, -20}, -20),
            Arguments.of(List.of(100, 200, 300, 100, 200, 300), new int[]{100, 200, 300, 100, 200, 300}, 200)
        );
    }

    // Parameterized test method
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(List<Integer> inputList, int[] inputArray, Integer expected) {
        assertEquals(OriginalImpl.nextSmallest(inputList), TransformedImpl.findSecondMinimum(inputArray));
    }
}