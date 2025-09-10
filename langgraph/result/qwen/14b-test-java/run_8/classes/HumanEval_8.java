import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HumanEval_8 {

    // Source Code
    static class SourceCode {
        public static int[] sumProduct(List<Integer> numbers) {
            int sumValue = 0;
            int prodValue = 1;

            for (int n : numbers) {
                sumValue += n;
                prodValue *= n;
            }
            return new int[]{sumValue, prodValue};
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int[] calculateAggregates(List<Integer> values) {
            int totalSum = 0;
            int cumulativeProduct = 1;

            int index = 0;
            while (index < values.size()) {
                totalSum += values.get(index);
                cumulativeProduct *= values.get(index);
                index++;
            }

            return new int[]{totalSum, cumulativeProduct};
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(Arrays.asList(), new int[]{0, 1})},
        {Arguments.of(Arrays.asList(1), new int[]{1, 1})},
        {Arguments.of(Arrays.asList(2, 3), new int[]{5, 6})},
        {Arguments.of(Arrays.asList(4, 5, 6), new int[]{15, 120})},
        {Arguments.of(Arrays.asList(7, 8, 9, 10), new int[]{34, 5040})},
        {Arguments.of(Arrays.asList(0, 1, 2, 3), new int[]{6, 0})},
        {Arguments.of(Arrays.asList(1, -1, 1, -1), new int[]{0, 1})},
        {Arguments.of(Arrays.asList(10, 20, 30), new int[]{60, 6000})},
        {Arguments.of(Arrays.asList(5, 5, 5, 5), new int[]{20, 625})},
        {Arguments.of(Arrays.asList(1, 2, 3, 4, 5), new int[]{15, 120})}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).flatMap(Arrays::stream);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void sumProduct_vs_calculateAggregates(List<Integer> inputList, int[] expectedOutput) {
        assertArrayEquals(
            SourceCode.sumProduct(inputList),
            TransformedCode.calculateAggregates(inputList)
        );
    }
}