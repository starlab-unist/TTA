import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_9 {

    // Source Code
    static class SourceCode {
        public static List<Integer> rollingMax(List<Integer> numbers) {
            Integer runningMax = null;
            List<Integer> result = new ArrayList<>();

            for (Integer n : numbers) {
                if (runningMax == null) {
                    runningMax = n;
                } else {
                    runningMax = Math.max(runningMax, n);
                }

                result.add(runningMax);
            }

            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> computeRollingMaximum(List<Integer> values) {
            Integer currentMax = null;
            List<Integer> maxHistory = new ArrayList<>();

            int index = 0;
            while (index < values.size()) {
                if (currentMax == null) {
                    currentMax = values.get(index);
                } else if (values.get(index) > currentMax) {
                    currentMax = values.get(index);
                }

                maxHistory.add(currentMax);
                index++;
            }

            return maxHistory;
        }
    }

    // Test Cases
    private static final List<Integer>[][] testCases = {
        {new ArrayList<>(), new ArrayList<>()}, // Empty list
        {List.of(5), List.of(5)}, // Single element
        {List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4, 5)}, // Increasing order
        {List.of(5, 4, 3, 2, 1), List.of(5, 5, 5, 5, 5)}, // Decreasing order
        {List.of(1, 5, 3, 6, 2), List.of(1, 5, 5, 6, 6)}, // Mixed order
        {List.of(3, 3, 3, 3, 3), List.of(3, 3, 3, 3, 3)}, // All same elements
        {List.of(10, 9, 8, 7, 11), List.of(10, 10, 10, 10, 11)}, // With a peak in the end
        {List.of(1, 2), List.of(1, 2)}, // Two elements increasing
        {List.of(2, 1), List.of(2, 2)}, // Two elements decreasing
        {List.of(1), List.of(1)} // Single element again for redundancy check
    };

    @Test
    public void test_0() {
        assertEquals(SourceCode.rollingMax(testCases[0][0]), TransformedCode.computeRollingMaximum(testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.rollingMax(testCases[1][0]), TransformedCode.computeRollingMaximum(testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.rollingMax(testCases[2][0]), TransformedCode.computeRollingMaximum(testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.rollingMax(testCases[3][0]), TransformedCode.computeRollingMaximum(testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.rollingMax(testCases[4][0]), TransformedCode.computeRollingMaximum(testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.rollingMax(testCases[5][0]), TransformedCode.computeRollingMaximum(testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.rollingMax(testCases[6][0]), TransformedCode.computeRollingMaximum(testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.rollingMax(testCases[7][0]), TransformedCode.computeRollingMaximum(testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.rollingMax(testCases[8][0]), TransformedCode.computeRollingMaximum(testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.rollingMax(testCases[9][0]), TransformedCode.computeRollingMaximum(testCases[9][0]));
    }
}