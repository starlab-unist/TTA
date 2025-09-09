import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_71 {

    // Source Code
    static class SourceCode {
        public static double triangleArea(double a, double b, double c) {
            if (a + b <= c || a + c <= b || b + c <= a) {
                return -1;
            }
            double s = (a + b + c) / 2;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            area = Math.round(area * 100.0) / 100.0;
            return area;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public double computeTriangleArea(double side1, double side2, double side3) {
            if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
                return -1;
            }
            
            double semiPerimeter = (side1 + side2 + side3) / 2;
            double computedArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
            double roundedArea = Math.round(computedArea * 100.0) / 100.0;
            
            return roundedArea;
        }
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(SourceCode.triangleArea(3, 4, 5), new TransformedCode().computeTriangleArea(3, 4, 5));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.triangleArea(10, 6, 8), new TransformedCode().computeTriangleArea(10, 6, 8));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.triangleArea(7, 10, 5), new TransformedCode().computeTriangleArea(7, 10, 5));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.triangleArea(1, 1, 2), new TransformedCode().computeTriangleArea(1, 1, 2));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.triangleArea(5, 5, 5), new TransformedCode().computeTriangleArea(5, 5, 5));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.triangleArea(0, 4, 5), new TransformedCode().computeTriangleArea(0, 4, 5));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.triangleArea(-3, 4, 5), new TransformedCode().computeTriangleArea(-3, 4, 5));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.triangleArea(6, 8, 10), new TransformedCode().computeTriangleArea(6, 8, 10));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.triangleArea(2, 2, 3.464), new TransformedCode().computeTriangleArea(2, 2, 3.464));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.triangleArea(12, 5, 13), new TransformedCode().computeTriangleArea(12, 5, 13));
    }
    
    // Additional Test Cases for more coverage

    @Test
    public void test_10() {
        assertEquals(SourceCode.triangleArea(9, 40, 41), new TransformedCode().computeTriangleArea(9, 40, 41));
    }

    @Test
    public void test_11() {
        assertEquals(SourceCode.triangleArea(5, 5, 8), new TransformedCode().computeTriangleArea(5, 5, 8));
    }

    @Test
    public void test_12() {
        assertEquals(SourceCode.triangleArea(7, 24, 25), new TransformedCode().computeTriangleArea(7, 24, 25));
    }

    @Test
    public void test_13() {
        assertEquals(SourceCode.triangleArea(8, 15, 17), new TransformedCode().computeTriangleArea(8, 15, 17));
    }

    @Test
    public void test_14() {
        assertEquals(SourceCode.triangleArea(3, 3, 3), new TransformedCode().computeTriangleArea(3, 3, 3));
    }

    // Simple value test cases

    @Test
    public void test_15() {
        assertEquals(SourceCode.triangleArea(2, 2, 2), new TransformedCode().computeTriangleArea(2, 2, 2));
    }

    @Test
    public void test_16() {
        assertEquals(SourceCode.triangleArea(3, 4, 7), new TransformedCode().computeTriangleArea(3, 4, 7)); // invalid triangle
    }

    @Test
    public void test_17() {
        assertEquals(SourceCode.triangleArea(5, 12, 13), new TransformedCode().computeTriangleArea(5, 12, 13));
    }

    @Test
    public void test_18() {
        assertEquals(SourceCode.triangleArea(6, 8, 10), new TransformedCode().computeTriangleArea(6, 8, 10));
    }

    @Test
    public void test_19() {
        assertEquals(SourceCode.triangleArea(7, 24, 25), new TransformedCode().computeTriangleArea(7, 24, 25));
    }

    @Test
    public void test_20() {
        assertEquals(SourceCode.triangleArea(8, 15, 17), new TransformedCode().computeTriangleArea(8, 15, 17));
    }
    
    // Additional Simple Value Test Cases

    @Test
    public void test_21() {
        assertEquals(SourceCode.triangleArea(1, 1, 1), new TransformedCode().computeTriangleArea(1, 1, 1));
    }

    @Test
    public void test_22() {
        assertEquals(SourceCode.triangleArea(10, 10, 10), new TransformedCode().computeTriangleArea(10, 10, 10));
    }

    @Test
    public void test_23() {
        assertEquals(SourceCode.triangleArea(5, 12, 14), new TransformedCode().computeTriangleArea(5, 12, 14)); // invalid triangle
    }

    @Test
    public void test_24() {
        assertEquals(SourceCode.triangleArea(3, 5, 7), new TransformedCode().computeTriangleArea(3, 5, 7));
    }

    @Test
    public void test_25() {
        assertEquals(SourceCode.triangleArea(0, 0, 0), new TransformedCode().computeTriangleArea(0, 0, 0)); // invalid triangle
    }
}