import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_69 {

    // Source Code
    static class HumanEval_69 {
        public static int search(int[] lst) {
            int maxVal = 0;
            for (int num : lst) {
                if (num > maxVal) {
                    maxVal = num;
                }
            }

            int[] frq = new int[maxVal + 1];
            for (int i : lst) {
                frq[i]++;
            }

            int ans = -1;
            for (int i = 1; i < frq.length; i++) {
                if (frq[i] >= i) {
                    ans = i;
                }
            }

            return ans;
        }
    }

    // Transformed Code
    static class HumanEval_69_Transformed {
        public int findMaxFrequencyIndex(int[] numbers) {
            int maxValue = 0;
            for (int number : numbers) {
                if (number > maxValue) {
                    maxValue = number;
                }
            }
            
            int[] frequencyArray = new int[maxValue + 1];
            
            for (int number : numbers) {
                frequencyArray[number] += 1;
            }

            int result = -1;
            int index = 1;
            while (index < frequencyArray.length) {
                if (frequencyArray[index] >= index) {
                    result = index;
                }
                index += 1;
            }

            return result;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 2, 3, 3, 3},       // Expected output: 3
        {4, 5, 6, 7, 8, 9, 10},   // Expected output: -1
        {1, 1, 1, 1, 1},          // Expected output: 1
        {2, 2, 3, 3, 4, 4, 4, 4}, // Expected output: 4
        {1, 2, 3, 4, 5},          // Expected output: -1
        {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, // Expected output: 1
        {1, 1, 2, 2, 2, 3, 3, 3, 3}, // Expected output: 3
        {5, 5, 5, 5, 5, 5},       // Expected output: 5
        {1},                      // Expected output: 1
        {},                       // Expected output: -1
        {3, 3, 3, 2, 2, 1},       // Expected output: 3
        {6, 6, 6, 6, 6, 6, 6},    // Expected output: 6
        {7, 8, 9, 10, 10, 10},    // Expected output: -1
        {2, 3, 4, 5, 6, 6, 6},    // Expected output: 3
        {1, 1, 1, 2, 2, 2, 2}     // Expected output: 2
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_69.search(testCases[0]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_69.search(testCases[1]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_69.search(testCases[2]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_69.search(testCases[3]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_69.search(testCases[4]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_69.search(testCases[5]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_69.search(testCases[6]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_69.search(testCases[7]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_69.search(testCases[8]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_69.search(testCases[9]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[9]));
    }

    @Test
    public void test_10() {
        assertEquals(HumanEval_69.search(testCases[10]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[10]));
    }

    @Test
    public void test_11() {
        assertEquals(HumanEval_69.search(testCases[11]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[11]));
    }

    @Test
    public void test_12() {
        assertEquals(HumanEval_69.search(testCases[12]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[12]));
    }

    @Test
    public void test_13() {
        assertEquals(HumanEval_69.search(testCases[13]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[13]));
    }

    @Test
    public void test_14() {
        assertEquals(HumanEval_69.search(testCases[14]), new HumanEval_69_Transformed().findMaxFrequencyIndex(testCases[14]));
    }
}