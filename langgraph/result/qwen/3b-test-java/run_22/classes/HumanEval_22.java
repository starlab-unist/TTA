import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_22 {

    // Source Code
    static class HumanEval_22_Source {
        public static List<Integer> filterIntegers(List<Object> values) {
            List<Integer> integers = new ArrayList<>();
            for (Object value : values) {
                if (value instanceof Integer) {
                    integers.add((Integer) value);
                }
            }
            return integers;
        }
    }

    // Transformed Code
    static class HumanEval_22_Transformed {
        public static List<Integer> extractIntegers(List<Object> data) {
            List<Integer> result = new ArrayList<>();
            for (Object item : data) {
                if (item instanceof Integer) {
                    result.add((Integer) item);
                }
            }
            return result;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(1, 2, 3.5, "a", 4)},
        {List.of("hello", 100, 200, "world")},
        {List.of(1, 2, 3, 4, 5)},
        {List.of("x", "y", "z")},
        {List.of(null, true, false, 0, 1)},
        {List.of()},
        {List.of(1.1, 2.2, 3.3)},
        {List.of(1, "1", 2, "2", 3, "3")},
        {List.of(0, -1, -2, 3, 4)},
        {List.of("test", 123, "example", 456)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_22_Source.filterIntegers((List<Object>) testCases[0][0]), 
                     HumanEval_22_Transformed.extractIntegers((List<Object>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_22_Source.filterIntegers((List<Object>) testCases[1][0]), 
                     HumanEval_22_Transformed.extractIntegers((List<Object>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_22_Source.filterIntegers((List<Object>) testCases[2][0]), 
                     HumanEval_22_Transformed.extractIntegers((List<Object>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_22_Source.filterIntegers((List<Object>) testCases[3][0]), 
                     HumanEval_22_Transformed.extractIntegers((List<Object>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_22_Source.filterIntegers((List<Object>) testCases[4][0]), 
                     HumanEval_22_Transformed.extractIntegers((List<Object>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_22_Source.filterIntegers((List<Object>) testCases[5][0]), 
                     HumanEval_22_Transformed.extractIntegers((List<Object>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_22_Source.filterIntegers((List<Object>) testCases[6][0]), 
                     HumanEval_22_Transformed.extractIntegers((List<Object>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_22_Source.filterIntegers((List<Object>) testCases[7][0]), 
                     HumanEval_22_Transformed.extractIntegers((List<Object>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_22_Source.filterIntegers((List<Object>) testCases[8][0]), 
                     HumanEval_22_Transformed.extractIntegers((List<Object>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_22_Source.filterIntegers((List<Object>) testCases[9][0]), 
                     HumanEval_22_Transformed.extractIntegers((List<Object>) testCases[9][0]));
    }
}