import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_47 {

    // Source Code
    static class SourceCode {
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
    static class TransformedCode {
        public double calculateMedian(List<Double> numbers) {
            List<Double> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            int midIndex = sortedNumbers.size() / 2;

            if (sortedNumbers.size() % 2 == 1) {
                return sortedNumbers.get(midIndex);
            } else {
                return (sortedNumbers.get(midIndex - 1) + sortedNumbers.get(midIndex)) / 2.0;
            }
        }
    }

    // Test Cases
    private static final List<Object[]> testCases = Arrays.asList(
        new Object[]{Arrays.asList(3.0, 1.0, 2.0), 2.0},
        new Object[]{Arrays.asList(4.0, 1.0, 3.0, 2.0), 2.5},
        new Object[]{Arrays.asList(7.0), 7.0},
        new Object[]{Arrays.asList(8.0, 9.0), 8.5},
        new Object[]{Arrays.asList(10.0, 2.0, 5.0, 1.0, 8.0, 9.0, 3.0), 5.0},
        new Object[]{Arrays.asList(5.0, 5.0, 5.0, 5.0, 5.0), 5.0},
        new Object[]{Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), 5.5},
        new Object[]{Arrays.asList(100.0, 200.0, 300.0, 400.0, 500.0, 600.0, 700.0, 800.0, 900.0, 1000.0), 550.0},
        new Object[]{Arrays.asList(1.5, 2.5, 3.5), 2.5},
        new Object[]{Arrays.asList(-1.0, -2.0, -3.0, -4.0, -5.0), -3.0}
    );

    @Test
    public void test_0() {
        assertMedianEquals(testCases.get(0));
    }

    @Test
    public void test_1() {
        assertMedianEquals(testCases.get(1));
    }

    @Test
    public void test_2() {
        assertMedianEquals(testCases.get(2));
    }

    @Test
    public void test_3() {
        assertMedianEquals(testCases.get(3));
    }

    @Test
    public void test_4() {
        assertMedianEquals(testCases.get(4));
    }

    @Test
    public void test_5() {
        assertMedianEquals(testCases.get(5));
    }

    @Test
    public void test_6() {
        assertMedianEquals(testCases.get(6));
    }

    @Test
    public void test_7() {
        assertMedianEquals(testCases.get(7));
    }

    @Test
    public void test_8() {
        assertMedianEquals(testCases.get(8));
    }

    @Test
    public void test_9() {
        assertMedianEquals(testCases.get(9));
    }

    private void assertMedianEquals(Object[] testCase) {
        List<Double> input = (List<Double>) testCase[0];
        double expected = (double) testCase[1];
        assertEquals(SourceCode.median(input), ((TransformedCode) new TransformedCode()).calculateMedian(input), 0.001);
    }
}