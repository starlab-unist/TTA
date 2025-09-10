import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_57 {

    // Source Code
    static class SourceCode {
        public static boolean monotonic(List<Integer> l) {
            List<Integer> sortedList = new ArrayList<>(l);
            Collections.sort(sortedList);
            if (l.equals(sortedList) || l.equals(new ArrayList<>(sortedList).stream().sorted(Collections.reverseOrder()).toList())) {
                return true;
            }
            return false;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static boolean checkMonotonicSequence(List<Integer> sequence) {
            List<Integer> ascending = new ArrayList<>(sequence);
            List<Integer> descending = new ArrayList<>(sequence);

            Collections.sort(ascending);
            descending.sort(Collections.reverseOrder());

            if (sequence.equals(ascending) || sequence.equals(descending)) {
                return true;
            }
            return false;
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = List.of(
        Arguments.of(List.of(1, 2, 3, 4, 5)),       // strictly increasing
        Arguments.of(List.of(5, 4, 3, 2, 1)),       // strictly decreasing
        Arguments.of(List.of(1, 1, 1, 1, 1)),       // all elements are the same
        Arguments.of(List.of(1, 2, 2, 3, 4)),       // non-decreasing
        Arguments.of(List.of(5, 5, 4, 4, 3, 2, 1)), // non-increasing
        Arguments.of(List.of(1, 3, 2)),             // not monotonic
        Arguments.of(List.of()),                    // empty list
        Arguments.of(List.of(10)),                  // single element
        Arguments.of(List.of(3, 3, 2, 1, 1, 1)),    // decreasing with duplicates
        Arguments.of(List.of(1, 1, 2, 2, 3, 3))     // increasing with duplicates
    );

    private static List<Arguments> provideTestCases() {
        return testCases;
    }

    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("provideTestCases")
    public void monotonic_vs_checkMonotonicSequence(List<Integer> inputList) {
        assertEquals(
            SourceCode.monotonic(inputList),
            TransformedCode.checkMonotonicSequence(inputList)
        );
    }
}