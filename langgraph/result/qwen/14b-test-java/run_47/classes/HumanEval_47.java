import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_47 {

    // Source Code
    static class HumanEval_47_Source {
        public static double median(List<Double> l) {
            Collections.sort(l);
            int size = l.size();
            if (size % 2 == 1) {
                return l.get(size / 2);
            } else {
                return (l.get(size / 2 - 1) + l.get(size / 2)) / 2.0;
            }
        }
    }

    // Transformed Code
    static class HumanEval_47_Transformed {
        public static double calculate_median(List<Double> numbers) {
            List<Double> sorted_numbers = new ArrayList<>(numbers);
            Collections.sort(sorted_numbers);
            int mid_index = sorted_numbers.size() / 2;
            
            if (sorted_numbers.size() % 2 == 1) {
                return sorted_numbers.get(mid_index);
            } else {
                return (sorted_numbers.get(mid_index - 1) + sorted_numbers.get(mid_index)) / 2.0;
            }
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(3.0, 1.0, 2.0), 2.0},
        {Arrays.asList(4.0, 1.0, 3.0, 2.0), 2.5},
        {Arrays.asList(7.0), 7.0},
        {Arrays.asList(8.0, 9.0), 8.5},
        {Arrays.asList(10.0, 2.0, 5.0, 1.0, 8.0, 9.0, 3.0), 5.0},
        {Arrays.asList(5.0, 5.0, 5.0, 5.0, 5.0), 5.0},
        {Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), 5.5},
        {Arrays.asList(100.0, 200.0, 300.0, 400.0, 500.0, 600.0, 700.0, 800.0, 900.0, 1000.0), 550.0},
        {Arrays.asList(1.5, 2.5, 3.5), 2.5},
        {Arrays.asList(-1.0, -2.0, -3.0, -4.0, -5.0), -3.0}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_47_Source.median((List<Double>) testCases[0][0]), 
                     HumanEval_47_Transformed.calculate_median((List<Double>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_47_Source.median((List<Double>) testCases[1][0]), 
                     HumanEval_47_Transformed.calculate_median((List<Double>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_47_Source.median((List<Double>) testCases[2][0]), 
                     HumanEval_47_Transformed.calculate_median((List<Double>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_47_Source.median((List<Double>) testCases[3][0]), 
                     HumanEval_47_Transformed.calculate_median((List<Double>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_47_Source.median((List<Double>) testCases[4][0]), 
                     HumanEval_47_Transformed.calculate_median((List<Double>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_47_Source.median((List<Double>) testCases[5][0]), 
                     HumanEval_47_Transformed.calculate_median((List<Double>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_47_Source.median((List<Double>) testCases[6][0]), 
                     HumanEval_47_Transformed.calculate_median((List<Double>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_47_Source.median((List<Double>) testCases[7][0]), 
                     HumanEval_47_Transformed.calculate_median((List<Double>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_47_Source.median((List<Double>) testCases[8][0]), 
                     HumanEval_47_Transformed.calculate_median((List<Double>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_47_Source.median((List<Double>) testCases[9][0]), 
                     HumanEval_47_Transformed.calculate_median((List<Double>) testCases[9][0]));
    }
}