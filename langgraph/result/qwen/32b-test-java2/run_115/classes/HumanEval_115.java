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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_115 {

    // Source Code
    static class OriginalImpl {
        public static int maxFill(List<List<Integer>> grid, double capacity) {
            int total = 0;
            for (List<Integer> arr : grid) {
                total += Math.ceil(arr.stream().mapToInt(Integer::intValue).sum() / capacity);
            }
            return total;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static int calculateMaxLoad(int[][] matrix, double limit) {
            int totalLoad = 0;
            for (int[] row : matrix) {
                totalLoad += Math.ceil((double) sumArray(row) / limit);
            }
            return totalLoad;
        }

        private static int sumArray(int[] array) {
            int sum = 0;
            for (int value : array) {
                sum += value;
            }
            return sum;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(List.of(10, 20), List.of(30, 40)), 10.0),
            Arguments.of(List.of(List.of(5, 5), List.of(5, 5)), 5.0),
            Arguments.of(List.of(List.of(1, 1, 1), List.of(2, 2, 2), List.of(3, 3, 3)), 1.0),
            Arguments.of(List.of(List.of(0, 0), List.of(0, 0)), 1.0),
            Arguments.of(List.of(List.of(7, 8, 9), List.of(10, 11, 12)), 5.0),
            Arguments.of(List.of(List.of(100)), 10.0),
            Arguments.of(List.of(List.of(10, 20, 30), List.of(40, 50, 60)), 25.0),
            Arguments.of(List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6)), 3.0),
            Arguments.of(List.of(List.of(15, 15), List.of(15, 15), List.of(15, 15)), 10.0),
            Arguments.of(List.of(List.of(2, 4, 6), List.of(8, 10, 12), List.of(14, 16, 18)), 7.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testImplementations(List<List<Integer>> grid, double capacity) {
        int[][] matrix = to2DIntArray(grid);
        assertEquals(OriginalImpl.maxFill(grid, capacity), TransformedImpl.calculateMaxLoad(matrix, capacity));
    }

    private int[][] to2DIntArray(List<List<Integer>> list) {
        int[][] array = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> rowList = list.get(i);
            array[i] = rowList.stream().mapToInt(Integer::intValue).toArray();
        }
        return array;
    }
}