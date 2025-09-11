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
    public double computeTriangleArea(double side1, double side2, double side3) {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            return -1;
        }
        
        double semiPerimeter = (side1 + side2 + side3) / 2;
        double computedArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
        double roundedArea = Math.round(computedArea * 100.0) / 100.0;
        
        return roundedArea;
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(triangleArea(3, 4, 5), new HumanEval_71().computeTriangleArea(3, 4, 5));
    }
    
    @Test
    public void test_1() {
        assertEquals(triangleArea(10, 6, 8), new HumanEval_71().computeTriangleArea(10, 6, 8));
    }
    
    @Test
    public void test_2() {
        assertEquals(triangleArea(7, 10, 5), new HumanEval_71().computeTriangleArea(7, 10, 5));
    }
    
    @Test
    public void test_3() {
        assertEquals(triangleArea(1, 1, 2), new HumanEval_71().computeTriangleArea(1, 1, 2));
    }
    
    @Test
    public void test_4() {
        assertEquals(triangleArea(5, 5, 5), new HumanEval_71().computeTriangleArea(5, 5, 5));
    }
    
    @Test
    public void test_5() {
        assertEquals(triangleArea(0, 4, 5), new HumanEval_71().computeTriangleArea(0, 4, 5));
    }
    
    @Test
    public void test_6() {
        assertEquals(triangleArea(-3, 4, 5), new HumanEval_71().computeTriangleArea(-3, 4, 5));
    }
    
    @Test
    public void test_7() {
        assertEquals(triangleArea(6, 8, 10), new HumanEval_71().computeTriangleArea(6, 8, 10));
    }
    
    @Test
    public void test_8() {
        assertEquals(triangleArea(2, 2, 3.464), new HumanEval_71().computeTriangleArea(2, 2, 3.464));
    }
    
    @Test
    public void test_9() {
        assertEquals(triangleArea(12, 5, 13), new HumanEval_71().computeTriangleArea(12, 5, 13));
    }
}