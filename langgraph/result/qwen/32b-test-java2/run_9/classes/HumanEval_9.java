import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream; // Added this import statement

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_9 {

    // Source Code
    static class SourceCode {
        public static List<Integer> rollingMax(List<Integer> numbers) {
            Integer runningMax = null;
            List<Integer> result = new ArrayList<>();

            for (Integer n : numbers) {
                if (runningMax == null) {
                    runningMax = n;
                } else {
                    runningMax = Math.max(runningMax, n);
                }

                result.add(runningMax);
            }

            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> computeRollingMaximum(List<Integer> values) {
            Integer currentMax = null;
            List<Integer> maxHistory = new ArrayList<>();

            int index = 0;
            while (index < values.size()) {
                if (currentMax == null) {
                    currentMax = values.get(index);
                } else if (values.get(index) > currentMax) {
                    currentMax = values.get(index);
                }

                maxHistory.add(currentMax);
                index++;
            }

            return maxHistory;
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = List.of(
        Arguments.of(new ArrayList<Integer>(), new ArrayList<Integer>()),
        Arguments.of(List.of(5), List.of(5)),
        Arguments.of(List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4, 5)),
        Arguments.of(List.of(5, 4, 3, 2, 1), List.of(5, 5, 5, 5, 5)),
        Arguments.of(List.of(1, 5, 3, 6, 2), List.of(1, 5, 5, 6, 6)),
        Arguments.of(List.of(3, 3, 3, 3, 3), List.of(3, 3, 3, 3, 3)),
        Arguments.of(List.of(10, 9, 8, 7, 11), List.of(10, 10, 10, 10, 11)),
        Arguments.of(List.of(1, 2), List.of(1, 2)),
        Arguments.of(List.of(2, 1), List.of(2, 2)),
        Arguments.of(List.of(1), List.of(1))
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @DisplayName("Rolling Max vs Compute Rolling Maximum")
    @ParameterizedTest(name = "Test case {index} with input {0}")
    @MethodSource("provideTestCases")
    void rollingMax_vs_computeRollingMaximum(List<Integer> input, List<Integer> expected) {
        assertEquals(
            SourceCode.rollingMax(input),
            TransformedCode.computeRollingMaximum(input)
        );
    }
}