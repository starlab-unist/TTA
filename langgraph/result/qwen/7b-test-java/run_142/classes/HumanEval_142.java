import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_142 {

    // Source Code
    public static int sumSquares(List<Integer> lst) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            if (i % 3 == 0) {
                result.add(lst.get(i) * lst.get(i));
            } else if (i % 4 == 0 && i % 3 != 0) {
                result.add(lst.get(i) * lst.get(i) * lst.get(i));
            } else {
                result.add(lst.get(i));
            }
        }
        return result.stream().mapToInt(Integer::intValue).sum();
    }

    // Transformed Code
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

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(1, 2, 3, 4, 5)},          // Simple list with small integers
        {List.of(0, 0, 0, 0, 0)},          // List of zeros
        {List.of(1, 1, 1, 1, 1)},          // List of ones
        {List.of(-1, -2, -3, -4, -5)},     // Simple list with negative integers
        {List.of(10, 20, 30, 40, 50)},     // List of larger integers
        {List.of(9, 8, 7, 6, 5)},          // Decreasing list of integers
        {List.of(1, -1, 1, -1, 1)},        // Alternating positive and negative integers
        {List.of()},                       // Empty list
        {List.of(2, 3, 4, 5, 6, 7, 8)},    // Simple list with small integers
        {List.of(5, 0, 10, 0, 15)}         // List containing zeros
    };

    @Test
    public void test_0() {
        assertEquals(sumSquares((List<Integer>) testCases[0][0]), 
                     calculateModifiedSum(((List<Integer>) testCases[0][0]).stream().mapToInt(Integer::intValue).toArray()));
    }

    @Test
    public void test_1() {
        assertEquals(sumSquares((List<Integer>) testCases[1][0]), 
                     calculateModifiedSum(((List<Integer>) testCases[1][0]).stream().mapToInt(Integer::intValue).toArray()));
    }

    @Test
    public void test_2() {
        assertEquals(sumSquares((List<Integer>) testCases[2][0]), 
                     calculateModifiedSum(((List<Integer>) testCases[2][0]).stream().mapToInt(Integer::intValue).toArray()));
    }

    @Test
    public void test_3() {
        assertEquals(sumSquares((List<Integer>) testCases[3][0]), 
                     calculateModifiedSum(((List<Integer>) testCases[3][0]).stream().mapToInt(Integer::intValue).toArray()));
    }

    @Test
    public void test_4() {
        assertEquals(sumSquares((List<Integer>) testCases[4][0]), 
                     calculateModifiedSum(((List<Integer>) testCases[4][0]).stream().mapToInt(Integer::intValue).toArray()));
    }

    @Test
    public void test_5() {
        assertEquals(sumSquares((List<Integer>) testCases[5][0]), 
                     calculateModifiedSum(((List<Integer>) testCases[5][0]).stream().mapToInt(Integer::intValue).toArray()));
    }

    @Test
    public void test_6() {
        assertEquals(sumSquares((List<Integer>) testCases[6][0]), 
                     calculateModifiedSum(((List<Integer>) testCases[6][0]).stream().mapToInt(Integer::intValue).toArray()));
    }

    @Test
    public void test_7() {
        assertEquals(sumSquares((List<Integer>) testCases[7][0]), 
                     calculateModifiedSum(((List<Integer>) testCases[7][0]).stream().mapToInt(Integer::intValue).toArray()));
    }

    @Test
    public void test_8() {
        assertEquals(sumSquares((List<Integer>) testCases[8][0]), 
                     calculateModifiedSum(((List<Integer>) testCases[8][0]).stream().mapToInt(Integer::intValue).toArray()));
    }

    @Test
    public void test_9() {
        assertEquals(sumSquares((List<Integer>) testCases[9][0]), 
                     calculateModifiedSum(((List<Integer>) testCases[9][0]).stream().mapToInt(Integer::intValue).toArray()));
    }
}