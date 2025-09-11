import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class HumanEval_85 {

    // Source Code
    static class OriginalImpl {
        public static int add(int[] lst) {
            return java.util.Arrays.stream(lst).skip(1).filter(i -> i % 2 == 0).sum();
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static int calculateEvenSumAtOddIndices(int[] numbers) {
            int total = 0;
            int index = 1;
            while (index < numbers.length) {
                if (numbers[index] % 2 == 0) {
                    total += numbers[index];
                }
                index += 2;
            }
            return total;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 6),       // Expected output: 6 (2 + 4)
            Arguments.of(new int[]{10, 15, 20, 25, 30, 35}, 0), // Expected output: 0 (no even numbers at odd indices)
            Arguments.of(new int[]{2, 4, 6, 8, 10, 12}, 20),   // Expected output: 20 (4 + 8 + 12)
            Arguments.of(new int[]{1, 3, 5, 7, 9}, 0),         // Expected output: 0 (no even numbers at odd indices)
            Arguments.of(new int[]{}, 0),                       // Expected output: 0 (empty list)
            Arguments.of(new int[]{0, 0, 0, 0, 0, 0}, 0),       // Expected output: 0 (all zeros)
            Arguments.of(new int[]{1, 2}, 2),                   // Expected output: 2
            Arguments.of(new int[]{1, 2, 3}, 2),                // Expected output: 2
            Arguments.of(new int[]{1, 2, 3, 4}, 6),             // Expected output: 6 (2 + 4)
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 6)          // Expected output: 6 (2 + 4)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testAddAndCalculateEvenSumAtOddIndices(int[] input, int expectedOutput) {
        assertEquals(OriginalImpl.add(input), TransformedImpl.calculateEvenSumAtOddIndices(input));
    }
}