import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_128 {

    // Source Code
    public static Integer prodSigns(int[] arr) {
        if (arr.length == 0) return null;
        int countNegatives = 0;
        int sumOfAbsValues = 0;
        boolean containsZero = false;

        for (int num : arr) {
            if (num == 0) {
                containsZero = true;
            }
            if (num < 0) {
                countNegatives++;
            }
            sumOfAbsValues += Math.abs(num);
        }

        int prod = containsZero ? 0 : (countNegatives % 2 == 0) ? 1 : -1;
        return prod * sumOfAbsValues;
    }

    // Transformed Code
    public static Integer calculateSignedSum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        
        int negativeCount = 0;
        boolean containsZero = false;
        
        for (int num : numbers) {
            if (num < 0) {
                negativeCount++;
            }
            if (num == 0) {
                containsZero = true;
            }
        }
        
        int sign = containsZero ? 0 : (negativeCount % 2 == 0) ? 1 : -1;
        int totalSum = 0;
        
        for (int num : numbers) {
            totalSum += Math.abs(num);
        }
        
        return sign * totalSum;
    }

    // Test Cases
    private static final Integer[][] testCases = {
        {1, 2, 3},
        {-1, -2, -3},
        {1, -2, 3},
        {0, 1, 2, 3},
        {0, -1, -2, -3},
        {},
        {5, 7, -9, 12},
        {-5, -7, 9, -12},
        {0, 0, 0},
        {1, 1, 1, -1, -1, -1}
    };

    @Test
    public void test_0() {
        assertEquals(prodSigns(testCases[0]), calculateSignedSum(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(prodSigns(testCases[1]), calculateSignedSum(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(prodSigns(testCases[2]), calculateSignedSum(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(prodSigns(testCases[3]), calculateSignedSum(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(prodSigns(testCases[4]), calculateSignedSum(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(prodSigns(testCases[5]), calculateSignedSum(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(prodSigns(testCases[6]), calculateSignedSum(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(prodSigns(testCases[7]), calculateSignedSum(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(prodSigns(testCases[8]), calculateSignedSum(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(prodSigns(testCases[9]), calculateSignedSum(testCases[9]));
    }

    // Additional Simple Test Cases
    @Test
    public void test_10() {
        assertEquals(prodSigns(new int[]{4, 5}), calculateSignedSum(new int[]{4, 5}));
    }

    @Test
    public void test_11() {
        assertEquals(prodSigns(new int[]{-4, -5}), calculateSignedSum(new int[]{-4, -5}));
    }

    @Test
    public void test_12() {
        assertEquals(prodSigns(new int[]{0}), calculateSignedSum(new int[]{0}));
    }

    @Test
    public void test_13() {
        assertEquals(prodSigns(new int[]{1, 0, -1}), calculateSignedSum(new int[]{1, 0, -1}));
    }

    @Test
    public void test_14() {
        assertEquals(prodSigns(new int[]{-1, -2, 0, 3}), calculateSignedSum(new int[]{-1, -2, 0, 3}));
    }
}