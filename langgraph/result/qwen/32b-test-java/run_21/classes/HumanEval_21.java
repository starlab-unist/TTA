import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_21 {

    // Source Code
    static class SourceCode {
        public static List<Double> rescaleToUnit(List<Double> numbers) {
            double minNumber = Double.MAX_VALUE;
            double maxNumber = Double.MIN_VALUE;

            for (double number : numbers) {
                if (number < minNumber) {
                    minNumber = number;
                }
                if (number > maxNumber) {
                    maxNumber = number;
                }
            }

            List<Double> rescaledNumbers = new ArrayList<>();
            for (double x : numbers) {
                rescaledNumbers.add((x - minNumber) / (maxNumber - minNumber));
            }

            return rescaledNumbers;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Double> normalizeValues(List<Double> values) {
            double smallestValue = Double.MAX_VALUE;
            double largestValue = Double.MIN_VALUE;

            for (double value : values) {
                if (value < smallestValue) {
                    smallestValue = value;
                }
                if (value > largestValue) {
                    largestValue = value;
                }
            }

            double rangeValue = largestValue - smallestValue;
            List<Double> normalizedList = new ArrayList<>();

            for (double value : values) {
                double normalizedValue = (value - smallestValue) / rangeValue;
                normalizedList.add(normalizedValue);
            }

            return normalizedList;
        }
    }

    // Test Cases
    private static final Double[][] testCases = {
        {1.0, 2.0, 3.0, 4.0, 5.0},
        {10.0, 20.0, 30.0, 40.0, 50.0},
        {5.0, 5.0, 5.0, 5.0},
        {-1.0, -2.0, -3.0, -4.0, -5.0},
        {0.0, 100.0},
        {3.14, 2.71, 1.618, 0.577},
        {100.0, 200.0, 300.0, 400.0, 500.0},
        {1.0, 1.0, 2.0, 2.0, 3.0, 3.0},
        {-5.0, 0.0, 5.0},
        {1000.0}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void rescaleToUnit_vs_normalizeValues(Double[] input) {
        List<Double> inputList = Arrays.asList(input);
        assertEquals(
            SourceCode.rescaleToUnit(inputList),
            TransformedCode.normalizeValues(inputList)
        );
    }
}