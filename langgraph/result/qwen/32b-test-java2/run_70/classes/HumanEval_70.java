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

public class HumanEval_70 {

    // Source Code
    static class HumanEval_70_Source {
        public static List<Integer> strangeSortList(List<Integer> lst) {
            List<Integer> res = new ArrayList<>();
            boolean switcher = true;
            while (!lst.isEmpty()) {
                int value = switcher ? Collections.min(lst) : Collections.max(lst);
                res.add(value);
                lst.remove(Integer.valueOf(value));
                switcher = !switcher;
            }
            return res;
        }
    }

    // Transformed Code
    static class HumanEval_70_Transformed {
        public List<Integer> alternateSortSequence(List<Integer> sequence) {
            List<Integer> result = new ArrayList<>();
            boolean toggle = true;
            while (!sequence.isEmpty()) {
                int selectedValue = toggle ? Collections.min(sequence) : Collections.max(sequence);
                result.add(selectedValue);
                sequence.remove(Integer.valueOf(selectedValue));
                toggle = !toggle;
            }
            return result;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(3, 1, 2)},
        {Arrays.asList(9, 7, 5, 3, 1)},
        {Arrays.asList(10, 20, 30, 40, 50)},
        {Arrays.asList(5, 5, 5, 5)},
        {Arrays.asList(1)},
        {new ArrayList<Integer>()},
        {Arrays.asList(8, 6, 7, 5, 3, 0, 9)},
        {Arrays.asList(2, 2, 2, 1, 1, 1, 3, 3, 3)},
        {Arrays.asList(-1, -2, -3, -4, -5)},
        {Arrays.asList(100, 200, 150, 50, 250)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_70_Source.strangeSortList((List<Integer>) testCases[0][0]), 
                     new HumanEval_70_Transformed().alternateSortSequence((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_70_Source.strangeSortList((List<Integer>) testCases[1][0]), 
                     new HumanEval_70_Transformed().alternateSortSequence((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_70_Source.strangeSortList((List<Integer>) testCases[2][0]), 
                     new HumanEval_70_Transformed().alternateSortSequence((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_70_Source.strangeSortList((List<Integer>) testCases[3][0]), 
                     new HumanEval_70_Transformed().alternateSortSequence((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_70_Source.strangeSortList((List<Integer>) testCases[4][0]), 
                     new HumanEval_70_Transformed().alternateSortSequence((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_70_Source.strangeSortList((List<Integer>) testCases[5][0]), 
                     new HumanEval_70_Transformed().alternateSortSequence((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_70_Source.strangeSortList((List<Integer>) testCases[6][0]), 
                     new HumanEval_70_Transformed().alternateSortSequence((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_70_Source.strangeSortList((List<Integer>) testCases[7][0]), 
                     new HumanEval_70_Transformed().alternateSortSequence((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_70_Source.strangeSortList((List<Integer>) testCases[8][0]), 
                     new HumanEval_70_Transformed().alternateSortSequence((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_70_Source.strangeSortList((List<Integer>) testCases[9][0]), 
                     new HumanEval_70_Transformed().alternateSortSequence((List<Integer>) testCases[9][0]));
    }
}