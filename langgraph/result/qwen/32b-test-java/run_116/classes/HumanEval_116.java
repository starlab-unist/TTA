import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_116 {

    // Source Code
    static class HumanEval_116_Source {
        public static int[] sortArray(int[] arr) {
            Integer[] wrappedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            
            Arrays.sort(wrappedArray, Comparator.comparingInt((Integer x) -> Integer.bitCount(x)));
            
            return Arrays.stream(wrappedArray).mapToInt(Integer::intValue).toArray();
        }
    }

    // Transformed Code
    static class HumanEval_116_Transformed {
        public static int[] arrangeByBinaryOnes(int[] sequence) {
            return Arrays.stream(sequence)
                         .boxed()
                         .sorted(Comparator.comparingInt(HumanEval_116_Transformed::countOnesInBinary))
                         .mapToInt(Integer::intValue)
                         .toArray();
        }

        private static int countOnesInBinary(int number) {
            return Integer.bitCount(number);
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {3, 7, 8, 9},          // Mixed numbers with different binary '1' counts
        {5, 3, 15, 7, 2},      // Numbers with varying binary '1' counts
        {0, 1, 2, 3, 4, 5, 6}, // Sequential numbers starting from 0
        {10, 20, 30, 40, 50},  // Multiples of 10
        {31, 14, 7, 3, 1},     // Descending powers of 2 minus 1
        {64, 128, 256, 512},   // Powers of 2
        {1, 1, 1, 1},          // All ones
        {0, 0, 0, 0},          // All zeros
        {13, 9, 5, 7, 11},     // Mixed numbers with same '1' count in binary
        {2, 4, 8, 16, 32}      // Powers of 2 starting from 2^1
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("provideTestCases")
    void sortArray_vs_arrangeByBinaryOnes(int[] input) {
        assertEquals(
            Arrays.toString(HumanEval_116_Source.sortArray(input)),
            Arrays.toString(HumanEval_116_Transformed.arrangeByBinaryOnes(input))
        );
    }
}