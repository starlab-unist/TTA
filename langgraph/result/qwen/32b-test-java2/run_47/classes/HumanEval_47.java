import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays; // Added import for Arrays
import java.util.stream.Stream; // Added import for Stream

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_47 {

    // Source Code
    static class SourceCode {
        public static double median(List<Double> l) {
            Collections.sort(l);
            int size = l.size();
            if (size % 2 == 1) {
                return l.get(size / 2);
            } else {
                return (l.get(size / 2 - 1) + l.get(size / 2)) / 2.0;
            }
        }
    }

    // Transformed Code
    static class TransformedCode {
        public double calculateMedian(List<Double> numbers) {
            List<Double> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            int midIndex = sortedNumbers.size() / 2;
            
            if (sortedNumbers.size() % 2 == 1) {
                return sortedNumbers.get(midIndex);
            } else {
                return (sortedNumbers.get(midIndex - 1) + sortedNumbers.get(midIndex)) / 2.0;
            }
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(List.of(3.0, 1.0, 2.0), 2.0)},
        {Arguments.of(List.of(4.0, 1.0, 3.0, 2.0), 2.5)},
        {Arguments.of(List.of(7.0), 7.0)},
        {Arguments.of(List.of(8.0, 9.0), 8.5)},
        {Arguments.of(List.of(10.0, 2.0, 5.0, 1.0, 8.0, 9.0, 3.0), 5.0)},
        {Arguments.of(List.of(5.0, 5.0, 5.0, 5.0, 5.0), 5.0)},
        {Arguments.of(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), 5.5)},
        {Arguments.of(List.of(100.0, 200.0, 300.0, 400.0, 500.0, 600.0, 700.0, 800.0, 900.0, 1000.0), 550.0)},
        {Arguments.of(List.of(1.5, 2.5, 3.5), 2.5)},
        {Arguments.of(List.of(-1.0, -2.0, -3.0, -4.0, -5.0), -3.0)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> args[0]);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void median_vs_calculateMedian(Arguments arguments) {
        List<Double> input = (List<Double>) arguments.get()[0];
        double expected = (Double) arguments.get()[1];

        TransformedCode transformedCodeInstance = new TransformedCode(); // Create an instance of TransformedCode

        assertEquals(
            SourceCode.median(input),
            transformedCodeInstance.calculateMedian(new ArrayList<>(input)), // Use the instance method
            0.0001 // delta for floating-point comparison
        );
    }
}