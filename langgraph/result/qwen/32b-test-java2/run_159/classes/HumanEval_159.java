import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HumanEval_159 {

    // Source Code
    static class HumanEval_159_Source {
        public int[] eat(int number, int need, int remaining) {
            if (need <= remaining) {
                return new int[]{number + need, remaining - need};
            } else {
                return new int[]{number + remaining, 0};
            }
        }
    }

    // Transformed Code
    static class HumanEval_159_Transformed {
        public int[] consume(int quantity, int requirement, int stock) {
            int updatedQuantity;
            int leftoverStock;

            if (requirement <= stock) {
                updatedQuantity = quantity + requirement;
                leftoverStock = stock - requirement;
            } else {
                updatedQuantity = quantity + stock;
                leftoverStock = 0;
            }

            return new int[]{updatedQuantity, leftoverStock};
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {10, 5, 8},
        {20, 15, 10},
        {0, 0, 0},
        {1, 2, 3},
        {5, 5, 5},
        {100, 50, 75},
        {42, 99, 10},
        {7, 0, 5},
        {3, 3, 2},
        {8, 10, 8}
    };

    @Test
    public void test_0() {
        assertArrayEquals(new HumanEval_159_Source().eat(testCases[0][0], testCases[0][1], testCases[0][2]), 
                          new HumanEval_159_Transformed().consume(testCases[0][0], testCases[0][1], testCases[0][2]));
    }

    @Test
    public void test_1() {
        assertArrayEquals(new HumanEval_159_Source().eat(testCases[1][0], testCases[1][1], testCases[1][2]), 
                          new HumanEval_159_Transformed().consume(testCases[1][0], testCases[1][1], testCases[1][2]));
    }

    @Test
    public void test_2() {
        assertArrayEquals(new HumanEval_159_Source().eat(testCases[2][0], testCases[2][1], testCases[2][2]), 
                          new HumanEval_159_Transformed().consume(testCases[2][0], testCases[2][1], testCases[2][2]));
    }

    @Test
    public void test_3() {
        assertArrayEquals(new HumanEval_159_Source().eat(testCases[3][0], testCases[3][1], testCases[3][2]), 
                          new HumanEval_159_Transformed().consume(testCases[3][0], testCases[3][1], testCases[3][2]));
    }

    @Test
    public void test_4() {
        assertArrayEquals(new HumanEval_159_Source().eat(testCases[4][0], testCases[4][1], testCases[4][2]), 
                          new HumanEval_159_Transformed().consume(testCases[4][0], testCases[4][1], testCases[4][2]));
    }

    @Test
    public void test_5() {
        assertArrayEquals(new HumanEval_159_Source().eat(testCases[5][0], testCases[5][1], testCases[5][2]), 
                          new HumanEval_159_Transformed().consume(testCases[5][0], testCases[5][1], testCases[5][2]));
    }

    @Test
    public void test_6() {
        assertArrayEquals(new HumanEval_159_Source().eat(testCases[6][0], testCases[6][1], testCases[6][2]), 
                          new HumanEval_159_Transformed().consume(testCases[6][0], testCases[6][1], testCases[6][2]));
    }

    @Test
    public void test_7() {
        assertArrayEquals(new HumanEval_159_Source().eat(testCases[7][0], testCases[7][1], testCases[7][2]), 
                          new HumanEval_159_Transformed().consume(testCases[7][0], testCases[7][1], testCases[7][2]));
    }

    @Test
    public void test_8() {
        assertArrayEquals(new HumanEval_159_Source().eat(testCases[8][0], testCases[8][1], testCases[8][2]), 
                          new HumanEval_159_Transformed().consume(testCases[8][0], testCases[8][1], testCases[8][2]));
    }

    @Test
    public void test_9() {
        assertArrayEquals(new HumanEval_159_Source().eat(testCases[9][0], testCases[9][1], testCases[9][2]), 
                          new HumanEval_159_Transformed().consume(testCases[9][0], testCases[9][1], testCases[9][2]));
    }
}