import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HumanEval_35 {

    // Source Code
    static class OriginalImpl {
        public static int maxElement(int[] l) {
            int m = l[0];
            for (int e : l) {
                if (e > m) {
                    m = e;
                }
            }
            return m;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static int findMaximumValue(List<Integer> elements) {
            int currentMax = elements.get(0);
            int index = 1;
            while (index < elements.size()) {
                if (elements.get(index) > currentMax) {
                    currentMax = elements.get(index);
                }
                index++;
            }
            return currentMax;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5}),
            Arguments.of(new int[]{-7, -1, -5, -3, -9}),
            Arguments.of(new int[]{10, 20, 30, 40, 50}),
            Arguments.of(new int[]{100}),
            Arguments.of(new int[]{0, 0, 0, 0}),
            Arguments.of(new int[]{5, 5, 5, 5, 6}),
            Arguments.of(new int[]{-1, -2, -3, -4, -5, -6}),
            Arguments.of(new int[]{1}),
            Arguments.of(new int[]{2, 2, 2, 1, 1, 1}),
            Arguments.of(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(int[] input) {
        List<Integer> listInput = Arrays.stream(input).boxed().toList();
        assertEquals(OriginalImpl.maxElement(input), TransformedImpl.findMaximumValue(listInput));
    }
}