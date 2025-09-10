import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.stream.Stream;

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
        public static double calculate_median(List<Double> numbers) {
            List<Double> sorted_numbers = new ArrayList<>(numbers);
            Collections.sort(sorted_numbers);
            int mid_index = sorted_numbers.size() / 2;

            if (sorted_numbers.size() % 2 == 1) {
                return sorted_numbers.get(mid_index);
            } else {
                return (sorted_numbers.get(mid_index - 1) + sorted_numbers.get(mid_index)) / 2.0;
            }
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(Arrays.asList(3.0, 1.0, 2.0), 2.0)},
        {Arguments.of(Arrays.asList(4.0, 1.0, 3.0, 2.0), 2.5)},
        {Arguments.of(Arrays.asList(7.0), 7.0)},
        {Arguments.of(Arrays.asList(8.0, 9.0), 8.5)},
        {Arguments.of(Arrays.asList(10.0, 2.0, 5.0, 1.0, 8.0, 9.0, 3.0), 5.0)},
        {Arguments.of(Arrays.asList(5.0, 5.0, 5.0, 5.0, 5.0), 5.0)},
        {Arguments.of(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), 5.5)},
        {Arguments.of(Arrays.asList(100.0, 200.0, 300.0, 400.0, 500.0, 600.0, 700.0, 800.0, 900.0, 1000.0), 550.0)},
        {Arguments.of(Arrays.asList(1.5, 2.5, 3.5), 2.5)},
        {Arguments.of(Arrays.asList(-1.0, -2.0, -3.0, -4.0, -5.0), -3.0)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void median_vs_calculate_median(List<Double> inputList, double expected) {
        assertEquals(
            SourceCode.median(inputList),
            TransformedCode.calculate_median(inputList),
            0.0001 // delta to handle floating-point comparison precision issues
        );
    }
}