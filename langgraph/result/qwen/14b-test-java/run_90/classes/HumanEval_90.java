import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_90 {

    // Source Code
    static class HumanEval_90_Source {
        public static Integer nextSmallest(List<Integer> lst) {
            Set<Integer> uniqueElements = new TreeSet<>(lst);
            if (uniqueElements.size() < 2) {
                return null;
            } else {
                return uniqueElements.stream().skip(1).findFirst().get();
            }
        }
    }

    // Transformed Code
    static class HumanEval_90_Transformed {
        public static Integer findSecondMinimum(List<Integer> numbers) {
            List<Integer> uniqueNumbers = numbers.stream()
                                                 .distinct()
                                                 .sorted()
                                                 .collect(Collectors.toList());

            if (uniqueNumbers.size() < 2) {
                return null;
            }

            return uniqueNumbers.get(1);
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(3, 1, 4, 1, 5, 9), 3},
        {Arrays.asList(10, 20, 20, 10, 30), 20},
        {Arrays.asList(1, 2, 3, 4, 5), 2},
        {Arrays.asList(5, 5, 5, 5, 5), null},
        {Arrays.asList(7), null},
        {Arrays.asList(), null},
        {Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1), 2},
        {Arrays.asList(0, -1, -2, -3, -4), -3},
        {Arrays.asList(-10, -20, -10, -30, -20), -20},
        {Arrays.asList(100, 200, 300, 100, 200, 300), 200}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_90_Source.nextSmallest((List<Integer>) testCases[0][0]), 
                     HumanEval_90_Transformed.findSecondMinimum((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_90_Source.nextSmallest((List<Integer>) testCases[1][0]), 
                     HumanEval_90_Transformed.findSecondMinimum((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_90_Source.nextSmallest((List<Integer>) testCases[2][0]), 
                     HumanEval_90_Transformed.findSecondMinimum((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_90_Source.nextSmallest((List<Integer>) testCases[3][0]), 
                     HumanEval_90_Transformed.findSecondMinimum((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_90_Source.nextSmallest((List<Integer>) testCases[4][0]), 
                     HumanEval_90_Transformed.findSecondMinimum((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_90_Source.nextSmallest((List<Integer>) testCases[5][0]), 
                     HumanEval_90_Transformed.findSecondMinimum((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_90_Source.nextSmallest((List<Integer>) testCases[6][0]), 
                     HumanEval_90_Transformed.findSecondMinimum((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_90_Source.nextSmallest((List<Integer>) testCases[7][0]), 
                     HumanEval_90_Transformed.findSecondMinimum((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_90_Source.nextSmallest((List<Integer>) testCases[8][0]), 
                     HumanEval_90_Transformed.findSecondMinimum((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_90_Source.nextSmallest((List<Integer>) testCases[9][0]), 
                     HumanEval_90_Transformed.findSecondMinimum((List<Integer>) testCases[9][0]));
    }
}