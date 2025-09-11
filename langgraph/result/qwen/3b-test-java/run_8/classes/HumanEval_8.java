import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.provider.Arguments;

public class HumanEval_8 {

    // Source Code
    public static class OriginalImpl {
        public static Tuple sumProduct(List<Integer> numbers) {
            int sumValue = 0;
            int prodValue = 1;

            for (int n : numbers) {
                sumValue += n;
                prodValue *= n;
            }

            return new Tuple(sumValue, prodValue);
        }
    }

    // Transformed Code
    public static class TransformedImpl {
        public static Tuple calculateAggregates(List<Integer> values) {
            int totalSum = 0;
            int cumulativeProduct = 1;

            int index = 0;
            while (index < values.size()) {
                totalSum += values.get(index);
                cumulativeProduct *= values.get(index);
                index++;
            }

            return new Tuple(totalSum, cumulativeProduct);
        }
    }

    // Inner class to represent a tuple
    public static class Tuple {
        private final int sum;
        private final int product;

        public Tuple(int sum, int product) {
            this.sum = sum;
            this.product = product;
        }

        public int getSum() {
            return sum;
        }

        public int getProduct() {
            return product;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(), new Tuple(0, 1)),
            Arguments.of(List.of(1), new Tuple(1, 1)),
            Arguments.of(List.of(2, 3), new Tuple(5, 6)),
            Arguments.of(List.of(4, 5, 6), new Tuple(15, 120)),
            Arguments.of(List.of(7, 8, 9, 10), new Tuple(34, 5040)),
            Arguments.of(List.of(0, 1, 2, 3), new Tuple(6, 0)),
            Arguments.of(List.of(1, -1, 1, -1), new Tuple(0, 1)),
            Arguments.of(List.of(10, 20, 30), new Tuple(60, 6000)),
            Arguments.of(List.of(5, 5, 5, 5), new Tuple(20, 625)),
            Arguments.of(List.of(1, 2, 3, 4, 5), new Tuple(15, 120))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testSumProductAndCalculateAggregates(List<Integer> numbers, Tuple expected) {
        Tuple originalResult = OriginalImpl.sumProduct(numbers);
        Tuple transformedResult = TransformedImpl.calculateAggregates(numbers);

        assertEquals(expected.getSum(), originalResult.getSum());
        assertEquals(expected.getProduct(), originalResult.getProduct());
        assertEquals(expected.getSum(), transformedResult.getSum());
        assertEquals(expected.getProduct(), transformedResult.getProduct());
    }
}