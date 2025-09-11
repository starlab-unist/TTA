import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_26 {

    // Source Code
    static class HumanEval_26_Source {
        public static List<Integer> removeDuplicates(List<Integer> numbers) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int number : numbers) {
                countMap.put(number, countMap.getOrDefault(number, 0) + 1);
            }
            List<Integer> result = new ArrayList<>();
            for (int number : numbers) {
                if (countMap.get(number) <= 1) {
                    result.add(number);
                }
            }
            return result;
        }
    }

    // Transformed Code
    static class HumanEval_26_Transformed {
        public static List<Integer> removeDuplicates(List<Integer> numbers) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int number : numbers) {
                countMap.put(number, countMap.getOrDefault(number, 0) + 1);
            }
            List<Integer> uniqueNumbers = new ArrayList<>();
            for (int number : numbers) {
                if (countMap.get(number) == 1) {
                    uniqueNumbers.add(number);
                }
            }
            return uniqueNumbers;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(1, 2, 2, 3, 4, 4, 5), List.of(1, 3, 5)},
        {List.of(10, 20, 20, 30, 30, 30, 40), List.of(10, 40)},
        {List.of(1, 1, 1, 1, 1), List.of()},
        {List.of(5, 7, 8, 9, 10), List.of(5, 7, 8, 9, 10)},
        {List.of(), List.of()},
        {List.of(123, 456, 789), List.of(123, 456, 789)},
        {List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5), List.of()},
        {List.of(0, 0, 0, 1, 1, 1, 2, 2, 3), List.of(3)},
        {List.of(7, 8, 9, 7, 8, 10), List.of(9, 10)},
        {List.of(42), List.of(42)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_26_Source.removeDuplicates((List<Integer>) testCases[0][0]), 
                     HumanEval_26_Transformed.removeDuplicates((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_26_Source.removeDuplicates((List<Integer>) testCases[1][0]), 
                     HumanEval_26_Transformed.removeDuplicates((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_26_Source.removeDuplicates((List<Integer>) testCases[2][0]), 
                     HumanEval_26_Transformed.removeDuplicates((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_26_Source.removeDuplicates((List<Integer>) testCases[3][0]), 
                     HumanEval_26_Transformed.removeDuplicates((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_26_Source.removeDuplicates((List<Integer>) testCases[4][0]), 
                     HumanEval_26_Transformed.removeDuplicates((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_26_Source.removeDuplicates((List<Integer>) testCases[5][0]), 
                     HumanEval_26_Transformed.removeDuplicates((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_26_Source.removeDuplicates((List<Integer>) testCases[6][0]), 
                     HumanEval_26_Transformed.removeDuplicates((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_26_Source.removeDuplicates((List<Integer>) testCases[7][0]), 
                     HumanEval_26_Transformed.removeDuplicates((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_26_Source.removeDuplicates((List<Integer>) testCases[8][0]), 
                     HumanEval_26_Transformed.removeDuplicates((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_26_Source.removeDuplicates((List<Integer>) testCases[9][0]), 
                     HumanEval_26_Transformed.removeDuplicates((List<Integer>) testCases[9][0]));
    }
}