import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_97 {

    // Source Code
    static class HumanEval_97_Source {
        public static int multiply(int a, int b) {
            return Math.abs(a % 10) * Math.abs(b % 10);
        }
    }

    // Transformed Code
    static class HumanEval_97_Transformed {
        public static int calculateUnitDigitProduct(int x, int y) {
            int unitDigitX = Math.abs(x % 10);
            int unitDigitY = Math.abs(y % 10);
            int product = unitDigitX * unitDigitY;
            return product;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {123, 456},
        {-123, 456},
        {123, -456},
        {-123, -456},
        {0, 456},
        {123, 0},
        {0, 0},
        {789, 12345},
        {5, 9},
        {10, 10}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_97_Source.multiply((int) testCases[0][0], (int) testCases[0][1]), 
                     HumanEval_97_Transformed.calculateUnitDigitProduct((int) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_97_Source.multiply((int) testCases[1][0], (int) testCases[1][1]), 
                     HumanEval_97_Transformed.calculateUnitDigitProduct((int) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_97_Source.multiply((int) testCases[2][0], (int) testCases[2][1]), 
                     HumanEval_97_Transformed.calculateUnitDigitProduct((int) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_97_Source.multiply((int) testCases[3][0], (int) testCases[3][1]), 
                     HumanEval_97_Transformed.calculateUnitDigitProduct((int) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_97_Source.multiply((int) testCases[4][0], (int) testCases[4][1]), 
                     HumanEval_97_Transformed.calculateUnitDigitProduct((int) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_97_Source.multiply((int) testCases[5][0], (int) testCases[5][1]), 
                     HumanEval_97_Transformed.calculateUnitDigitProduct((int) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_97_Source.multiply((int) testCases[6][0], (int) testCases[6][1]), 
                     HumanEval_97_Transformed.calculateUnitDigitProduct((int) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_97_Source.multiply((int) testCases[7][0], (int) testCases[7][1]), 
                     HumanEval_97_Transformed.calculateUnitDigitProduct((int) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_97_Source.multiply((int) testCases[8][0], (int) testCases[8][1]), 
                     HumanEval_97_Transformed.calculateUnitDigitProduct((int) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_97_Source.multiply((int) testCases[9][0], (int) testCases[9][1]), 
                     HumanEval_97_Transformed.calculateUnitDigitProduct((int) testCases[9][0], (int) testCases[9][1]));
    }
}