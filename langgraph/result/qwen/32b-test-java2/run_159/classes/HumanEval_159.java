import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

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
    private static final Arguments[][] testCases = {
        {Arguments.of(10, 5, 8)},
        {Arguments.of(20, 15, 10)},
        {Arguments.of(0, 0, 0)},
        {Arguments.of(1, 2, 3)},
        {Arguments.of(5, 5, 5)},
        {Arguments.of(100, 50, 75)},
        {Arguments.of(42, 99, 10)},
        {Arguments.of(7, 0, 5)},
        {Arguments.of(3, 3, 2)},
        {Arguments.of(8, 10, 8)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> args[0]);
    }

    @DisplayName("Test eat vs consume")
    @ParameterizedTest(name = "eat({0}, {1}, {2}) == consume({0}, {1}, {2})")
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