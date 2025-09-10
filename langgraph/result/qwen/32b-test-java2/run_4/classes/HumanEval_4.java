import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_4 {

    // Source Code
    static class SourceCode {
        public static double meanAbsoluteDeviation(List<Double> numbers) {
            double mean = numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            double mad = numbers.stream().mapToDouble(x -> Math.abs(x - mean)).average().orElse(0.0);
            return mad;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static double calculateMeanAbsDev(List<Double> values) {
            double average = values.stream().mapToDouble(Double::doubleValue).sum() / values.size();
            double deviationSum = values.stream().mapToDouble(value -> Math.abs(value - average)).sum();
            return deviationSum / values.size();
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList(1.0, 2.0, 3.0), 0.6666666666666666),
        Arguments.of(Arrays.asList(4.0, 5.0, 6.0, 7.0), 1.0),
        Arguments.of(Arrays.asList(10.0, 10.0, 10.0), 0.0),
        Arguments.of(Arrays.asList(1.0, 1.0, 2.0, 3.0, 4.0), 1.2),
        Arguments.of(Arrays.asList(5.5, 5.5, 5.5, 5.5), 0.0),
        Arguments.of(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), 2.5),
        Arguments.of(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0), 0.0),
        Arguments.of(Arrays.asList(1.5, 2.5, 3.5, 4.5, 5.5), 1.2),
        Arguments.of(Arrays.asList(100.0, 200.0, 300.0), 66.66666666666667),
        Arguments.of(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5), 1.32)
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void meanAbsoluteDeviation_vs_calculateMeanAbsDev(List<Double> inputNumbers, double expected) {
        assertEquals(
            SourceCode.meanAbsoluteDeviation(inputNumbers),
            TransformedCode.calculateMeanAbsDev(inputNumbers),
            0.000001 // Tolerance for floating-point comparison
        );
    }
}