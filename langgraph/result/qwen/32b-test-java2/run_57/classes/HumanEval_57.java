import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),       // strictly increasing
        Arguments.of(Arrays.asList(5, 4, 3, 2, 1)),       // strictly decreasing
        Arguments.of(Arrays.asList(1, 1, 1, 1, 1)),       // all elements are the same
        Arguments.of(Arrays.asList(1, 2, 2, 3, 4)),       // non-decreasing
        Arguments.of(Arrays.asList(5, 5, 4, 4, 3, 2, 1)), // non-increasing
        Arguments.of(Arrays.asList(1, 3, 2)),             // not monotonic
        Arguments.of(Collections.emptyList()),             // empty list
        Arguments.of(Arrays.asList(10)),                  // single element
        Arguments.of(Arrays.asList(3, 3, 2, 1, 1, 1)),    // decreasing with duplicates
        Arguments.of(Arrays.asList(1, 1, 2, 2, 3, 3))     // increasing with duplicates
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void monotonic_vs_checkMonotonicSequence(List<Integer> inputList) {
        HumanEval_57_Source sourceInstance = new HumanEval_57_Source();
        HumanEval_57_Transformed transformedInstance = new HumanEval_57_Transformed();

        assertEquals(
            sourceInstance.monotonic(inputList),
            transformedInstance.checkMonotonicSequence(inputList)
        );
    }
}