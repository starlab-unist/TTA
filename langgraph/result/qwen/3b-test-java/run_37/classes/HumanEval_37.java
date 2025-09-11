import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_37 {

    // Source Code
    static class HumanEval_37_Source {
        public static List<Integer> sortEven(List<Integer> l) {
            List<Integer> evens = new ArrayList<>();
            List<Integer> odds = new ArrayList<>();

            for (int i = 0; i < l.size(); i++) {
                if (i % 2 == 0) {
                    evens.add(l.get(i));
                } else {
                    odds.add(l.get(i));
                }
            }

            Collections.sort(evens);

            List<Integer> ans = new ArrayList<>();
            int i = 0;
            int j = 0;

            while (i < evens.size() && j < odds.size()) {
                ans.add(evens.get(i));
                ans.add(odds.get(j));
                i++;
                j++;
            }

            if (evens.size() > odds.size()) {
                ans.add(evens.get(evens.size() - 1));
            }

            return ans;
        }
    }

    // Transformed Code
    static class HumanEval_37_Transformed {
        public List<Integer> sortEven(List<Integer> numbers) {
            List<Integer> evenElements = new ArrayList<>();
            List<Integer> oddElements = new ArrayList<>();

            for (int i = 0; i < numbers.size(); i++) {
                if (i % 2 == 0) {
                    evenElements.add(numbers.get(i));
                } else {
                    oddElements.add(numbers.get(i));
                }
            }

            Collections.sort(evenElements);

            List<Integer> result = new ArrayList<>();
            int index = 0;

            while (index < oddElements.size()) {
                result.add(evenElements.get(index));
                result.add(oddElements.get(index));
                index++;
            }

            if (evenElements.size() > oddElements.size()) {
                result.add(evenElements.get(evenElements.size() - 1));
            }

            return result;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(2, 3, 4, 5, 6), List.of(2, 3, 4, 5, 6)},
        {List.of(10, 9, 8, 7, 6, 5), List.of(6, 9, 8, 7, 10, 5)},
        {List.of(1, 3, 5, 7, 2, 4, 6, 8), List.of(1, 3, 2, 4, 5, 7, 6, 8)},
        {List.of(1, 2), List.of(1, 2)},
        {List.of(5), List.of(5)},
        {List.of(), List.of()},
        {List.of(7, 1, 9, 3, 11, 5, 13), List.of(7, 1, 9, 3, 11, 5, 13)},
        {List.of(4, 2, 6, 8, 0, 10, 12, 14), List.of(0, 2, 4, 8, 6, 10, 12, 14)},
        {List.of(15, 14, 13, 12, 11, 10, 9), List.of(9, 14, 11, 12, 13, 10, 15)},
        {List.of(20, 19, 22, 21, 24, 23, 26, 25, 28), List.of(20, 19, 22, 21, 24, 23, 26, 25, 28)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[0][0]), 
                     new HumanEval_37_Transformed().sortEven((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[1][0]), 
                     new HumanEval_37_Transformed().sortEven((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[2][0]), 
                     new HumanEval_37_Transformed().sortEven((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[3][0]), 
                     new HumanEval_37_Transformed().sortEven((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[4][0]), 
                     new HumanEval_37_Transformed().sortEven((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[5][0]), 
                     new HumanEval_37_Transformed().sortEven((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[6][0]), 
                     new HumanEval_37_Transformed().sortEven((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[7][0]), 
                     new HumanEval_37_Transformed().sortEven((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[8][0]), 
                     new HumanEval_37_Transformed().sortEven((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[9][0]), 
                     new HumanEval_37_Transformed().sortEven((List<Integer>) testCases[9][0]));
    }
}