import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_40 {

    // Source Code
    static class SourceCode {
        public boolean triplesSumToZero(List<Integer> l) {
            for (int i = 0; i < l.size(); i++) {
                for (int j = i + 1; j < l.size(); j++) {
                    for (int k = j + 1; k < l.size(); k++) {
                        if (l.get(i) + l.get(j) + l.get(k) == 0) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean checkForZeroSumTriplets(int[] numbers) {
            int length = numbers.length;
            int indexI = 0;

            while (indexI < length) {
                int indexJ = indexI + 1;
                while (indexJ < length) {
                    int indexK = indexJ + 1;
                    while (indexK < length) {
                        if (numbers[indexI] + numbers[indexJ] + numbers[indexK] == 0) {
                            return true;
                        }
                        indexK++;
                    }
                    indexJ++;
                }
                indexI++;
            }

            return false;
        }
    }

    // Helper method to convert int[] to List<Integer>
    private static List<Integer> convertArrayToList(int[] array) {
        Integer[] boxedArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
        return Arrays.asList(boxedArray);
    }

    // Test Cases
    private static final int[][] testCases = new int[][]{
        {1, 2, -3},          // Simple case with sum zero
        {-1, 0, 1},          // Another simple case with sum zero
        {1, 2, 3},           // No triplets sum to zero
        {0, 0, 0},           // All elements are zero
        {1, -1, 2, -2, 3},   // Multiple pairs but no triplet sums to zero
        {-5, 2, 3, 4, 1},    // Triplet (-5, 2, 3) sums to zero
        {1, -1, 2, -2, 0},   // Triplet (1, -1, 0) sums to zero
        {5, 5, 5, -15},      // Triplet (5, 5, -15) sums to zero
        {-2, 0, 2, 0},       // Multiple triplets with zeros and non-zeros
        {}                   // Empty list should return False
    };

    @Test
    public void test_0() {
        assertEquals(SourceCode.triplesSumToZero(convertArrayToList(testCases[0])), TransformedCode.checkForZeroSumTriplets(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.triplesSumToZero(convertArrayToList(testCases[1])), TransformedCode.checkForZeroSumTriplets(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.triplesSumToZero(convertArrayToList(testCases[2])), TransformedCode.checkForZeroSumTriplets(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.triplesSumToZero(convertArrayToList(testCases[3])), TransformedCode.checkForZeroSumTriplets(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.triplesSumToZero(convertArrayToList(testCases[4])), TransformedCode.checkForZeroSumTriplets(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.triplesSumToZero(convertArrayToList(testCases[5])), TransformedCode.checkForZeroSumTriplets(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.triplesSumToZero(convertArrayToList(testCases[6])), TransformedCode.checkForZeroSumTriplets(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.triplesSumToZero(convertArrayToList(testCases[7])), TransformedCode.checkForZeroSumTriplets(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.triplesSumToZero(convertArrayToList(testCases[8])), TransformedCode.checkForZeroSumTriplets(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.triplesSumToZero(convertArrayToList(testCases[9])), TransformedCode.checkForZeroSumTriplets(testCases[9]));
    }
}