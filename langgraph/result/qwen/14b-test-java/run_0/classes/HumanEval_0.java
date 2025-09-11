import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_0 {

    // Source Code
    static class HumanEval_0_Source {
        public static boolean hasCloseElements(List<Double> numbers, double threshold) {
            for (int idx = 0; idx < numbers.size(); idx++) {
                double elem = numbers.get(idx);
                for (int idx2 = 0; idx2 < numbers.size(); idx2++) {
                    if (idx != idx2) {
                        double elem2 = numbers.get(idx2);
                        double distance = Math.abs(elem - elem2);
                        if (distance < threshold) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    // Transformed Code
    static class HumanEval_0_Transformed {
        public boolean containsNearbyElements(List<Double> values, double limit) {
            int index = 0;
            while (index < values.size()) {
                int innerIndex = 0;
                while (innerIndex < values.size()) {
                    if (index != innerIndex) {
                        double gap = Math.abs(values.get(index) - values.get(innerIndex));
                        if (gap < limit) {
                            return true;
                        }
                    }
                    innerIndex++;
                }
                index++;
            }

            return false;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(1.0, 2.0, 3.0), 0.5, false},
        {List.of(1.0, 2.0, 3.0), 1.5, true},
        {List.of(1.1, 2.2, 3.3), 0.1, false},
        {List.of(1.1, 2.2, 3.3), 1.2, true},
        {List.of(0.0, 0.0, 0.0), 0.0, true},
        {List.of(0.0, 0.1, 0.2), 0.05, false},
        {List.of(5.0, 4.9, 4.8), 0.2, true},
        {List.of(10.0, 20.0, 30.0), 5.0, false},
        {List.of(1.0, 1.0, 1.0, 1.0), 0.1, true},
        {List.of(1.0, 2.0, 3.0, 4.0, 5.0), 1.1, true}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Double>) testCases[0][0], (double) testCases[0][1]), 
                     new HumanEval_0_Transformed().containsNearbyElements((List<Double>) testCases[0][0], (double) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Double>) testCases[1][0], (double) testCases[1][1]), 
                     new HumanEval_0_Transformed().containsNearbyElements((List<Double>) testCases[1][0], (double) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Double>) testCases[2][0], (double) testCases[2][1]), 
                     new HumanEval_0_Transformed().containsNearbyElements((List<Double>) testCases[2][0], (double) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Double>) testCases[3][0], (double) testCases[3][1]), 
                     new HumanEval_0_Transformed().containsNearbyElements((List<Double>) testCases[3][0], (double) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Double>) testCases[4][0], (double) testCases[4][1]), 
                     new HumanEval_0_Transformed().containsNearbyElements((List<Double>) testCases[4][0], (double) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Double>) testCases[5][0], (double) testCases[5][1]), 
                     new HumanEval_0_Transformed().containsNearbyElements((List<Double>) testCases[5][0], (double) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Double>) testCases[6][0], (double) testCases[6][1]), 
                     new HumanEval_0_Transformed().containsNearbyElements((List<Double>) testCases[6][0], (double) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Double>) testCases[7][0], (double) testCases[7][1]), 
                     new HumanEval_0_Transformed().containsNearbyElements((List<Double>) testCases[7][0], (double) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Double>) testCases[8][0], (double) testCases[8][1]), 
                     new HumanEval_0_Transformed().containsNearbyElements((List<Double>) testCases[8][0], (double) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Double>) testCases[9][0], (double) testCases[9][1]), 
                     new HumanEval_0_Transformed().containsNearbyElements((List<Double>) testCases[9][0], (double) testCases[9][1]));
    }
}