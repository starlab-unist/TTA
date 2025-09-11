import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Original Implementation
class HumanEval_57 {

    static class OriginalImpl {
        public static boolean monotonic(List<Integer> l) {
            List<Integer> sortedList = new ArrayList<>(l);
            List<Integer> reversedSortedList = new ArrayList<>(l);

            Collections.sort(sortedList);
            Collections.sort(reversedSortedList, Collections.reverseOrder());

            return l.equals(sortedList) || l.equals(reversedSortedList);
        }
    }

    // Transformed Implementation
    static class TransformedImpl {
        public static boolean checkMonotonicSequence(List<Integer> sequence) {
            List<Integer> ascending = new ArrayList<>(sequence);
            List<Integer> descending = new ArrayList<>(sequence);

            Collections.sort(ascending);
            Collections.sort(descending, Collections.reverseOrder());

            if (sequence.equals(ascending) || sequence.equals(descending)) {
                return true;
            }
            return false;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),       // strictly increasing
            Arguments.of(Arrays.asList(5, 4, 3, 2, 1)),       // strictly decreasing
            Arguments.of(Arrays.asList(1, 1, 1, 1, 1)),       // all elements are the same
            Arguments.of(Arrays.asList(1, 2, 2, 3, 4)),       // non-decreasing
            Arguments.of(Arrays.asList(5, 5, 4, 4, 3, 2, 1)), // non-increasing
            Arguments.of(Arrays.asList(1, 3, 2)),             // not monotonic
            Arguments.of(Arrays.asList()),                    // empty list
            Arguments.of(Arrays.asList(10)),                  // single element
            Arguments.of(Arrays.asList(3, 3, 2, 1, 1, 1)),    // decreasing with duplicates
            Arguments.of(Arrays.asList(1, 1, 2, 2, 3, 3))     // increasing with duplicates
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMonotonic(List<Integer> input) {
        boolean originalResult = OriginalImpl.monotonic(input);
        boolean transformedResult = TransformedImpl.checkMonotonicSequence(input);
        assertEquals(originalResult, transformedResult);
    }
}