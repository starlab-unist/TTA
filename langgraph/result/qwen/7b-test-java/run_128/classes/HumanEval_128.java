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
    public static Integer prodSigns(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int prod = 0;
        if (containsZero(arr)) {
            prod = 0;
        } else {
            prod = (int) Math.pow(-1, countNegatives(arr));
        }
        return prod * sumOfAbsValues(arr);
    }

    private static boolean containsZero(int[] arr) {
        for (int num : arr) {
            if (num == 0) {
                return true;
            }
        }
        return false;
    }

    private static long countNegatives(int[] arr) {
        return Arrays.stream(arr).filter(num -> num < 0).count();
    }

    private static long sumOfAbsValues(int[] arr) {
        return Arrays.stream(arr).map(Math::abs).sum();
    }

    // Transformed Code
    public static Integer calculateSignedSum(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        
        int negativeCount = 0;
        boolean containsZero = false;
        
        for (int num : arr) {
            if (num < 0) {
                negativeCount++;
            } else if (num == 0) {
                containsZero = true;
                break;
            }
        }
        
        int sign = containsZero ? 0 : (int) Math.pow(-1, negativeCount);
        int totalSum = 0;
        
        for (int num : arr) {
            totalSum += Math.abs(num);
        }
        
        return sign * totalSum;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3}, null},
        {new int[]{-1, -2, -3}, null},
        {new int[]{1, -2, 3}, null},
        {new int[]{0, 1, 2, 3}, null},
        {new int[]{0, -1, -2, -3}, null},
        {new int[]{}, null},
        {new int[]{5, 7, -9, 12}, null},
        {new int[]{-5, -7, 9, -12}, null},
        {new int[]{0, 0, 0}, null},
        {new int[]{1, 1, 1, -1, -1, -1}, null}
    };

    @Test
    public void test_0() {
        assertEquals(prodSigns((int[]) testCases[0][0]), calculateSignedSum((int[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(prodSigns((int[]) testCases[1][0]), calculateSignedSum((int[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(prodSigns((int[]) testCases[2][0]), calculateSignedSum((int[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(prodSigns((int[]) testCases[3][0]), calculateSignedSum((int[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(prodSigns((int[]) testCases[4][0]), calculateSignedSum((int[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(prodSigns((int[]) testCases[5][0]), calculateSignedSum((int[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(prodSigns((int[]) testCases[6][0]), calculateSignedSum((int[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(prodSigns((int[]) testCases[7][0]), calculateSignedSum((int[]) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(prodSigns((int[]) testCases[8][0]), calculateSignedSum((int[]) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(prodSigns((int[]) testCases[9][0]), calculateSignedSum((int[]) testCases[9][0]));
    }
}