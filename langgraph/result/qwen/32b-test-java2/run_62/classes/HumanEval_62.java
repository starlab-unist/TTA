import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_62 {

    // Source Code
    static class HumanEval_62_Source {
        public List<Integer> derivative(List<Integer> xs) {
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i < xs.size(); i++) {
                result.add(i * xs.get(i));
            }
            return result;
        }
    }

    // Transformed Code
    static class HumanEval_62_Transformed {
        public List<Integer> computeDerivative(List<Integer> coefficients) {
            List<Integer> result = new ArrayList<>();
            int index = 1;
            while (index < coefficients.size()) {
                result.add(index * coefficients.get(index));
                index++;
            }
            return result;
        }
    }

    // Test Cases
    private static final List<List<Integer>> testCases = Arrays.asList(
        Arrays.asList(3, 1, 2, 4),       // Expected output: [1, 4, 12]
        Arrays.asList(0, 5, 0, 7),       // Expected output: [5, 0, 21]
        Arrays.asList(1, 3, 5, 7, 9),    // Expected output: [3, 10, 21, 36]
        Arrays.asList(2, 0, 0, 0),       // Expected output: [0, 0, 0]
        Arrays.asList(10, 20, 30),       // Expected output: [20, 60]
        Arrays.asList(5),                // Expected output: []
        Arrays.asList(),                 // Expected output: []
        Arrays.asList(1, -1, 1, -1),     // Expected output: [-1, 2, -3]
        Arrays.asList(0, 0, 0, 0, 0),    // Expected output: [0, 0, 0, 0]
        Arrays.asList(7, 6, 5, 4, 3, 2)  // Expected output: [6, 10, 12, 12, 10]
    );

    @Test
    public void test_0() {
        assertEquals(new HumanEval_62_Source().derivative(testCases.get(0)), 
                     new HumanEval_62_Transformed().computeDerivative(testCases.get(0)));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_62_Source().derivative(testCases.get(1)), 
                     new HumanEval_62_Transformed().computeDerivative(testCases.get(1)));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_62_Source().derivative(testCases.get(2)), 
                     new HumanEval_62_Transformed().computeDerivative(testCases.get(2)));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_62_Source().derivative(testCases.get(3)), 
                     new HumanEval_62_Transformed().computeDerivative(testCases.get(3)));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_62_Source().derivative(testCases.get(4)), 
                     new HumanEval_62_Transformed().computeDerivative(testCases.get(4)));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_62_Source().derivative(testCases.get(5)), 
                     new HumanEval_62_Transformed().computeDerivative(testCases.get(5)));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_62_Source().derivative(testCases.get(6)), 
                     new HumanEval_62_Transformed().computeDerivative(testCases.get(6)));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_62_Source().derivative(testCases.get(7)), 
                     new HumanEval_62_Transformed().computeDerivative(testCases.get(7)));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_62_Source().derivative(testCases.get(8)), 
                     new HumanEval_62_Transformed().computeDerivative(testCases.get(8)));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_62_Source().derivative(testCases.get(9)), 
                     new HumanEval_62_Transformed().computeDerivative(testCases.get(9)));
    }
}