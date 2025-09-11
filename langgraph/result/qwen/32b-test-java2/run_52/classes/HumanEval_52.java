import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
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

    @Test
    public void test_0() {
        assertEquals(HumanEval_52_Source.belowThreshold((List<Integer>) testCases[0][0], (int) testCases[0][1]), 
                     new HumanEval_52_Transformed().allElementsUnderLimit(((List<Integer>) testCases[0][0]).stream().mapToInt(Integer::intValue).toArray(), (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_52_Source.belowThreshold((List<Integer>) testCases[1][0], (int) testCases[1][1]), 
                     new HumanEval_52_Transformed().allElementsUnderLimit(((List<Integer>) testCases[1][0]).stream().mapToInt(Integer::intValue).toArray(), (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_52_Source.belowThreshold((List<Integer>) testCases[2][0], (int) testCases[2][1]), 
                     new HumanEval_52_Transformed().allElementsUnderLimit(((List<Integer>) testCases[2][0]).stream().mapToInt(Integer::intValue).toArray(), (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_52_Source.belowThreshold((List<Integer>) testCases[3][0], (int) testCases[3][1]), 
                     new HumanEval_52_Transformed().allElementsUnderLimit(((List<Integer>) testCases[3][0]).stream().mapToInt(Integer::intValue).toArray(), (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_52_Source.belowThreshold((List<Integer>) testCases[4][0], (int) testCases[4][1]), 
                     new HumanEval_52_Transformed().allElementsUnderLimit(((List<Integer>) testCases[4][0]).stream().mapToInt(Integer::intValue).toArray(), (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_52_Source.belowThreshold((List<Integer>) testCases[5][0], (int) testCases[5][1]), 
                     new HumanEval_52_Transformed().allElementsUnderLimit(((List<Integer>) testCases[5][0]).stream().mapToInt(Integer::intValue).toArray(), (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_52_Source.belowThreshold((List<Integer>) testCases[6][0], (int) testCases[6][1]), 
                     new HumanEval_52_Transformed().allElementsUnderLimit(((List<Integer>) testCases[6][0]).stream().mapToInt(Integer::intValue).toArray(), (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_52_Source.belowThreshold((List<Integer>) testCases[7][0], (int) testCases[7][1]), 
                     new HumanEval_52_Transformed().allElementsUnderLimit(((List<Integer>) testCases[7][0]).stream().mapToInt(Integer::intValue).toArray(), (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_52_Source.belowThreshold((List<Integer>) testCases[8][0], (int) testCases[8][1]), 
                     new HumanEval_52_Transformed().allElementsUnderLimit(((List<Integer>) testCases[8][0]).stream().mapToInt(Integer::intValue).toArray(), (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_52_Source.belowThreshold((List<Integer>) testCases[9][0], (int) testCases[9][1]), 
                     new HumanEval_52_Transformed().allElementsUnderLimit(((List<Integer>) testCases[9][0]).stream().mapToInt(Integer::intValue).toArray(), (int) testCases[9][1]));
    }
}