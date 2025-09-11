import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Source Code
class HumanEval_133 {

    // Original Implementation
    public static class OriginalImpl {
        public static int sumSquares(double[] lst) {
            int squared = 0;
            for (double i : lst) {
                squared += Math.ceil(i);
                squared *= squared;
            }
            return squared;
        }
    }

    // Transformed Implementation
    public static class TransformedImpl {
        public static int calculateTotalSquaredCeilings(List<Double> numbers) {
            int total = 0;
            for (double number : numbers) {
                double ceilingValue = Math.ceil(number);
                total += ceilingValue * ceilingValue;
            }
            return total;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new double[]{1.0, 2.0, 3.0}, Arrays.asList(1.0, 2.0, 3.0)),
            Arguments.of(new double[]{-1.5, 2.3, -3.7}, Arrays.asList(-1.5, 2.3, -3.7)),
            Arguments.of(new double[]{0.0, 0.0, 0.0}, Arrays.asList(0.0, 0.0, 0.0)),
            Arguments.of(new double[]{4.9, 5.1, 6.5}, Arrays.asList(4.9, 5.1, 6.5)),
            Arguments.of(new double[]{10.0, -10.0, 20.0}, Arrays.asList(10.0, -10.0, 20.0)),
            Arguments.of(new double[]{1.1, 1.9, 2.5}, Arrays.asList(1.1, 1.9, 2.5)),
            Arguments.of(new double[]{-1.0, -2.0, -3.0}, Arrays.asList(-1.0, -2.0, -3.0)),
            Arguments.of(new double[]{}, Arrays.asList()),
            Arguments.of(new double[]{0.99, 1.01, 2.99}, Arrays.asList(0.99, 1.01, 2.99)),
            Arguments.of(new double[]{5.0}, Arrays.asList(5.0))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testSumSquares(double[] inputArray, List<Double> inputList) {
        assertEquals(OriginalImpl.sumSquares(inputArray), 
                     TransformedImpl.calculateTotalSquaredCeilings(inputList));
    }
}