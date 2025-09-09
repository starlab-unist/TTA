import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_159 {

    // Source Code
    static class HumanEval_159_Source {
        public int[] eat(int number, int need, int remaining) {
            if (need <= remaining) {
                return new int[]{number + need, remaining - need};
            } else {
                return new int[]{number + remaining, 0};
            }
        }
    }

    // Transformed Code
    static class HumanEval_159_Transformed {
        public int[] consume(int quantity, int requirement, int stock) {
            int updatedQuantity;
            int leftoverStock;

            if (requirement <= stock) {
                updatedQuantity = quantity + requirement;
                leftoverStock = stock - requirement;
            } else {
                updatedQuantity = quantity + stock;
                leftoverStock = 0;
            }

            return new int[]{updatedQuantity, leftoverStock};
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(10, 5, 8),   // need <= remaining
            Arguments.of(20, 15, 10), // need > remaining
            Arguments.of(0, 0, 0),    // edge case: all zeros
            Arguments.of(1, 2, 3),    // simple values, need <= remaining
            Arguments.of(5, 5, 5),    // edge case: need == remaining
            Arguments.of(100, 50, 75),// large numbers, need < remaining
            Arguments.of(42, 99, 10), // need > remaining
            Arguments.of(7, 0, 5),    // edge case: no need
            Arguments.of(3, 3, 2),    // edge case: need > remaining by 1
            Arguments.of(8, 10, 8)    // need > remaining
        );
    }

    @DisplayName("Test if eat and consume produce the same output")
    @ParameterizedTest(name = "Test case: {index} - Input({0}, {1}, {2})")
    @MethodSource("provideTestCases")
    void eat_vs_consume(int number, int need, int remaining) {
        HumanEval_159_Source sourceCode = new HumanEval_159_Source();
        HumanEval_159_Transformed transformedCode = new HumanEval_159_Transformed();

        assertEquals(
            Arrays.toString(sourceCode.eat(number, need, remaining)),
            Arrays.toString(transformedCode.consume(number, need, remaining))
        );
    }
}