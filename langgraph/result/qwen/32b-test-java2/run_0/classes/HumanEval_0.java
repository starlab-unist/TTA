import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_0 {

    // Source Code
    static class SourceCode {
        public static boolean hasCloseElements(List<Double> numbers, double threshold) {
            for (int idx = 0; idx < numbers.size(); idx++) {
                for (int idx2 = 0; idx2 < numbers.size(); idx2++) {
                    if (idx != idx2) {
                        double distance = Math.abs(numbers.get(idx) - numbers.get(idx2));
                        if (distance < threshold) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean containsNearbyElements(List<Double> values, double limit) {
            int index = 0;
            while (index < values.size()) {
                int innerIndex = 0;
                while (innerIndex < values.size()) {
                    if (index != innerIndex) {
                        double gap = Math.abs(values.get(index) - values.get(innerIndex));
                        if (gap < limit) {
                            return true;
                        }
                    }
                    innerIndex++;
                }
                index++;
            }

            return false;
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList(1.0, 2.0, 3.0), 0.5),
        Arguments.of(Arrays.asList(1.0, 2.0, 3.0), 1.5),
        Arguments.of(Arrays.asList(1.1, 2.2, 3.3), 0.1),
        Arguments.of(Arrays.asList(1.1, 2.2, 3.3), 1.2),
        Arguments.of(Arrays.asList(0.0, 0.0, 0.0), 0.0),
        Arguments.of(Arrays.asList(0.0, 0.1, 0.2), 0.05),
        Arguments.of(Arrays.asList(5.0, 4.9, 4.8), 0.2),
        Arguments.of(Arrays.asList(10.0, 20.0, 30.0), 5.0),
        Arguments.of(Arrays.asList(1.0, 1.0, 1.0, 1.0), 0.1),
        Arguments.of(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0), 1.1)
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void hasCloseElements_vs_containsNearbyElements(List<Double> inputList, double threshold) {
        assertEquals(
            SourceCode.hasCloseElements(inputList, threshold),
            new TransformedCode().containsNearbyElements(inputList, threshold)
        );
    }
}