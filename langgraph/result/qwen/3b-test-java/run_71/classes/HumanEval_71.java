import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_71 {

    // Source Code
    public static double triangleArea(double a, double b, double c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return -1;
        }
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        area = Math.round(area * 100.0) / 100.0;
        return area;
    }

    // Transformed Code
    public static double computeTriangleArea(double side1, double side2, double side3) {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            return -1;
        }

        double semiPerimeter = (side1 + side2 + side3) / 2;
        double computedArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
        double roundedArea = Math.round(computedArea * 100.0) / 100.0;

        return roundedArea;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {3, 4, 5},      // valid triangle
        {10, 6, 8},     // valid triangle
        {7, 10, 5},     // valid triangle
        {1, 1, 2},      // invalid triangle
        {5, 5, 5},      // equilateral triangle
        {0, 4, 5},      // invalid triangle with zero side
        {-3, 4, 5},     // invalid triangle with negative side
        {6, 8, 10},     // valid right triangle
        {2, 2, 3.464},  // valid isosceles triangle
        {12, 5, 13}     // valid triangle
    };

    @Test
    public void test_0() {
        assertEquals(triangleArea((double) testCases[0][0], (double) testCases[0][1], (double) testCases[0][2]), 
                     computeTriangleArea((double) testCases[0][0], (double) testCases[0][1], (double) testCases[0][2]));
    }

    @Test
    public void test_1() {
        assertEquals(triangleArea((double) testCases[1][0], (double) testCases[1][1], (double) testCases[1][2]), 
                     computeTriangleArea((double) testCases[1][0], (double) testCases[1][1], (double) testCases[1][2]));
    }

    @Test
    public void test_2() {
        assertEquals(triangleArea((double) testCases[2][0], (double) testCases[2][1], (double) testCases[2][2]), 
                     computeTriangleArea((double) testCases[2][0], (double) testCases[2][1], (double) testCases[2][2]));
    }

    @Test
    public void test_3() {
        assertEquals(triangleArea((double) testCases[3][0], (double) testCases[3][1], (double) testCases[3][2]), 
                     computeTriangleArea((double) testCases[3][0], (double) testCases[3][1], (double) testCases[3][2]));
    }

    @Test
    public void test_4() {
        assertEquals(triangleArea((double) testCases[4][0], (double) testCases[4][1], (double) testCases[4][2]), 
                     computeTriangleArea((double) testCases[4][0], (double) testCases[4][1], (double) testCases[4][2]));
    }

    @Test
    public void test_5() {
        assertEquals(triangleArea((double) testCases[5][0], (double) testCases[5][1], (double) testCases[5][2]), 
                     computeTriangleArea((double) testCases[5][0], (double) testCases[5][1], (double) testCases[5][2]));
    }

    @Test
    public void test_6() {
        assertEquals(triangleArea((double) testCases[6][0], (double) testCases[6][1], (double) testCases[6][2]), 
                     computeTriangleArea((double) testCases[6][0], (double) testCases[6][1], (double) testCases[6][2]));
    }

    @Test
    public void test_7() {
        assertEquals(triangleArea((double) testCases[7][0], (double) testCases[7][1], (double) testCases[7][2]), 
                     computeTriangleArea((double) testCases[7][0], (double) testCases[7][1], (double) testCases[7][2]));
    }

    @Test
    public void test_8() {
        assertEquals(triangleArea((double) testCases[8][0], (double) testCases[8][1], (double) testCases[8][2]), 
                     computeTriangleArea((double) testCases[8][0], (double) testCases[8][1], (double) testCases[8][2]));
    }

    @Test
    public void test_9() {
        assertEquals(triangleArea((double) testCases[9][0], (double) testCases[9][1], (double) testCases[9][2]), 
                     computeTriangleArea((double) testCases[9][0], (double) testCases[9][1], (double) testCases[9][2]));
    }
}