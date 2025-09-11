import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_128 {

    // Source Code
    static class HumanEval_128_Source {
        public static Integer prodSigns(int[] arr) {
            if (arr.length == 0) return null;
            
            int zeroCount = 0;
            int negativeCount = 0;
            
            for (int num : arr) {
                if (num == 0) zeroCount++;
                else if (num < 0) negativeCount++;
            }
            
            if (zeroCount > 0) return 0;
            else return (int) Math.pow(-1, negativeCount) * Arrays.stream(arr).map(Math::abs).sum();
        }
    }

    // Transformed Code
    static class HumanEval_128_Transformed {
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
                    break;
                }
            }

            int sign = containsZero ? 0 : (int) Math.pow(-1, negativeCount);
            int totalSum = 0;

            for (int num : numbers) {
                totalSum += Math.abs(num);
            }

            return sign * totalSum;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
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
        assertEquals(HumanEval_128_Source.prodSigns(testCases[0]), HumanEval_128_Transformed.calculateSignedSum(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_128_Source.prodSigns(testCases[1]), HumanEval_128_Transformed.calculateSignedSum(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_128_Source.prodSigns(testCases[2]), HumanEval_128_Transformed.calculateSignedSum(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_128_Source.prodSigns(testCases[3]), HumanEval_128_Transformed.calculateSignedSum(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_128_Source.prodSigns(testCases[4]), HumanEval_128_Transformed.calculateSignedSum(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_128_Source.prodSigns(testCases[5]), HumanEval_128_Transformed.calculateSignedSum(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_128_Source.prodSigns(testCases[6]), HumanEval_128_Transformed.calculateSignedSum(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_128_Source.prodSigns(testCases[7]), HumanEval_128_Transformed.calculateSignedSum(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_128_Source.prodSigns(testCases[8]), HumanEval_128_Transformed.calculateSignedSum(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_128_Source.prodSigns(testCases[9]), HumanEval_128_Transformed.calculateSignedSum(testCases[9]));
    }
}