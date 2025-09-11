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
        public static List<Integer> derivative(List<Integer> xs) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < xs.size(); i++) {
                result.add(i * xs.get(i));
            }
            return result.subList(1, result.size());
        }
    }

    // Transformed Code
    static class HumanEval_62_Transformed {
        public static List<Integer> computeDerivative(List<Integer> coefficients) {
            List<Integer> result = new ArrayList<>();
            int index = 1;
            while (index < coefficients.size()) {
                result.add(index * coefficients.get(index));
                index += 1;
            }
            return result;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(3, 1, 2, 4), Arrays.asList(1, 4, 12)},
        {Arrays.asList(0, 5, 0, 7), Arrays.asList(5, 0, 21)},
        {Arrays.asList(1, 3, 5, 7, 9), Arrays.asList(3, 10, 21, 36)},
        {Arrays.asList(2, 0, 0, 0), Arrays.asList(0, 0, 0)},
        {Arrays.asList(10, 20, 30), Arrays.asList(20, 60)},
        {Arrays.asList(5), new ArrayList<Integer>()},
        {new ArrayList<Integer>(), new ArrayList<Integer>()},
        {Arrays.asList(1, -1, 1, -1), Arrays.asList(-1, 2, -3)},
        {Arrays.asList(0, 0, 0, 0, 0), Arrays.asList(0, 0, 0, 0)},
        {Arrays.asList(7, 6, 5, 4, 3, 2), Arrays.asList(6, 10, 12, 12, 10)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_62_Source.derivative((List<Integer>) testCases[0][0]), 
                     HumanEval_62_Transformed.computeDerivative((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_62_Source.derivative((List<Integer>) testCases[1][0]), 
                     HumanEval_62_Transformed.computeDerivative((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_62_Source.derivative((List<Integer>) testCases[2][0]), 
                     HumanEval_62_Transformed.computeDerivative((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_62_Source.derivative((List<Integer>) testCases[3][0]), 
                     HumanEval_62_Transformed.computeDerivative((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_62_Source.derivative((List<Integer>) testCases[4][0]), 
                     HumanEval_62_Transformed.computeDerivative((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_62_Source.derivative((List<Integer>) testCases[5][0]), 
                     HumanEval_62_Transformed.computeDerivative((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_62_Source.derivative((List<Integer>) testCases[6][0]), 
                     HumanEval_62_Transformed.computeDerivative((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_62_Source.derivative((List<Integer>) testCases[7][0]), 
                     HumanEval_62_Transformed.computeDerivative((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_62_Source.derivative((List<Integer>) testCases[8][0]), 
                     HumanEval_62_Transformed.computeDerivative((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_62_Source.derivative((List<Integer>) testCases[9][0]), 
                     HumanEval_62_Transformed.computeDerivative((List<Integer>) testCases[9][0]));
    }
}