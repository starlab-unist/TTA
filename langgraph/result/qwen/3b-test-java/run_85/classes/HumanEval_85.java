import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_85 {

    // Source Code
    public static int add(List<Integer> lst) {
        int sum = 0;
        for (int i = 1; i < lst.size(); i += 2) {
            if (lst.get(i) % 2 == 0) {
                sum += lst.get(i);
            }
        }
        return sum;
    }

    // Transformed Code
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

    // Test Cases
    public static class OriginalImpl {
        public static int add(List<Integer> lst) {
            return HumanEval_85.add(lst);
        }
    }

    public static class TransformedImpl {
        public static int calculateEvenSumAtOddIndices(int[] numbers) {
            return HumanEval_85.calculateEvenSumAtOddIndices(numbers);
        }
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6), new int[]{1, 2, 3, 4, 5, 6}),       // Expected output: 6 (2 + 4)
            Arguments.arguments(Arrays.asList(10, 15, 20, 25, 30, 35), new int[]{10, 15, 20, 25, 30, 35}), // Expected output: 0 (no even numbers at odd indices)
            Arguments.arguments(Arrays.asList(2, 4, 6, 8, 10, 12), new int[]{2, 4, 6, 8, 10, 12}),     // Expected output: 20 (4 + 8 + 12)
            Arguments.arguments(Arrays.asList(1, 3, 5, 7, 9), new int[]{1, 3, 5, 7, 9}),          // Expected output: 0 (no even numbers at odd indices)
            Arguments.arguments(Arrays.asList(), new int[]{}),                                     // Expected output: 0 (empty list)
            Arguments.arguments(Arrays.asList(0, 0, 0, 0, 0, 0), new int[]{0, 0, 0, 0, 0, 0}),       // Expected output: 0 (all zeros)
            Arguments.arguments(Arrays.asList(1, 2), new int[]{1, 2}),                   // Expected output: 2
            Arguments.arguments(Arrays.asList(1, 2, 3), new int[]{1, 2, 3}),                // Expected output: 2
            Arguments.arguments(Arrays.asList(1, 2, 3, 4), new int[]{1, 2, 3, 4}),             // Expected output: 6 (2 + 4)
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5), new int[]{1, 2, 3, 4, 5})           // Expected output: 6 (2 + 4)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(List<Integer> originalInput, int[] transformedInput) {
        assertEquals(OriginalImpl.add(originalInput), TransformedImpl.calculateEvenSumAtOddIndices(transformedInput));
    }
}