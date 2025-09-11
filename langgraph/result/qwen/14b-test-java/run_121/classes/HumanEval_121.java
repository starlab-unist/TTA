import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_121 {

    // Source Code
    public static int solution(int[] lst) {
        int sum = 0;
        for (int idx = 0; idx < lst.length; idx++) {
            if (idx % 2 == 0 && lst[idx] % 2 == 1) {
                sum += lst[idx];
            }
        }
        return sum;
    }

    // Transformed Code
    public static int calculate_odd_sum_at_even_indices(int[] numbers) {
        int total = 0;
        int index = 0;
        while (index < numbers.length) {
            if (index % 2 == 0 && numbers[index] % 2 == 1) {
                total += numbers[index];
            }
            index += 1;
        }
        return total;
    }

    // Test Cases
    private static final int[][] testCases = {
        {1, 2, 3, 4, 5},          // Expected output: 9 (1 + 3 + 5)
        {2, 4, 6, 8, 10},         // Expected output: 0
        {1, 3, 5, 7, 9},          // Expected output: 15 (1 + 5 + 9)
        {},                       // Expected output: 0
        {1},                      // Expected output: 1
        {2, 2, 2, 2, 2, 2},       // Expected output: 0
        {1, 1, 1, 1, 1, 1},       // Expected output: 3 (1 + 1 + 1)
        {0, 1, 2, 3, 4, 5, 6},    // Expected output: 9 (1 + 3 + 5)
        {7, 8, 9, 10, 11, 12},    // Expected output: 18 (7 + 9 + 11)
        {13, 14, 15, 16, 17, 18}  // Expected output: 45 (13 + 15 + 17)
    };

    private static final int[] expectedOutputs = {
        9, 0, 15, 0, 1, 0, 3, 9, 18, 45
    };

    @Test
    public void test_0() {
        assertEquals(solution(testCases[0]), calculate_odd_sum_at_even_indices(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(solution(testCases[1]), calculate_odd_sum_at_even_indices(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(solution(testCases[2]), calculate_odd_sum_at_even_indices(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(solution(testCases[3]), calculate_odd_sum_at_even_indices(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(solution(testCases[4]), calculate_odd_sum_at_even_indices(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(solution(testCases[5]), calculate_odd_sum_at_even_indices(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(solution(testCases[6]), calculate_odd_sum_at_even_indices(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(solution(testCases[7]), calculate_odd_sum_at_even_indices(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(solution(testCases[8]), calculate_odd_sum_at_even_indices(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(solution(testCases[9]), calculate_odd_sum_at_even_indices(testCases[9]));
    }
}