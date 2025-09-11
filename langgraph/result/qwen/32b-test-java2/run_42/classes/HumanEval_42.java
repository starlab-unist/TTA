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

public class HumanEval_42 {

    // Source Code
    static class HumanEval_42_Source {
        public static List<Integer> incrList(List<Integer> l) {
            List<Integer> result = new ArrayList<>();
            for (Integer e : l) {
                result.add(e + 1);
            }
            return result;
        }
    }

    // Transformed Code
    static class HumanEval_42_Transformed {
        public List<Integer> incrementElements(List<Integer> inputList) {
            List<Integer> result = new ArrayList<>();
            int index = 0;
            while (index < inputList.size()) {
                result.add(inputList.get(index) + 1);
                index++;
            }
            return result;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(1, 2, 3, 4, 5)},
        {List.of(-1, -2, -3, -4, -5)},
        {List.of(0, 0, 0, 0)},
        {List.of()},
        {List.of(100, 200, 300)},
        {List.of(-100, 0, 100)},
        {List.of(1)},
        {List.of(-1)},
        {List.of(0)},
        {List.of(9, 8, 7, 6, 5)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[0][0]), 
                     new HumanEval_42_Transformed().incrementElements((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[1][0]), 
                     new HumanEval_42_Transformed().incrementElements((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[2][0]), 
                     new HumanEval_42_Transformed().incrementElements((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[3][0]), 
                     new HumanEval_42_Transformed().incrementElements((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[4][0]), 
                     new HumanEval_42_Transformed().incrementElements((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[5][0]), 
                     new HumanEval_42_Transformed().incrementElements((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[6][0]), 
                     new HumanEval_42_Transformed().incrementElements((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[7][0]), 
                     new HumanEval_42_Transformed().incrementElements((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[8][0]), 
                     new HumanEval_42_Transformed().incrementElements((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_42_Source.incrList((List<Integer>) testCases[9][0]), 
                     new HumanEval_42_Transformed().incrementElements((List<Integer>) testCases[9][0]));
    }
}