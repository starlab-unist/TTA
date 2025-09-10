import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_133 {

    // Source Code
    static class HumanEval_133_Source {
        public static int sumSquares(double[] lst) {
            int squared = 0;
            for (double i : lst) {
                squared += Math.pow(Math.ceil(i), 2);
            }
            return squared;
        }
    }

    // Transformed Code
    static class HumanEval_133_Transformed {
        public static int calculateTotalSquaredCeilings(List<Double> numbers) {
            int total = 0;
            Iterator<Double> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                double number = iterator.next();
                total += Math.pow(Math.ceil(number), 2);
            }
            return total;
        }
    }

    // Test Cases
    private static final Double[][] testCases = {
        {1.0, 2.0, 3.0},
        {-1.5, 2.3, -3.7},
        {0.0, 0.0, 0.0},
        {4.9, 5.1, 6.5},
        {10.0, -10.0, 20.0},
        {1.1, 1.9, 2.5},
        {-1.0, -2.0, -3.0},
        {},
        {0.99, 1.01, 2.99},
        {5.0}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing sumSquares vs calculateTotalSquaredCeilings")
    void sumSquares_vs_calculateTotalSquaredCeilings(Double[] inputArray) {
        List<Double> inputList = Arrays.asList(inputArray);

        int sourceResult = HumanEval_133_Source.sumSquares(Arrays.stream(inputArray).mapToDouble(Double::doubleValue).toArray());
        int transformedResult = HumanEval_133_Transformed.calculateTotalSquaredCeilings(inputList);

        assertEquals(sourceResult, transformedResult);
    }
}