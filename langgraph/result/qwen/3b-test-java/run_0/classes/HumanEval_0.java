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
        public static boolean hasCloseElements(List<Float> numbers, float threshold) {
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = 0; j < numbers.size(); j++) {
                    if (i != j) {
                        float distance = Math.abs(numbers.get(i) - numbers.get(j));
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
        public static boolean containsNearbyElements(List<Double> values, double limit) {
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
        {List.of(1.0f, 2.0f, 3.0f), 0.5f, false},
        {List.of(1.0f, 2.0f, 3.0f), 1.5f, true},
        {List.of(1.1f, 2.2f, 3.3f), 0.1f, false},
        {List.of(1.1f, 2.2f, 3.3f), 1.2f, true},
        {List.of(0.0f, 0.0f, 0.0f), 0.0f, true},
        {List.of(0.0f, 0.1f, 0.2f), 0.05f, false},
        {List.of(5.0f, 4.9f, 4.8f), 0.2f, true},
        {List.of(10.0f, 20.0f, 30.0f), 5.0f, false},
        {List.of(1.0f, 1.0f, 1.0f, 1.0f), 0.1f, true},
        {List.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), 1.1f, true}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Float>) testCases[0][0], (Float) testCases[0][1]),
                     HumanEval_0_Transformed.containsNearbyElements(doubleListFromFloatList((List<Float>) testCases[0][0]), (Double) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Float>) testCases[1][0], (Float) testCases[1][1]),
                     HumanEval_0_Transformed.containsNearbyElements(doubleListFromFloatList((List<Float>) testCases[1][0]), (Double) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Float>) testCases[2][0], (Float) testCases[2][1]),
                     HumanEval_0_Transformed.containsNearbyElements(doubleListFromFloatList((List<Float>) testCases[2][0]), (Double) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Float>) testCases[3][0], (Float) testCases[3][1]),
                     HumanEval_0_Transformed.containsNearbyElements(doubleListFromFloatList((List<Float>) testCases[3][0]), (Double) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Float>) testCases[4][0], (Float) testCases[4][1]),
                     HumanEval_0_Transformed.containsNearbyElements(doubleListFromFloatList((List<Float>) testCases[4][0]), (Double) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Float>) testCases[5][0], (Float) testCases[5][1]),
                     HumanEval_0_Transformed.containsNearbyElements(doubleListFromFloatList((List<Float>) testCases[5][0]), (Double) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Float>) testCases[6][0], (Float) testCases[6][1]),
                     HumanEval_0_Transformed.containsNearbyElements(doubleListFromFloatList((List<Float>) testCases[6][0]), (Double) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Float>) testCases[7][0], (Float) testCases[7][1]),
                     HumanEval_0_Transformed.containsNearbyElements(doubleListFromFloatList((List<Float>) testCases[7][0]), (Double) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Float>) testCases[8][0], (Float) testCases[8][1]),
                     HumanEval_0_Transformed.containsNearbyElements(doubleListFromFloatList((List<Float>) testCases[8][0]), (Double) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_0_Source.hasCloseElements((List<Float>) testCases[9][0], (Float) testCases[9][1]),
                     HumanEval_0_Transformed.containsNearbyElements(doubleListFromFloatList((List<Float>) testCases[9][0]), (Double) testCases[9][1]));
    }

    private List<Double> doubleListFromFloatList(List<Float> floatList) {
        return floatList.stream().map(Float::doubleValue).toList();
    }
}