import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Objects;  // Added import statement for Objects

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

    // Tuple class used in transformed code
    static class Tuple<X, Y> {
        public final X first;
        public final Y second;

        public Tuple(X first, Y second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple<?, ?> tuple = (Tuple<?, ?>) o;
            return first.equals(tuple.first) && second.equals(tuple.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList(), new Tuple<>(0, 1)),
        Arguments.of(Arrays.asList(1), new Tuple<>(1, 1)),
        Arguments.of(Arrays.asList(2, 3), new Tuple<>(5, 6)),
        Arguments.of(Arrays.asList(4, 5, 6), new Tuple<>(15, 120)),
        Arguments.of(Arrays.asList(7, 8, 9, 10), new Tuple<>(34, 5040)),
        Arguments.of(Arrays.asList(0, 1, 2, 3), new Tuple<>(6, 0)),
        Arguments.of(Arrays.asList(1, -1, 1, -1), new Tuple<>(0, 1)),
        Arguments.of(Arrays.asList(10, 20, 30), new Tuple<>(60, 6000)),
        Arguments.of(Arrays.asList(5, 5, 5, 5), new Tuple<>(20, 625)),
        Arguments.of(Arrays.asList(1, 2, 3, 4, 5), new Tuple<>(15, 120))
    );

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void sumProduct_vs_calculateAggregates(List<Integer> inputList, Tuple<Integer, Integer> expectedTuple) {
        int[] sourceResult = SourceCode.sumProduct(inputList);
        Tuple<Integer, Integer> transformedResult = TransformedCode.calculateAggregates(inputList);

        assertEquals(expectedTuple.first, sourceResult[0]);
        assertEquals(expectedTuple.second, sourceResult[1]);
        assertEquals(expectedTuple, transformedResult);
    }

    private static List<Arguments> provideTestCases() {
        return testCases;
    }
}