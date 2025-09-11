import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_21 {

    // Source Code
    static class HumanEval_21_Source {
        public static List<Double> rescaleToUnit(List<Double> numbers) {
            double minNumber = Double.MAX_VALUE;
            double maxNumber = Double.MIN_VALUE;

            for (double number : numbers) {
                if (number < minNumber) {
                    minNumber = number;
                }
                if (number > maxNumber) {
                    maxNumber = number;
                }
            }

            List<Double> rescaledNumbers = new ArrayList<>();
            for (double x : numbers) {
                rescaledNumbers.add((x - minNumber) / (maxNumber - minNumber));
            }

            return rescaledNumbers;
        }
    }

    // Transformed Code
    static class HumanEval_21_Transformed {
        public static List<Double> normalizeValues(List<Double> values) {
            double smallestValue = Double.MAX_VALUE;
            double largestValue = Double.MIN_VALUE;

            for (double value : values) {
                if (value < smallestValue) {
                    smallestValue = value;
                }
                if (value > largestValue) {
                    largestValue = value;
                }
            }

            double rangeValue = largestValue - smallestValue;
            List<Double> normalizedList = new ArrayList<>();

            for (double value : values) {
                double normalizedValue = (value - smallestValue) / rangeValue;
                normalizedList.add(normalizedValue);
            }

            return normalizedList;
        }
    }

    // Test Cases
    private static final Object[] testCases = {
        List.of(1.0, 2.0, 3.0, 4.0, 5.0),
        List.of(10.0, 20.0, 30.0, 40.0, 50.0),
        List.of(5.0, 5.0, 5.0, 5.0),
        List.of(-1.0, -2.0, -3.0, -4.0, -5.0),
        List.of(0.0, 100.0),
        List.of(3.14, 2.71, 1.618, 0.577),
        List.of(100.0, 200.0, 300.0, 400.0, 500.0),
        List.of(1.0, 1.0, 2.0, 2.0, 3.0, 3.0),
        List.of(-5.0, 0.0, 5.0),
        List.of(1000.0)
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_21_Source.rescaleToUnit((List<Double>) testCases[0]), 
                     HumanEval_21_Transformed.normalizeValues((List<Double>) testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_21_Source.rescaleToUnit((List<Double>) testCases[1]), 
                     HumanEval_21_Transformed.normalizeValues((List<Double>) testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_21_Source.rescaleToUnit((List<Double>) testCases[2]), 
                     HumanEval_21_Transformed.normalizeValues((List<Double>) testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_21_Source.rescaleToUnit((List<Double>) testCases[3]), 
                     HumanEval_21_Transformed.normalizeValues((List<Double>) testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_21_Source.rescaleToUnit((List<Double>) testCases[4]), 
                     HumanEval_21_Transformed.normalizeValues((List<Double>) testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_21_Source.rescaleToUnit((List<Double>) testCases[5]), 
                     HumanEval_21_Transformed.normalizeValues((List<Double>) testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_21_Source.rescaleToUnit((List<Double>) testCases[6]), 
                     HumanEval_21_Transformed.normalizeValues((List<Double>) testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_21_Source.rescaleToUnit((List<Double>) testCases[7]), 
                     HumanEval_21_Transformed.normalizeValues((List<Double>) testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_21_Source.rescaleToUnit((List<Double>) testCases[8]), 
                     HumanEval_21_Transformed.normalizeValues((List<Double>) testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_21_Source.rescaleToUnit((List<Double>) testCases[9]), 
                     HumanEval_21_Transformed.normalizeValues((List<Double>) testCases[9]));
    }
}