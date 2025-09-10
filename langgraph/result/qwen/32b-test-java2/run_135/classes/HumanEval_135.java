import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_135 {

    private static final int[][] testCases = {
        {1, 2, 3, 4, 5},          // No decrease
        {5, 4, 3, 2, 1},          // Decrease at index 1
        {1, 3, 2, 4, 5},          // Decrease at index 2
        {10, 20, 30, 25, 40},     // Decrease at index 3
        {1, 1, 1, 1, 1},          // No decrease
        {1, 2, 3, 3, 2},          // Decrease at index 4
        {1},                      // Single element
        {},                       // Empty array
        {7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1}, // Decrease at index 14
        {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5} // No decrease
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test canArrange vs findFirstDecreaseIndex")
    void test_canArrange_vs_findFirstDecreaseIndex(int[] inputArray) {
        HumanEval_135 humanEval = new HumanEval_135();
        TransformedCode transformedCode = new TransformedCode();

        assertEquals(
            humanEval.canArrange(inputArray),
            transformedCode.findFirstDecreaseIndex(inputArray)
        );
    }
}