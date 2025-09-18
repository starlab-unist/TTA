import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HumanEval_0 {
    // Original class with static method
    static class HumanEval_0_Source {
        public static boolean hasCloseElements(List<Double> numbers, double threshold) {
            // Implementation of the original logic
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = i + 1; j < numbers.size(); j++) {
                    if (Math.abs(numbers.get(i) - numbers.get(j)) <= threshold) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // Transformed class with instance method
    static class HumanEval_0_Transformed {
        public boolean containsNearbyElements(List<Double> numbers, double threshold) {
            // Implementation of the transformed logic
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = i + 1; j < numbers.size(); j++) {
                    if (Math.abs(numbers.get(i) - numbers.get(j)) <= threshold) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // Test cases
    private static final Object[][] testCases = {
        {List.of(1.0, 2.0, 3.0), 0.5},
        {List.of(1.0, 2.0, 3.0), 1.5},
        {List.of(1.1, 2.2, 3.3), 0.1},
        {List.of(1.1, 2.2, 3.3), 1.2},
        {List.of(0.0, 0.0, 0.0), 0.0},
        {List.of(0.0, 0.1, 0.2), 0.05},
        {List.of(5.0, 4.9, 4.8), 0.2},
        {List.of(10.0, 20.0, 30.0), 5.0},
        {List.of(1.0, 1.0, 1.0, 1.0), 0.1},
        {List.of(1.0, 2.0, 3.0, 4.0, 5.0), 1.1}
    };

    // Test method for each test case
    @Test
    public void test_0() {
        runTest(0);
    }

    @Test
    public void test_1() {
        runTest(1);
    }

    @Test
    public void test_2() {
        runTest(2);
    }

    @Test
    public void test_3() {
        runTest(3);
    }

    @Test
    public void test_4() {
        runTest(4);
    }

    @Test
    public void test_5() {
        runTest(5);
    }

    @Test
    public void test_6() {
        runTest(6);
    }

    @Test
    public void test_7() {
        runTest(7);
    }

    @Test
    public void test_8() {
        runTest(8);
    }

    @Test
    public void test_9() {
        runTest(9);
    }

    private void runTest(int index) {
        Object[] testCase = testCases[index];
        List<Double> list = (List<Double>) testCase[0];
        double threshold = (double) testCase[1];

        // Call original method (static)
        boolean originalResult = HumanEval_0_Source.hasCloseElements(list, threshold);

        // Call transformed method (instance)
        HumanEval_0_Transformed transformed = new HumanEval_0_Transformed();
        boolean transformedResult = transformed.containsNearbyElements(list, threshold);

        // Assert equality
        assertEquals(originalResult, transformedResult);
    }
}