import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_122 {

    // Source Code
    public static int addElements(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k && i < arr.length; i++) {
            if (String.valueOf(arr[i]).length() <= 2) {
                sum += arr[i];
            }
        }
        return sum;
    }

    // Transformed Code
    public int calculateSumOfSmallNumbers(int[] numbers, int count) {
        int total = 0;
        int index = 0;
        
        while (index < count && index < numbers.length) {
            if (String.valueOf(numbers[index]).length() <= 2) {
                total += numbers[index];
            }
            index++;
        }
        
        return total;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 10, 100, 1000}, 3},
        {new int[]{5, 23, 456, 7890}, 4},
        {new int[]{99, 100, 101, 102}, 2},
        {new int[]{1, 2, 3, 4, 5}, 5},
        {new int[]{123, 45, 67, 89, 10}, 5},
        {new int[]{111, 222, 333, 44, 55}, 3},
        {new int[]{1, 1, 1, 1, 1}, 1},
        {new int[]{}, 1},
        {new int[]{10, 20, 30, 40, 50}, 0},
        {new int[]{9, 8, 7, 6, 5}, 5}
    };

    @Test
    public void test_0() {
        assertEquals(addElements((int[]) testCases[0][0], (int) testCases[0][1]), 
                     new HumanEval_122().calculateSumOfSmallNumbers((int[]) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(addElements((int[]) testCases[1][0], (int) testCases[1][1]), 
                     new HumanEval_122().calculateSumOfSmallNumbers((int[]) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(addElements((int[]) testCases[2][0], (int) testCases[2][1]), 
                     new HumanEval_122().calculateSumOfSmallNumbers((int[]) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(addElements((int[]) testCases[3][0], (int) testCases[3][1]), 
                     new HumanEval_122().calculateSumOfSmallNumbers((int[]) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(addElements((int[]) testCases[4][0], (int) testCases[4][1]), 
                     new HumanEval_122().calculateSumOfSmallNumbers((int[]) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(addElements((int[]) testCases[5][0], (int) testCases[5][1]), 
                     new HumanEval_122().calculateSumOfSmallNumbers((int[]) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(addElements((int[]) testCases[6][0], (int) testCases[6][1]), 
                     new HumanEval_122().calculateSumOfSmallNumbers((int[]) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(addElements((int[]) testCases[7][0], (int) testCases[7][1]), 
                     new HumanEval_122().calculateSumOfSmallNumbers((int[]) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(addElements((int[]) testCases[8][0], (int) testCases[8][1]), 
                     new HumanEval_122().calculateSumOfSmallNumbers((int[]) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(addElements((int[]) testCases[9][0], (int) testCases[9][1]), 
                     new HumanEval_122().calculateSumOfSmallNumbers((int[]) testCases[9][0], (int) testCases[9][1]));
    }
}