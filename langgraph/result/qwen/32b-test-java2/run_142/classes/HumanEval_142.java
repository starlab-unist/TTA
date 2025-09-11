import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_142 {

    // Source Code
    static class HumanEval_142_Source {
        public static int sumSquares(List<Integer> lst) {
            int sum = 0;
            for (int i = 0; i < lst.size(); i++) {
                int value;
                if (i % 3 == 0) {
                    value = lst.get(i) * lst.get(i);
                } else if (i % 4 == 0) {
                    value = lst.get(i) * lst.get(i) * lst.get(i);
                } else {
                    value = lst.get(i);
                }
                sum += value;
            }
            return sum;
        }
    }

    // Transformed Code
    static class HumanEval_142_Transformed {
        public static int calculateModifiedSum(int[] numbers) {
            int total = 0;
            int index = 0;
            while (index < numbers.length) {
                if (index % 3 == 0) {
                    total += Math.pow(numbers[index], 2);
                } else if (index % 4 == 0) {
                    total += Math.pow(numbers[index], 3);
                } else {
                    total += numbers[index];
                }
                index++;
            }
            return total;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 4, 5},          // Simple list with small integers
        {0, 0, 0, 0, 0},          // List of zeros
        {1, 1, 1, 1, 1},          // List of ones
        {-1, -2, -3, -4, -5},     // Simple list with negative integers
        {10, 20, 30, 40, 50},     // List of larger integers
        {9, 8, 7, 6, 5},          // Decreasing list of integers
        {1, -1, 1, -1, 1},        // Alternating positive and negative integers
        {},                       // Empty list
        {2, 3, 4, 5, 6, 7, 8},    // Simple list with small integers
        {5, 0, 10, 0, 15}         // List containing zeros
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_142_Source.sumSquares(List.of(1, 2, 3, 4, 5)), 
                     HumanEval_142_Transformed.calculateModifiedSum(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_142_Source.sumSquares(List.of(0, 0, 0, 0, 0)), 
                     HumanEval_142_Transformed.calculateModifiedSum(new int[]{0, 0, 0, 0, 0}));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_142_Source.sumSquares(List.of(1, 1, 1, 1, 1)), 
                     HumanEval_142_Transformed.calculateModifiedSum(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_142_Source.sumSquares(List.of(-1, -2, -3, -4, -5)), 
                     HumanEval_142_Transformed.calculateModifiedSum(new int[]{-1, -2, -3, -4, -5}));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_142_Source.sumSquares(List.of(10, 20, 30, 40, 50)), 
                     HumanEval_142_Transformed.calculateModifiedSum(new int[]{10, 20, 30, 40, 50}));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_142_Source.sumSquares(List.of(9, 8, 7, 6, 5)), 
                     HumanEval_142_Transformed.calculateModifiedSum(new int[]{9, 8, 7, 6, 5}));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_142_Source.sumSquares(List.of(1, -1, 1, -1, 1)), 
                     HumanEval_142_Transformed.calculateModifiedSum(new int[]{1, -1, 1, -1, 1}));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_142_Source.sumSquares(List.of()), 
                     HumanEval_142_Transformed.calculateModifiedSum(new int[]{}));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_142_Source.sumSquares(List.of(2, 3, 4, 5, 6, 7, 8)), 
                     HumanEval_142_Transformed.calculateModifiedSum(new int[]{2, 3, 4, 5, 6, 7, 8}));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_142_Source.sumSquares(List.of(5, 0, 10, 0, 15)), 
                     HumanEval_142_Transformed.calculateModifiedSum(new int[]{5, 0, 10, 0, 15}));
    }
}