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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_120 {

    // Source Code
    static class OriginalImpl {
        public static List<Integer> maximum(List<Integer> arr, int k) {
            if (k == 0) {
                return Arrays.asList();
            }
            arr.sort(Integer::compareTo);
            return arr.subList(arr.size() - k, arr.size());
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static List<Integer> findTopKElements(List<Integer> sequence, int count) {
            if (count == 0) {
                return new java.util.ArrayList<>();
            }

            List<Integer> sortedSequence = new java.util.ArrayList<>(sequence);
            Collections.sort(sortedSequence);
            List<Integer> topElements = sortedSequence.subList(sortedSequence.size() - count, sortedSequence.size());

            return topElements;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5), 3),
                Arguments.arguments(Arrays.asList(5, 4, 3, 2, 1), 2),
                Arguments.arguments(Arrays.asList(10, 9, 8, 7, 6), 5),
                Arguments.arguments(Arrays.asList(1, 1, 1, 1, 1), 3),
                Arguments.arguments(Arrays.asList(), 1),
                Arguments.arguments(Arrays.asList(1, 2, 3), 0),
                Arguments.arguments(Arrays.asList(-1, -2, -3, -4), 2),
                Arguments.arguments(Arrays.asList(100, 200, 300, 400, 500), 0),
                Arguments.arguments(Arrays.asList(5, 5, 5, 5, 5, 5), 6),
                Arguments.arguments(Arrays.asList(10, 20, 30, 40, 50), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(List<Integer> inputList, int k) {
        assertEquals(
            OriginalImpl.maximum(inputList, k),
            TransformedImpl.findTopKElements(inputList, k)
        );
    }
}