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

public class HumanEval_22 {

    // Source Code
    public static List<Integer> filterIntegers(List<Object> values) {
        List<Integer> result = new ArrayList<>();
        for (Object x : values) {
            if (x instanceof Integer) {
                result.add((Integer) x);
            }
        }
        return result;
    }

    // Transformed Code
    public static class HumanEval_22_Transformed {
        public List<Integer> extractIntegers(List<Object> data) {
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
        {Arrays.asList(1, 2, 3.5, 'a', 4), Arrays.asList(1, 2, 4)},
        {Arrays.asList("hello", 100, 200, "world"), Arrays.asList(100, 200)},
        {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5)},
        {Arrays.asList("x", "y", "z"), Arrays.asList()},
        {Arrays.asList(null, true, false, 0, 1), Arrays.asList(0, 1)},
        {Arrays.asList(), Arrays.asList()},
        {Arrays.asList(1.1, 2.2, 3.3), Arrays.asList()},
        {Arrays.asList(1, "1", 2, "2", 3, "3"), Arrays.asList(1, 2, 3)},
        {Arrays.asList(0, -1, -2, 3, 4), Arrays.asList(0, -1, -2, 3, 4)},
        {Arrays.asList("test", 123, "example", 456), Arrays.asList(123, 456)}
    };

    @Test
    public void test_0() {
        assertEquals(filterIntegers((List<Object>) testCases[0][0]), 
                     new HumanEval_22_Transformed().extractIntegers((List<Object>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(filterIntegers((List<Object>) testCases[1][0]), 
                     new HumanEval_22_Transformed().extractIntegers((List<Object>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(filterIntegers((List<Object>) testCases[2][0]), 
                     new HumanEval_22_Transformed().extractIntegers((List<Object>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(filterIntegers((List<Object>) testCases[3][0]), 
                     new HumanEval_22_Transformed().extractIntegers((List<Object>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(filterIntegers((List<Object>) testCases[4][0]), 
                     new HumanEval_22_Transformed().extractIntegers((List<Object>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(filterIntegers((List<Object>) testCases[5][0]), 
                     new HumanEval_22_Transformed().extractIntegers((List<Object>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(filterIntegers((List<Object>) testCases[6][0]), 
                     new HumanEval_22_Transformed().extractIntegers((List<Object>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(filterIntegers((List<Object>) testCases[7][0]), 
                     new HumanEval_22_Transformed().extractIntegers((List<Object>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(filterIntegers((List<Object>) testCases[8][0]), 
                     new HumanEval_22_Transformed().extractIntegers((List<Object>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(filterIntegers((List<Object>) testCases[9][0]), 
                     new HumanEval_22_Transformed().extractIntegers((List<Object>) testCases[9][0]));
    }
}