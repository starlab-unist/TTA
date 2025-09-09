import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_57 {

    // Source Code
    static class HumanEval_57_Source {
        public boolean monotonic(List<Integer> l) {
            List<Integer> sortedList = new ArrayList<>(l);
            List<Integer> reversedSortedList = new ArrayList<>(l);

            Collections.sort(sortedList);
            Collections.sort(reversedSortedList, Collections.reverseOrder());

            return l.equals(sortedList) || l.equals(reversedSortedList);
        }
    }

    // Transformed Code
    static class HumanEval_57_Transformed {
        public boolean checkMonotonicSequence(List<Integer> sequence) {
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
    private static final Integer[][] testCases = {
        {1, 2, 3, 4, 5},       // strictly increasing
        {5, 4, 3, 2, 1},       // strictly decreasing
        {1, 1, 1, 1, 1},       // all elements are the same
        {1, 2, 2, 3, 4},       // non-decreasing
        {5, 5, 4, 4, 3, 2, 1}, // non-increasing
        {1, 3, 2},             // not monotonic
        {},                    // empty list
        {10},                  // single element
        {3, 3, 2, 1, 1, 1},    // decreasing with duplicates
        {1, 1, 2, 2, 3, 3}     // increasing with duplicates
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void monotonic_vs_checkMonotonicSequence(Integer[] inputList) {
        List<Integer> input = Arrays.asList(inputList);

        assertEquals(
            new HumanEval_57_Source().monotonic(input),
            new HumanEval_57_Transformed().checkMonotonicSequence(input)
        );
    }
}