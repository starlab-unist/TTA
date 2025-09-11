import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_26 {

    // Source Code
    static class HumanEval_26_Source {
        public List<Integer> removeDuplicates(List<Integer> numbers) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (Integer number : numbers) {
                countMap.put(number, countMap.getOrDefault(number, 0) + 1);
            }
            List<Integer> result = new ArrayList<>();
            for (Integer number : numbers) {
                if (countMap.get(number) <= 1) {
                    result.add(number);
                }
            }
            return result;
        }
    }

    // Transformed Code
    static class HumanEval_26_Transformed {
        public List<Integer> filterUniqueElements(List<Integer> numList) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (Integer num : numList) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
            
            List<Integer> uniqueNumbers = new ArrayList<>();
            for (Integer num : numList) {
                if (countMap.get(num) == 1) {
                    uniqueNumbers.add(num);
                }
            }
            
            return uniqueNumbers;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 2, 3, 4, 4, 5), Arrays.asList(1, 3, 5)},
        {Arrays.asList(10, 20, 20, 30, 30, 30, 40), Arrays.asList(10, 40)},
        {Arrays.asList(1, 1, 1, 1, 1), new ArrayList<Integer>()},
        {Arrays.asList(5, 7, 8, 9, 10), Arrays.asList(5, 7, 8, 9, 10)},
        {new ArrayList<Integer>(), new ArrayList<Integer>()},
        {Arrays.asList(123, 456, 789), Arrays.asList(123, 456, 789)},
        {Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5), new ArrayList<Integer>()},
        {Arrays.asList(0, 0, 0, 1, 1, 1, 2, 2, 3), Arrays.asList(3)},
        {Arrays.asList(7, 8, 9, 7, 8, 10), Arrays.asList(9, 10)},
        {Arrays.asList(42), Arrays.asList(42)}
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_26_Source().removeDuplicates((List<Integer>) testCases[0][0]), 
                     new HumanEval_26_Transformed().filterUniqueElements((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_26_Source().removeDuplicates((List<Integer>) testCases[1][0]), 
                     new HumanEval_26_Transformed().filterUniqueElements((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_26_Source().removeDuplicates((List<Integer>) testCases[2][0]), 
                     new HumanEval_26_Transformed().filterUniqueElements((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_26_Source().removeDuplicates((List<Integer>) testCases[3][0]), 
                     new HumanEval_26_Transformed().filterUniqueElements((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_26_Source().removeDuplicates((List<Integer>) testCases[4][0]), 
                     new HumanEval_26_Transformed().filterUniqueElements((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_26_Source().removeDuplicates((List<Integer>) testCases[5][0]), 
                     new HumanEval_26_Transformed().filterUniqueElements((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_26_Source().removeDuplicates((List<Integer>) testCases[6][0]), 
                     new HumanEval_26_Transformed().filterUniqueElements((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_26_Source().removeDuplicates((List<Integer>) testCases[7][0]), 
                     new HumanEval_26_Transformed().filterUniqueElements((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_26_Source().removeDuplicates((List<Integer>) testCases[8][0]), 
                     new HumanEval_26_Transformed().filterUniqueElements((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_26_Source().removeDuplicates((List<Integer>) testCases[9][0]), 
                     new HumanEval_26_Transformed().filterUniqueElements((List<Integer>) testCases[9][0]));
    }
}