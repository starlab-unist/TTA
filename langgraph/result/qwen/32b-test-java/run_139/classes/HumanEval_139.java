import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_139 {

    // Source Code
    public long specialFactorial(int n) {
        long factI = 1;
        long specialFact = 1;
        for (int i = 1; i <= n; i++) {
            factI *= i;
            specialFact *= factI;
        }
        return specialFact;
    }

    // Transformed Code
    public long computeSpecialProduct(int n) {
        long currentFactorial = 1;
        long cumulativeProduct = 1;
        int index = 1;

        while (index <= n) {
            currentFactorial *= index;
            cumulativeProduct *= currentFactorial;
            index++;
        }

        return cumulativeProduct;
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(specialFactorial(0), computeSpecialProduct(0));
    }
    
    @Test
    public void test_1() {
        assertEquals(specialFactorial(1), computeSpecialProduct(1));
    }
    
    @Test
    public void test_2() {
        assertEquals(specialFactorial(2), computeSpecialProduct(2));
    }
    
    @Test
    public void test_3() {
        assertEquals(specialFactorial(3), computeSpecialProduct(3));
    }
    
    @Test
    public void test_4() {
        assertEquals(specialFactorial(4), computeSpecialProduct(4));
    }
    
    @Test
    public void test_5() {
        assertEquals(specialFactorial(5), computeSpecialProduct(5));
    }
    
    @Test
    public void test_6() {
        assertEquals(specialFactorial(6), computeSpecialProduct(6));
    }
    
    @Test
    public void test_7() {
        assertEquals(specialFactorial(10), computeSpecialProduct(10));
    }
    
    @Test
    public void test_8() {
        assertEquals(specialFactorial(20), computeSpecialProduct(20));
    }
    
    @Test
    public void test_9() {
        assertEquals(specialFactorial(100), computeSpecialProduct(100));
    }
}