import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

// Source Code
class HumanEval_120 {

    // Original Implementation
    static class OriginalImpl {
        public static List<Integer> maximum(int[] arr, int k) {
            if (k == 0) {
                return new ArrayList<>();
            }
            Arrays.sort(arr);
            List<Integer> ans = new ArrayList<>();
            for (int i = arr.length - k; i < arr.length; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }
    }

    // Transformed Implementation
    static class TransformedImpl {
        public static List<Integer> findTopKElements(List<Integer> sequence, int count) {
            if (count == 0) {
                return new ArrayList<>();
            }

            List<Integer> sortedSequence = new ArrayList<>(sequence);
            java.util.Collections.sort(sortedSequence);
            List<Integer> topElements = sortedSequence.subList(sortedSequence.size() - count, sortedSequence.size());

            return topElements;
        }
    }

    // Test Cases
    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.arguments(new int[]{1, 2, 3, 4, 5}, 3),
            Arguments.arguments(new int[]{5, 4, 3, 2, 1}, 2),
            Arguments.arguments(new int[]{10, 9, 8, 7, 6}, 5),
            Arguments.arguments(new int[]{1, 1, 1, 1, 1}, 3),
            Arguments.arguments(new int[]{}, 1),
            Arguments.arguments(new int[]{1, 2, 3}, 0),
            Arguments.arguments(new int[]{-1, -2, -3, -4}, 2),
            Arguments.arguments(new int[]{100, 200, 300, 400, 500}, 0),
            Arguments.arguments(new int[]{5, 5, 5, 5, 5, 5}, 6),
            Arguments.arguments(new int[]{10, 20, 30, 40, 50}, 1)
        );
    }

    // Test Method
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testEquivalence(int[] inputArray, int k) {
        List<Integer> resultOriginal = OriginalImpl.maximum(inputArray, k);
        List<Integer> resultTransformed = TransformedImpl.findTopKElements(Arrays.stream(inputArray).boxed().toList(), k);

        assertEquals(resultOriginal, resultTransformed);
    }
}