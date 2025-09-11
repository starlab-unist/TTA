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
        public static int[] eat(int number, int need, int remaining) {
            if (need <= remaining) {
                return new int[]{number + need, remaining - need};
            } else {
                return new int[]{number + remaining, 0};
            }
        }
    }

    // Transformed Code
    static class HumanEval_159_Transformed {
        public static int[] consume(int quantity, int requirement, int stock) {
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
    private static final Object[][] testCases = {
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
        assertArrayEquals(HumanEval_159_Source.eat((int) testCases[0][0], (int) testCases[0][1], (int) testCases[0][2]), 
                          HumanEval_159_Transformed.consume((int) testCases[0][0], (int) testCases[0][1], (int) testCases[0][2]));
    }

    @Test
    public void test_1() {
        assertArrayEquals(HumanEval_159_Source.eat((int) testCases[1][0], (int) testCases[1][1], (int) testCases[1][2]), 
                          HumanEval_159_Transformed.consume((int) testCases[1][0], (int) testCases[1][1], (int) testCases[1][2]));
    }

    @Test
    public void test_2() {
        assertArrayEquals(HumanEval_159_Source.eat((int) testCases[2][0], (int) testCases[2][1], (int) testCases[2][2]), 
                          HumanEval_159_Transformed.consume((int) testCases[2][0], (int) testCases[2][1], (int) testCases[2][2]));
    }

    @Test
    public void test_3() {
        assertArrayEquals(HumanEval_159_Source.eat((int) testCases[3][0], (int) testCases[3][1], (int) testCases[3][2]), 
                          HumanEval_159_Transformed.consume((int) testCases[3][0], (int) testCases[3][1], (int) testCases[3][2]));
    }

    @Test
    public void test_4() {
        assertArrayEquals(HumanEval_159_Source.eat((int) testCases[4][0], (int) testCases[4][1], (int) testCases[4][2]), 
                          HumanEval_159_Transformed.consume((int) testCases[4][0], (int) testCases[4][1], (int) testCases[4][2]));
    }

    @Test
    public void test_5() {
        assertArrayEquals(HumanEval_159_Source.eat((int) testCases[5][0], (int) testCases[5][1], (int) testCases[5][2]), 
                          HumanEval_159_Transformed.consume((int) testCases[5][0], (int) testCases[5][1], (int) testCases[5][2]));
    }

    @Test
    public void test_6() {
        assertArrayEquals(HumanEval_159_Source.eat((int) testCases[6][0], (int) testCases[6][1], (int) testCases[6][2]), 
                          HumanEval_159_Transformed.consume((int) testCases[6][0], (int) testCases[6][1], (int) testCases[6][2]));
    }

    @Test
    public void test_7() {
        assertArrayEquals(HumanEval_159_Source.eat((int) testCases[7][0], (int) testCases[7][1], (int) testCases[7][2]), 
                          HumanEval_159_Transformed.consume((int) testCases[7][0], (int) testCases[7][1], (int) testCases[7][2]));
    }

    @Test
    public void test_8() {
        assertArrayEquals(HumanEval_159_Source.eat((int) testCases[8][0], (int) testCases[8][1], (int) testCases[8][2]), 
                          HumanEval_159_Transformed.consume((int) testCases[8][0], (int) testCases[8][1], (int) testCases[8][2]));
    }

    @Test
    public void test_9() {
        assertArrayEquals(HumanEval_159_Source.eat((int) testCases[9][0], (int) testCases[9][1], (int) testCases[9][2]), 
                          HumanEval_159_Transformed.consume((int) testCases[9][0], (int) testCases[9][1], (int) testCases[9][2]));
    }
}