import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_9 {

    // Source Code
    public static List<Integer> rollingMax(List<Integer> numbers) {
        Integer runningMax = null;
        List<Integer> result = new ArrayList<>();

        for (Integer n : numbers) {
            if (runningMax == null) {
                runningMax = n;
            } else {
                runningMax = Math.max(runningMax, n);
            }

            result.add(runningMax);
        }

        return result;
    }

    // Transformed Code
    public static List<Integer> computeRollingMaximum(List<Integer> values) {
        Integer currentMax = null;
        List<Integer> maxHistory = new java.util.ArrayList<>();

        int index = 0;
        while (index < values.size()) {
            if (currentMax == null || values.get(index) > currentMax) {
                currentMax = values.get(index);
            }
            maxHistory.add(currentMax);
            index++;
        }

        return maxHistory;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(), List.of()},
        {List.of(5), List.of(5)},
        {List.of(1, 2, 3, 4, 5), List.of(1, 2, 3, 4, 5)},
        {List.of(5, 4, 3, 2, 1), List.of(5, 5, 5, 5, 5)},
        {List.of(1, 5, 3, 6, 2), List.of(1, 5, 5, 6, 6)},
        {List.of(3, 3, 3, 3, 3), List.of(3, 3, 3, 3, 3)},
        {List.of(10, 9, 8, 7, 11), List.of(10, 10, 10, 10, 11)},
        {List.of(1, 2), List.of(1, 2)},
        {List.of(2, 1), List.of(2, 2)},
        {List.of(1), List.of(1)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_9.rollingMax((List<Integer>) testCases[0][0]), 
                     HumanEval_9.computeRollingMaximum((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_9.rollingMax((List<Integer>) testCases[1][0]), 
                     HumanEval_9.computeRollingMaximum((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_9.rollingMax((List<Integer>) testCases[2][0]), 
                     HumanEval_9.computeRollingMaximum((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_9.rollingMax((List<Integer>) testCases[3][0]), 
                     HumanEval_9.computeRollingMaximum((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_9.rollingMax((List<Integer>) testCases[4][0]), 
                     HumanEval_9.computeRollingMaximum((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_9.rollingMax((List<Integer>) testCases[5][0]), 
                     HumanEval_9.computeRollingMaximum((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_9.rollingMax((List<Integer>) testCases[6][0]), 
                     HumanEval_9.computeRollingMaximum((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_9.rollingMax((List<Integer>) testCases[7][0]), 
                     HumanEval_9.computeRollingMaximum((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_9.rollingMax((List<Integer>) testCases[8][0]), 
                     HumanEval_9.computeRollingMaximum((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_9.rollingMax((List<Integer>) testCases[9][0]), 
                     HumanEval_9.computeRollingMaximum((List<Integer>) testCases[9][0]));
    }
}