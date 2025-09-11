import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_133 {

    // Source Code
    static class HumanEval_133_Source {
        public static int sumSquares(double[] lst) {
            int squared = 0;
            for (double i : lst) {
                squared += Math.pow(Math.ceil(i), 2);
            }
            return squared;
        }
    }

    // Transformed Code
    static class HumanEval_133_Transformed {
        public static int calculateTotalSquaredCeilings(List<Double> numbers) {
            int total = 0;
            Iterator<Double> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                double number = iterator.next();
                total += Math.pow(Math.ceil(number), 2);
            }
            return total;
        }
    }

    // Test Cases
    private static final List<Double>[] testCases = new List[]{
        Arrays.asList(1.0, 2.0, 3.0),
        Arrays.asList(-1.5, 2.3, -3.7),
        Arrays.asList(0.0, 0.0, 0.0),
        Arrays.asList(4.9, 5.1, 6.5),
        Arrays.asList(10.0, -10.0, 20.0),
        Arrays.asList(1.1, 1.9, 2.5),
        Arrays.asList(-1.0, -2.0, -3.0),
        Arrays.asList(),
        Arrays.asList(0.99, 1.01, 2.99),
        Arrays.asList(5.0)
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_133_Source.sumSquares(testCases[0].stream().mapToDouble(Double::doubleValue).toArray()), 
                     HumanEval_133_Transformed.calculateTotalSquaredCeilings(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_133_Source.sumSquares(testCases[1].stream().mapToDouble(Double::doubleValue).toArray()), 
                     HumanEval_133_Transformed.calculateTotalSquaredCeilings(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_133_Source.sumSquares(testCases[2].stream().mapToDouble(Double::doubleValue).toArray()), 
                     HumanEval_133_Transformed.calculateTotalSquaredCeilings(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_133_Source.sumSquares(testCases[3].stream().mapToDouble(Double::doubleValue).toArray()), 
                     HumanEval_133_Transformed.calculateTotalSquaredCeilings(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_133_Source.sumSquares(testCases[4].stream().mapToDouble(Double::doubleValue).toArray()), 
                     HumanEval_133_Transformed.calculateTotalSquaredCeilings(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_133_Source.sumSquares(testCases[5].stream().mapToDouble(Double::doubleValue).toArray()), 
                     HumanEval_133_Transformed.calculateTotalSquaredCeilings(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_133_Source.sumSquares(testCases[6].stream().mapToDouble(Double::doubleValue).toArray()), 
                     HumanEval_133_Transformed.calculateTotalSquaredCeilings(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_133_Source.sumSquares(testCases[7].stream().mapToDouble(Double::doubleValue).toArray()), 
                     HumanEval_133_Transformed.calculateTotalSquaredCeilings(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_133_Source.sumSquares(testCases[8].stream().mapToDouble(Double::doubleValue).toArray()), 
                     HumanEval_133_Transformed.calculateTotalSquaredCeilings(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_133_Source.sumSquares(testCases[9].stream().mapToDouble(Double::doubleValue).toArray()), 
                     HumanEval_133_Transformed.calculateTotalSquaredCeilings(testCases[9]));
    }
}