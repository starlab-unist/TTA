import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_4 {

    // Source Code
    static class HumanEval_4_Source {
        public static double meanAbsoluteDeviation(List<Double> numbers) {
            double mean = 0.0;
            for (double number : numbers) {
                mean += number;
            }
            mean /= numbers.size();

            double sumOfAbsoluteDifferences = 0.0;
            for (double number : numbers) {
                sumOfAbsoluteDifferences += Math.abs(number - mean);
            }
            return sumOfAbsoluteDifferences / numbers.size();
        }
    }

    // Transformed Code
    static class HumanEval_4_Transformed {
        public static double calculateMeanAbsoluteDev(List<Double> values) {
            double average = 0.0;
            double deviationSum = 0.0;
            int counts = values.size();

            for (double value : values) {
                average += value;
            }
            average /= counts;

            for (double value : values) {
                deviationSum += Math.abs(value - average);
            }

            return deviationSum / counts;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(1.0, 2.0, 3.0), 0.6666666666666666},
        {List.of(4.0, 5.0, 6.0, 7.0), 1.0},
        {List.of(10.0, 10.0, 10.0), 0.0},
        {List.of(1.0, 1.0, 2.0, 3.0, 4.0), 1.2},
        {List.of(5.5, 5.5, 5.5, 5.5), 0.0},
        {List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), 2.5},
        {List.of(0.0, 0.0, 0.0, 0.0, 0.0), 0.0},
        {List.of(1.5, 2.5, 3.5, 4.5, 5.5), 1.2},
        {List.of(100.0, 200.0, 300.0), 66.66666666666667},
        {List.of(1.1, 2.2, 3.3, 4.4, 5.5), 1.32}
    };

    @Test
    public void test_0() {
        assertEquals(((Double) testCases[0][1]).doubleValue(), HumanEval_4_Source.meanAbsoluteDeviation((List<Double>) testCases[0][0]), 1e-9);
        assertEquals(((Double) testCases[0][1]).doubleValue(), HumanEval_4_Transformed.calculateMeanAbsoluteDev((List<Double>) testCases[0][0]), 1e-9);
    }

    @Test
    public void test_1() {
        assertEquals(((Double) testCases[1][1]).doubleValue(), HumanEval_4_Source.meanAbsoluteDeviation((List<Double>) testCases[1][0]), 1e-9);
        assertEquals(((Double) testCases[1][1]).doubleValue(), HumanEval_4_Transformed.calculateMeanAbsoluteDev((List<Double>) testCases[1][0]), 1e-9);
    }

    @Test
    public void test_2() {
        assertEquals(((Double) testCases[2][1]).doubleValue(), HumanEval_4_Source.meanAbsoluteDeviation((List<Double>) testCases[2][0]), 1e-9);
        assertEquals(((Double) testCases[2][1]).doubleValue(), HumanEval_4_Transformed.calculateMeanAbsoluteDev((List<Double>) testCases[2][0]), 1e-9);
    }

    @Test
    public void test_3() {
        assertEquals(((Double) testCases[3][1]).doubleValue(), HumanEval_4_Source.meanAbsoluteDeviation((List<Double>) testCases[3][0]), 1e-9);
        assertEquals(((Double) testCases[3][1]).doubleValue(), HumanEval_4_Transformed.calculateMeanAbsoluteDev((List<Double>) testCases[3][0]), 1e-9);
    }

    @Test
    public void test_4() {
        assertEquals(((Double) testCases[4][1]).doubleValue(), HumanEval_4_Source.meanAbsoluteDeviation((List<Double>) testCases[4][0]), 1e-9);
        assertEquals(((Double) testCases[4][1]).doubleValue(), HumanEval_4_Transformed.calculateMeanAbsoluteDev((List<Double>) testCases[4][0]), 1e-9);
    }

    @Test
    public void test_5() {
        assertEquals(((Double) testCases[5][1]).doubleValue(), HumanEval_4_Source.meanAbsoluteDeviation((List<Double>) testCases[5][0]), 1e-9);
        assertEquals(((Double) testCases[5][1]).doubleValue(), HumanEval_4_Transformed.calculateMeanAbsoluteDev((List<Double>) testCases[5][0]), 1e-9);
    }

    @Test
    public void test_6() {
        assertEquals(((Double) testCases[6][1]).doubleValue(), HumanEval_4_Source.meanAbsoluteDeviation((List<Double>) testCases[6][0]), 1e-9);
        assertEquals(((Double) testCases[6][1]).doubleValue(), HumanEval_4_Transformed.calculateMeanAbsoluteDev((List<Double>) testCases[6][0]), 1e-9);
    }

    @Test
    public void test_7() {
        assertEquals(((Double) testCases[7][1]).doubleValue(), HumanEval_4_Source.meanAbsoluteDeviation((List<Double>) testCases[7][0]), 1e-9);
        assertEquals(((Double) testCases[7][1]).doubleValue(), HumanEval_4_Transformed.calculateMeanAbsoluteDev((List<Double>) testCases[7][0]), 1e-9);
    }

    @Test
    public void test_8() {
        assertEquals(((Double) testCases[8][1]).doubleValue(), HumanEval_4_Source.meanAbsoluteDeviation((List<Double>) testCases[8][0]), 1e-9);
        assertEquals(((Double) testCases[8][1]).doubleValue(), HumanEval_4_Transformed.calculateMeanAbsoluteDev((List<Double>) testCases[8][0]), 1e-9);
    }

    @Test
    public void test_9() {
        assertEquals(((Double) testCases[9][1]).doubleValue(), HumanEval_4_Source.meanAbsoluteDeviation((List<Double>) testCases[9][0]), 1e-9);
        assertEquals(((Double) testCases[9][1]).doubleValue(), HumanEval_4_Transformed.calculateMeanAbsoluteDev((List<Double>) testCases[9][0]), 1e-9);
    }
}