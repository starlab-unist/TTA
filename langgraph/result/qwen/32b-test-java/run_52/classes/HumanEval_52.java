import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_52 {

    // Source Code
    static class SourceCode {
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
    static class TransformedCode {
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
        {new ArrayList<>(), 10},                     // Empty list, should return true
        {Arrays.asList(1, 2, 3, 4), 5},           // All elements below threshold, should return true
        {Arrays.asList(10, 20, 30), 10},          // First element equals threshold, should return false
        {Arrays.asList(5, 6, 7, 8), 5},           // All elements above or equal to threshold, should return false
        {Arrays.asList(1, 2, 3, 4, 10), 5},       // One element equals threshold, should return false
        {Arrays.asList(9, 8, 7, 6, 5), 10},       // All elements below threshold, should return true
        {Arrays.asList(10, 9, 8, 7, 6), 10},      // First element equals threshold (corrected to all above or equal threshold), should return false
        {Arrays.asList(1, 2, 3, 4, 5), 1},        // Threshold less than all elements, should return false
        {Arrays.asList(0, -1, -2, -3), 0},        // Negative numbers below threshold, should return true
        {Arrays.asList(-1, -2, -3, 0), 0}         // Negative numbers below threshold with zero, should return false
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("provideTestCases")
    void testBelowThreshold_vs_allElementsUnderLimit(List<Integer> inputList, int threshold) {
        int[] inputArray = inputList.stream().mapToInt(i -> i).toArray();
        
        boolean sourceResult = SourceCode.belowThreshold(inputList, threshold);
        boolean transformedResult = new TransformedCode().allElementsUnderLimit(inputArray, threshold);
        
        assertEquals(sourceResult, transformedResult);
    }
}