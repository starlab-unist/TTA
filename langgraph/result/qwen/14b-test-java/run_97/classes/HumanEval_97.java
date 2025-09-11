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
    public static int multiply(int a, int b) {
        return Math.abs(a % 10) * Math.abs(b % 10);
    }

    // Transformed Code
    public static int calculateUnitDigitProduct(int x, int y) {
        int unitDigitX = Math.abs(x % 10);
        int unitDigitY = Math.abs(y % 10);
        int product = unitDigitX * unitDigitY;
        return product;
    }

    // Test Cases
    private static final int[][] testCases = {
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
        assertEquals(multiply(testCases[0][0], testCases[0][1]), calculateUnitDigitProduct(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(multiply(testCases[1][0], testCases[1][1]), calculateUnitDigitProduct(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(multiply(testCases[2][0], testCases[2][1]), calculateUnitDigitProduct(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(multiply(testCases[3][0], testCases[3][1]), calculateUnitDigitProduct(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(multiply(testCases[4][0], testCases[4][1]), calculateUnitDigitProduct(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(multiply(testCases[5][0], testCases[5][1]), calculateUnitDigitProduct(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(multiply(testCases[6][0], testCases[6][1]), calculateUnitDigitProduct(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(multiply(testCases[7][0], testCases[7][1]), calculateUnitDigitProduct(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(multiply(testCases[8][0], testCases[8][1]), calculateUnitDigitProduct(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(multiply(testCases[9][0], testCases[9][1]), calculateUnitDigitProduct(testCases[9][0], testCases[9][1]));
    }
}