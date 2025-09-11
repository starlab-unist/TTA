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
import java.util.stream.Stream;

public class HumanEval_88 {

    // Source Code
    public static int[] sortArray(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }
        boolean isEvenSum = (array[0] + array[array.length - 1]) % 2 == 0;
        java.util.Arrays.sort(array);
        if (isEvenSum) {
            reverseArray(array);
        }
        return array;
    }

    private static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    // Transformed Code
    public static int[] arrangeSequence(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return new int[0];
        }

        boolean reverseOrder = (sequence[0] + sequence[sequence.length - 1]) % 2 == 0;
        return java.util.Arrays.stream(sequence)
                .boxed()
                .sorted(reverseOrder ? java.util.Collections.reverseOrder() : java.util.Comparator.naturalOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // Test Cases
    public static class OriginalImpl {
        public static int[] sortArray(int[] array) {
            return HumanEval_88.sortArray(array);
        }
    }

    public static class TransformedImpl {
        public static int[] arrangeSequence(int[] sequence) {
            return HumanEval_88.arrangeSequence(sequence);
        }
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 4, 1, 5, 9}),
                Arguments.of(new int[]{10, 20, 30, 40, 50}),
                Arguments.of(new int[]{5, 3, 8, 6, 7, 2}),
                Arguments.of(new int[]{7, 2, 9, 4, 6}),
                Arguments.of(new int[]{1}),
                Arguments.of(new int[]{}),
                Arguments.of(new int[]{2, 4, 6, 8, 10}),
                Arguments.of(new int[]{9, 7, 5, 3, 1}),
                Arguments.of(new int[]{11, 22, 33, 44, 55}),
                Arguments.of(new int[]{100, 200, 300, 400, 500})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(int[] input) {
        assertArrayEquals(OriginalImpl.sortArray(input), TransformedImpl.arrangeSequence(input));
    }
}