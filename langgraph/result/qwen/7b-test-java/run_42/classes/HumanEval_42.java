import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_42 {

    // Source Code
    static class HumanEval_42_Source {
        public static List<Integer> incrList(List<Integer> l) {
            return l.stream().map(e -> e + 1).collect(Collectors.toList());
        }
    }

    // Transformed Code
    static class HumanEval_42_Transformed {
        public static List<Integer> incrList(List<Integer> l) {
            List<Integer> result = new ArrayList<>();
            int index = 0;
            while (index < l.size()) {
                result.add(l.get(index) + 1);
                index++;
            }
            return result;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(1, 2, 3, 4, 5)},
        {Arrays.asList(-1, -2, -3, -4, -5)},
        {Arrays.asList(0, 0, 0, 0)},
        {Arrays.asList()},
        {Arrays.asList(100, 200, 300)},
        {Arrays.asList(-100, 0, 100)},
        {Arrays.asList(1)},
        {Arrays.asList(-1)},
        {Arrays.asList(0)},
        {Arrays.asList(9, 8, 7, 6, 5)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[0][0]), 
                     HumanEval_42_Transformed.incrList((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[1][0]), 
                     HumanEval_42_Transformed.incrList((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[2][0]), 
                     HumanEval_42_Transformed.incrList((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[3][0]), 
                     HumanEval_42_Transformed.incrList((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[4][0]), 
                     HumanEval_42_Transformed.incrList((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[5][0]), 
                     HumanEval_42_Transformed.incrList((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[6][0]), 
                     HumanEval_42_Transformed.incrList((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[7][0]), 
                     HumanEval_42_Transformed.incrList((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[8][0]), 
                     HumanEval_42_Transformed.incrList((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[9][0]), 
                     HumanEval_42_Transformed.incrList((List<Integer>) testCases[9][0]));
    }
}