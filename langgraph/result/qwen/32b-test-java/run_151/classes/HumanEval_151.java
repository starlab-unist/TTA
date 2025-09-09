import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_151 {

    // Source Code
    static int doubleTheDifference(java.util.List<Integer> lst) {
        int sum = 0;
        for (int i : lst) {
            if (i > 0 && i % 2 != 0) {
                sum += i * i;
            }
        }
        return sum;
    }

    // Transformed Code
    static int calculateModifiedSum(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            if (num > 0 && num % 2 != 0) {
                total += num * num;
            }
        }
        return total;
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(doubleTheDifference(Arrays.asList(1, 2, 3, 4, 5)), calculateModifiedSum(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void test_1() {
        assertEquals(doubleTheDifference(Arrays.asList(-1, -3, -5, 0, 2, 4)), calculateModifiedSum(new int[]{-1, -3, -5, 0, 2, 4}));
    }

    @Test
    public void test_2() {
        assertEquals(doubleTheDifference(Arrays.asList(7, 11, 13, 17)), calculateModifiedSum(new int[]{7, 11, 13, 17}));
    }

    @Test
    public void test_3() {
        assertEquals(doubleTheDifference(Arrays.asList(8, 10, 12, 14)), calculateModifiedSum(new int[]{8, 10, 12, 14}));
    }

    @Test
    public void test_4() {
        assertEquals(doubleTheDifference(Arrays.asList()), calculateModifiedSum(new int[]{}));
    }

    @Test
    public void test_5() {
        assertEquals(doubleTheDifference(Arrays.asList(21, 23, 25, 0, -27)), calculateModifiedSum(new int[]{21, 23, 25, 0, -27}));
    }

    @Test
    public void test_6() {
        assertEquals(doubleTheDifference(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1)), calculateModifiedSum(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    @Test
    public void test_7() {
        assertEquals(doubleTheDifference(Arrays.asList(0)), calculateModifiedSum(new int[]{0}));
    }

    // Additional simple test cases
    @Test
    public void test_8() {
        assertEquals(doubleTheDifference(Arrays.asList(3)), calculateModifiedSum(new int[]{3})); // Single positive odd integer
    }

    @Test
    public void test_9() {
        assertEquals(doubleTheDifference(Arrays.asList(-5)), calculateModifiedSum(new int[]{-5})); // Single negative integer
    }

    @Test
    public void test_10() {
        assertEquals(doubleTheDifference(Arrays.asList(2, 4, 6)), calculateModifiedSum(new int[]{2, 4, 6})); // Only even integers
    }

    @Test
    public void test_11() {
        assertEquals(doubleTheDifference(Arrays.asList(1, 3, 5, 7, 9)), calculateModifiedSum(new int[]{1, 3, 5, 7, 9})); // Only odd integers
    }

    @Test
    public void test_12() {
        assertEquals(doubleTheDifference(Arrays.asList(0, 0, 0)), calculateModifiedSum(new int[]{0, 0, 0})); // Only zeros
    }

    @Test
    public void test_13() {
        assertEquals(doubleTheDifference(Arrays.asList(-1, -3, -5, 7, 9)), calculateModifiedSum(new int[]{-1, -3, -5, 7, 9})); // Mixed negatives and positives
    }

    @Test
    public void test_14() {
        assertEquals(doubleTheDifference(Arrays.asList(15, 20, 25, 30, 35)), calculateModifiedSum(new int[]{15, 20, 25, 30, 35})); // Mixed odd and even
    }

    @Test
    public void test_15() {
        assertEquals(doubleTheDifference(Arrays.asList(1)), calculateModifiedSum(new int[]{1})); // Single positive odd integer
    }

    @Test
    public void test_16() {
        assertEquals(doubleTheDifference(Arrays.asList(2)), calculateModifiedSum(new int[]{2})); // Single even integer
    }

    @Test
    public void test_17() {
        assertEquals(doubleTheDifference(Arrays.asList(5, 10, 15)), calculateModifiedSum(new int[]{5, 10, 15})); // Mixed odd and even integers
    }

    @Test
    public void test_18() {
        assertEquals(doubleTheDifference(Arrays.asList(-7, -2, 3, 4)), calculateModifiedSum(new int[]{-7, -2, 3, 4})); // Negative, positive mixed
    }

    @Test
    public void test_19() {
        assertEquals(doubleTheDifference(Arrays.asList(100, 101, 102, 103)), calculateModifiedSum(new int[]{100, 101, 102, 103})); // Larger numbers
    }
}