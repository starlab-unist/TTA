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

public class HumanEval_70 {

    // Source Code
    public static List<Integer> strangeSortList(List<Integer> lst) {
        List<Integer> res = new ArrayList<>();
        boolean switchFlag = true;
        
        while (!lst.isEmpty()) {
            int value = switchFlag ? Collections.min(lst) : Collections.max(lst);
            res.add(value);
            lst.remove(Integer.valueOf(value));
            switchFlag = !switchFlag;
        }
        
        return res;
    }

    // Transformed Code
    public static List<Integer> alternateSortSequence(List<Integer> sequence) {
        List<Integer> result = new ArrayList<>();
        boolean toggle = true;
        
        while (!sequence.isEmpty()) {
            int selectedValue;
            if (toggle) {
                selectedValue = Collections.min(sequence);
            } else {
                selectedValue = Collections.max(sequence);
            }
            
            result.add(selectedValue);
            sequence.remove(Integer.valueOf(selectedValue));
            toggle = !toggle;
        }
        
        return result;
    }

    // Test Cases
    private static final List<Integer>[][] testCases = new List[][] {
        {List.of(3, 1, 2)},
        {List.of(9, 7, 5, 3, 1)},
        {List.of(10, 20, 30, 40, 50)},
        {List.of(5, 5, 5, 5)},
        {List.of(1)},
        {List.of()},
        {List.of(8, 6, 7, 5, 3, 0, 9)},
        {List.of(2, 2, 2, 1, 1, 1, 3, 3, 3)},
        {List.of(-1, -2, -3, -4, -5)},
        {List.of(100, 200, 150, 50, 250)}
    };

    @Test
    public void test_0() {
        assertEquals(strangeSortList(testCases[0][0]), alternateSortSequence(new ArrayList<>(testCases[0][0])));
    }

    @Test
    public void test_1() {
        assertEquals(strangeSortList(testCases[1][0]), alternateSortSequence(new ArrayList<>(testCases[1][0])));
    }

    @Test
    public void test_2() {
        assertEquals(strangeSortList(testCases[2][0]), alternateSortSequence(new ArrayList<>(testCases[2][0])));
    }

    @Test
    public void test_3() {
        assertEquals(strangeSortList(testCases[3][0]), alternateSortSequence(new ArrayList<>(testCases[3][0])));
    }

    @Test
    public void test_4() {
        assertEquals(strangeSortList(testCases[4][0]), alternateSortSequence(new ArrayList<>(testCases[4][0])));
    }

    @Test
    public void test_5() {
        assertEquals(strangeSortList(testCases[5][0]), alternateSortSequence(new ArrayList<>(testCases[5][0])));
    }

    @Test
    public void test_6() {
        assertEquals(strangeSortList(testCases[6][0]), alternateSortSequence(new ArrayList<>(testCases[6][0])));
    }

    @Test
    public void test_7() {
        assertEquals(strangeSortList(testCases[7][0]), alternateSortSequence(new ArrayList<>(testCases[7][0])));
    }

    @Test
    public void test_8() {
        assertEquals(strangeSortList(testCases[8][0]), alternateSortSequence(new ArrayList<>(testCases[8][0])));
    }

    @Test
    public void test_9() {
        assertEquals(strangeSortList(testCases[9][0]), alternateSortSequence(new ArrayList<>(testCases[9][0])));
    }
}