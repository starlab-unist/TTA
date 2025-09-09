import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_4 {

    // Source Code
    static class SourceCode {
        public static double meanAbsoluteDeviation(List<Double> numbers) {
            double mean = numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            double mad = numbers.stream().mapToDouble(x -> Math.abs(x - mean)).average().orElse(0.0);
            return mad;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static double calculateMeanAbsDev(List<Double> values) {
            double average = values.stream().mapToDouble(Double::doubleValue).sum() / values.size();
            double deviationSum = values.stream().mapToDouble(value -> Math.abs(value - average)).sum();
            return deviationSum / values.size();
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(1.0, 2.0, 3.0), 0.6666666666666666},
        {Arrays.asList(4.0, 5.0, 6.0, 7.0), 1.0},
        {Arrays.asList(10.0, 10.0, 10.0), 0.0},
        {Arrays.asList(1.0, 1.0, 2.0, 3.0, 4.0), 1.2},
        {Arrays.asList(5.5, 5.5, 5.5, 5.5), 0.0},
        {Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), 2.5},
        {Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0), 0.0},
        {Arrays.asList(1.5, 2.5, 3.5, 4.5, 5.5), 1.2},
        {Arrays.asList(100.0, 200.0, 300.0), 66.66666666666667},
        {Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5), 1.32}
    };

    @Test
    public void test_0() {
        assertEquals(SourceCode.meanAbsoluteDeviation((List<Double>) testCases[0][0]), TransformedCode.calculateMeanAbsDev((List<Double>) testCases[0][0]), 1e-9);
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.meanAbsoluteDeviation((List<Double>) testCases[1][0]), TransformedCode.calculateMeanAbsDev((List<Double>) testCases[1][0]), 1e-9);
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.meanAbsoluteDeviation((List<Double>) testCases[2][0]), TransformedCode.calculateMeanAbsDev((List<Double>) testCases[2][0]), 1e-9);
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.meanAbsoluteDeviation((List<Double>) testCases[3][0]), TransformedCode.calculateMeanAbsDev((List<Double>) testCases[3][0]), 1e-9);
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.meanAbsoluteDeviation((List<Double>) testCases[4][0]), TransformedCode.calculateMeanAbsDev((List<Double>) testCases[4][0]), 1e-9);
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.meanAbsoluteDeviation((List<Double>) testCases[5][0]), TransformedCode.calculateMeanAbsDev((List<Double>) testCases[5][0]), 1e-9);
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.meanAbsoluteDeviation((List<Double>) testCases[6][0]), TransformedCode.calculateMeanAbsDev((List<Double>) testCases[6][0]), 1e-9);
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.meanAbsoluteDeviation((List<Double>) testCases[7][0]), TransformedCode.calculateMeanAbsDev((List<Double>) testCases[7][0]), 1e-9);
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.meanAbsoluteDeviation((List<Double>) testCases[8][0]), TransformedCode.calculateMeanAbsDev((List<Double>) testCases[8][0]), 1e-9);
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.meanAbsoluteDeviation((List<Double>) testCases[9][0]), TransformedCode.calculateMeanAbsDev((List<Double>) testCases[9][0]), 1e-9);
    }
}