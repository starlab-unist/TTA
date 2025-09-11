import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_72 {

    // Source Code
    public static boolean willItFly(int[] q, int w) {
        int sum = 0;
        for (int num : q) {
            sum += num;
        }
        if (sum > w) {
            return false;
        }

        int i = 0, j = q.length - 1;
        while (i < j) {
            if (q[i] != q[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Transformed Code
    public static boolean can_it_take_off(int[] weights, int max_weight) {
        int total_weight = 0;
        for (int weight : weights) {
            total_weight += weight;
        }

        if (total_weight > max_weight) {
            return false;
        }

        int start = 0, end = weights.length - 1;
        while (start < end) {
            if (weights[start] != weights[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new int[]{1, 2, 3, 2, 1}, 10},
        {new int[]{1, 2, 3, 4, 5}, 15},
        {new int[]{1, 1, 1, 1}, 4},
        {new int[]{1, 2, 2, 1}, 6},
        {new int[]{1}, 1},
        {new int[]{}, 0},
        {new int[]{5, 5, 5, 5}, 20},
        {new int[]{5, 5, 5, 5}, 19},
        {new int[]{1, 2, 3, 4, 3, 2, 1}, 20},
        {new int[]{1, 2, 3, 4, 5, 6, 7}, 28}
    };

    @Test
    public void test_0() {
        assertEquals(willItFly((int[]) testCases[0][0], (int) testCases[0][1]), 
                     can_it_take_off((int[]) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(willItFly((int[]) testCases[1][0], (int) testCases[1][1]), 
                     can_it_take_off((int[]) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(willItFly((int[]) testCases[2][0], (int) testCases[2][1]), 
                     can_it_take_off((int[]) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(willItFly((int[]) testCases[3][0], (int) testCases[3][1]), 
                     can_it_take_off((int[]) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(willItFly((int[]) testCases[4][0], (int) testCases[4][1]), 
                     can_it_take_off((int[]) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(willItFly((int[]) testCases[5][0], (int) testCases[5][1]), 
                     can_it_take_off((int[]) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(willItFly((int[]) testCases[6][0], (int) testCases[6][1]), 
                     can_it_take_off((int[]) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(willItFly((int[]) testCases[7][0], (int) testCases[7][1]), 
                     can_it_take_off((int[]) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(willItFly((int[]) testCases[8][0], (int) testCases[8][1]), 
                     can_it_take_off((int[]) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(willItFly((int[]) testCases[9][0], (int) testCases[9][1]), 
                     can_it_take_off((int[]) testCases[9][0], (int) testCases[9][1]));
    }
}