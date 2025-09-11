import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_70 {

    // Source Code
    static class HumanEval_70_Source {
        public static ArrayList<Integer> strangeSortList(ArrayList<Integer> lst) {
            ArrayList<Integer> res = new ArrayList<>();
            boolean switchFlag = true;
            while (!lst.isEmpty()) {
                int value = switchFlag ? Collections.min(lst) : Collections.max(lst);
                res.add(value);
                lst.remove(Integer.valueOf(value));
                switchFlag = !switchFlag;
            }
            return res;
        }
    }

    // Transformed Code
    static class HumanEval_70_Transformed {
        public static ArrayList<Integer> strangeSortList(ArrayList<Integer> lst) {
            ArrayList<Integer> res = new ArrayList<>();
            boolean switchFlag = true;
            
            while (!lst.isEmpty()) {
                int selectedValue;
                if (switchFlag) {
                    selectedValue = Collections.min(lst);
                } else {
                    selectedValue = Collections.max(lst);
                }
                res.add(selectedValue);
                lst.remove(Integer.valueOf(selectedValue));
                switchFlag = !switchFlag;
            }
            
            return res;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new ArrayList<>(List.of(3, 1, 2))},
        {new ArrayList<>(List.of(9, 7, 5, 3, 1))},
        {new ArrayList<>(List.of(10, 20, 30, 40, 50))},
        {new ArrayList<>(List.of(5, 5, 5, 5))},
        {new ArrayList<>(List.of(1))},
        {new ArrayList<>()},
        {new ArrayList<>(List.of(8, 6, 7, 5, 3, 0, 9))},
        {new ArrayList<>(List.of(2, 2, 2, 1, 1, 1, 3, 3, 3))},
        {new ArrayList<>(List.of(-1, -2, -3, -4, -5))},
        {new ArrayList<>(List.of(100, 200, 150, 50, 250))}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_70_Source.strangeSortList((ArrayList<Integer>) testCases[0][0]), 
                     HumanEval_70_Transformed.strangeSortList((ArrayList<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_70_Source.strangeSortList((ArrayList<Integer>) testCases[1][0]), 
                     HumanEval_70_Transformed.strangeSortList((ArrayList<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_70_Source.strangeSortList((ArrayList<Integer>) testCases[2][0]), 
                     HumanEval_70_Transformed.strangeSortList((ArrayList<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_70_Source.strangeSortList((ArrayList<Integer>) testCases[3][0]), 
                     HumanEval_70_Transformed.strangeSortList((ArrayList<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_70_Source.strangeSortList((ArrayList<Integer>) testCases[4][0]), 
                     HumanEval_70_Transformed.strangeSortList((ArrayList<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_70_Source.strangeSortList((ArrayList<Integer>) testCases[5][0]), 
                     HumanEval_70_Transformed.strangeSortList((ArrayList<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_70_Source.strangeSortList((ArrayList<Integer>) testCases[6][0]), 
                     HumanEval_70_Transformed.strangeSortList((ArrayList<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_70_Source.strangeSortList((ArrayList<Integer>) testCases[7][0]), 
                     HumanEval_70_Transformed.strangeSortList((ArrayList<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_70_Source.strangeSortList((ArrayList<Integer>) testCases[8][0]), 
                     HumanEval_70_Transformed.strangeSortList((ArrayList<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_70_Source.strangeSortList((ArrayList<Integer>) testCases[9][0]), 
                     HumanEval_70_Transformed.strangeSortList((ArrayList<Integer>) testCases[9][0]));
    }
}