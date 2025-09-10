// Source Code
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream; // Added import for Stream
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments; // Added import for Arguments

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_52 {

    // Source Code
    static class HumanEval_52_Source {
        public static boolean belowThreshold(List<Integer> l, int t) {
            for (int e : l) {
                if (e >= t) {
                    return false;
                }
            }
            return true;
        }
    }

    // Transformed Code
    static class HumanEval_52_Transformed {
        public boolean allElementsUnderLimit(int[] elements, int threshold) {
            int index = 0;
            while (index < elements.length) {
                if (elements[index] >= threshold) {
                    return false;
                }
                index++;
            }
            return true;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(), 10},                     // Empty list
        {Arrays.asList(1, 2, 3, 4), 5},           // All elements below threshold
        {Arrays.asList(10, 20, 30), 10},          // First element equals threshold
        {Arrays.asList(5, 6, 7, 8), 5},           // First element equals threshold
        {Arrays.asList(1, 2, 3, 4, 10), 5},       // One element above threshold
        {Arrays.asList(9, 8, 7, 6, 5), 10},       // All elements below threshold
        {Arrays.asList(10, 9, 8, 7, 6), 10},      // First element equals threshold
        {Arrays.asList(1, 2, 3, 4, 5), 1},        // Threshold less than all elements
        {Arrays.asList(0, -1, -2, -3), 0},        // Negative numbers below threshold
        {Arrays.asList(-1, -2, -3, 0), 0}         // Negative numbers below threshold with zero
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "{index}: {0}, {1}")
    @MethodSource("provideTestCases")
    void belowThreshold_vs_allElementsUnderLimit(List<Integer> inputList, int threshold) {
        int[] inputArray = inputList.stream().mapToInt(i -> i).toArray();
        
        assertEquals(
            HumanEval_52_Source.belowThreshold(inputList, threshold),
            new HumanEval_52_Transformed().allElementsUnderLimit(inputArray, threshold)
        );
    }
}