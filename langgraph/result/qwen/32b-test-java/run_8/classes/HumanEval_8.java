import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        public static Tuple<Integer, Integer> calculateAggregates(List<Integer> values) {
            int totalSum = 0;
            int cumulativeProduct = 1;

            int index = 0;
            while (index < values.size()) {
                totalSum += values.get(index);
                cumulativeProduct *= values.get(index);
                index++;
            }

            return new Tuple<>(totalSum, cumulativeProduct);
        }
    }

    // Tuple class
    static class Tuple<X, Y> {
        public final X first;
        public final Y second;

        public Tuple(X first, Y second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Tuple<?, ?> tuple = (Tuple<?, ?>) obj;
            return first.equals(tuple.first) && second.equals(tuple.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(List.of(), new Tuple<>(0, 1))},
        {Arguments.of(List.of(1), new Tuple<>(1, 1))},
        {Arguments.of(List.of(2, 3), new Tuple<>(5, 6))},
        {Arguments.of(List.of(4, 5, 6), new Tuple<>(15, 120))},
        {Arguments.of(List.of(7, 8, 9, 10), new Tuple<>(34, 5040))},
        {Arguments.of(List.of(0, 1, 2, 3), new Tuple<>(6, 0))},
        {Arguments.of(List.of(1, -1, 1, -1), new Tuple<>(0, 1))},
        {Arguments.of(List.of(10, 20, 30), new Tuple<>(60, 6000))},
        {Arguments.of(List.of(5, 5, 5, 5), new Tuple<>(20, 625))},
        {Arguments.of(List.of(1, 2, 3, 4, 5), new Tuple<>(15, 120))}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).flatMap(Arrays::stream);
    }

    @DisplayName("Check if source and transformed methods produce the same output")
    @ParameterizedTest(name = "Test case {index}: Input: {0}, Expected Output: {1}")
    @MethodSource("provideTestCases")
    void sumProduct_vs_calculateAggregates(List<Integer> input, Tuple<Integer, Integer> expected) {
        int[] sourceOutput = SourceCode.sumProduct(input);
        Tuple<Integer, Integer> transformedOutput = TransformedCode.calculateAggregates(input);

        assertEquals(new Tuple<>(sourceOutput[0], sourceOutput[1]), transformedOutput);
    }
}