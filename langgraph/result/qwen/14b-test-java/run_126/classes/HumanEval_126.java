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
import java.util.List;
import java.util.stream.Stream;

public class HumanEval_126 {

    // Original Code
    static class OriginalImpl {
        public static boolean isSorted(List<Integer> lst) {
            for (int i = 1; i < lst.size(); i++) {
                if (lst.get(i - 1) > lst.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static boolean check_sorted_sequence(int[] sequence) {
            int index = 1;
            while (index < sequence.length) {
                if (sequence[index - 1] > sequence[index]) {
                    return false;
                }
                index += 1;
            }
            return true;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5), new int[]{1, 2, 3, 4, 5}),
            Arguments.of(Arrays.asList(5, 4, 3, 2, 1), new int[]{5, 4, 3, 2, 1}),
            Arguments.of(Arrays.asList(1, 1, 2, 2, 3, 3), new int[]{1, 1, 2, 2, 3, 3}),
            Arguments.of(Arrays.asList(1, 1, 1, 2, 3), new int[]{1, 1, 1, 2, 3}),
            Arguments.of(Arrays.asList(1), new int[]{1}),
            Arguments.of(Arrays.asList(), new int[]{}),
            Arguments.of(Arrays.asList(1, 2, 2, 3, 4, 5, 5), new int[]{1, 2, 2, 3, 4, 5, 5}),
            Arguments.of(Arrays.asList(10, 9, 8, 7, 6, 5), new int[]{10, 9, 8, 7, 6, 5}),
            Arguments.of(Arrays.asList(1, 2, 3, 3, 3, 4, 5), new int[]{1, 2, 3, 3, 3, 4, 5}),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5, 5), new int[]{1, 2, 3, 4, 5, 5, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testImplementations(List<Integer> originalInput, int[] transformedInput) {
        assertEquals(OriginalImpl.isSorted(originalInput), TransformedImpl.check_sorted_sequence(transformedInput));
    }
}