import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_45 {

    // Source Code
    public static double triangleArea(double a, double h) {
        return a * h / 2.0;
    }

    // Transformed Code
    public static double calculateTriangleArea(double base, double height) {
        double area = (base * height) / 2.0;
        return area;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {10.0, 5.0},
        {7.0, 3.0},
        {0.0, 5.0},
        {5.0, 0.0},
        {0.0, 0.0},
        {2.5, 4.0},
        {100.0, 200.0},
        {1.0, 1.0},
        {3.14, 2.71},
        {12345.0, 6789.0}
    };

    @Test
    public void test_0() {
        assertEquals(triangleArea((double) testCases[0][0], (double) testCases[0][1]), 
                     calculateTriangleArea((double) testCases[0][0], (double) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(triangleArea((double) testCases[1][0], (double) testCases[1][1]), 
                     calculateTriangleArea((double) testCases[1][0], (double) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(triangleArea((double) testCases[2][0], (double) testCases[2][1]), 
                     calculateTriangleArea((double) testCases[2][0], (double) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(triangleArea((double) testCases[3][0], (double) testCases[3][1]), 
                     calculateTriangleArea((double) testCases[3][0], (double) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(triangleArea((double) testCases[4][0], (double) testCases[4][1]), 
                     calculateTriangleArea((double) testCases[4][0], (double) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(triangleArea((double) testCases[5][0], (double) testCases[5][1]), 
                     calculateTriangleArea((double) testCases[5][0], (double) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(triangleArea((double) testCases[6][0], (double) testCases[6][1]), 
                     calculateTriangleArea((double) testCases[6][0], (double) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(triangleArea((double) testCases[7][0], (double) testCases[7][1]), 
                     calculateTriangleArea((double) testCases[7][0], (double) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(triangleArea((double) testCases[8][0], (double) testCases[8][1]), 
                     calculateTriangleArea((double) testCases[8][0], (double) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(triangleArea((double) testCases[9][0], (double) testCases[9][1]), 
                     calculateTriangleArea((double) testCases[9][0], (double) testCases[9][1]));
    }
}