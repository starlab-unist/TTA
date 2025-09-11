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

            evens.sort(null);

            List<Integer> ans = new ArrayList<>();
            int minSize = Math.min(evens.size(), odds.size());
            for (int i = 0; i < minSize; i++) {
                ans.add(evens.get(i));
                ans.add(odds.get(i));
            }

            if (evens.size() > odds.size()) {
                ans.add(evens.get(evens.size() - 1));
            }

            return ans;
        }
    }

    // Transformed Code
    static class HumanEval_37_Transformed {
        public static List<Integer> sortEven(List<Integer> numbers) {
            List<Integer> evens = new ArrayList<>();
            List<Integer> odds = new ArrayList<>();
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < numbers.size(); i++) {
                if (i % 2 == 0) {
                    evens.add(numbers.get(i));
                } else {
                    odds.add(numbers.get(i));
                }
            }

            evens.sort(null);

            int index = 0;
            while (index < odds.size()) {
                ans.add(evens.get(index));
                ans.add(odds.get(index));
                index++;
            }

            if (evens.size() > odds.size()) {
                ans.add(evens.get(evens.size() - 1));
            }

            return ans;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(2, 3, 4, 5, 6), Arrays.asList(2, 3, 4, 5, 6)},
        {Arrays.asList(10, 9, 8, 7, 6, 5), Arrays.asList(6, 9, 8, 7, 10, 5)},
        {Arrays.asList(1, 3, 5, 7, 2, 4, 6, 8), Arrays.asList(1, 3, 2, 4, 5, 7, 6, 8)},
        {Arrays.asList(1, 2), Arrays.asList(1, 2)},
        {Arrays.asList(5), Arrays.asList(5)},
        {new ArrayList<>(), new ArrayList<>()},
        {Arrays.asList(7, 1, 9, 3, 11, 5, 13), Arrays.asList(7, 1, 9, 3, 11, 5, 13)},
        {Arrays.asList(4, 2, 6, 8, 0, 10, 12, 14), Arrays.asList(0, 2, 4, 8, 6, 10, 12, 14)},
        {Arrays.asList(15, 14, 13, 12, 11, 10, 9), Arrays.asList(9, 14, 11, 12, 13, 10, 15)},
        {Arrays.asList(20, 19, 22, 21, 24, 23, 26, 25, 28), Arrays.asList(20, 19, 22, 21, 24, 23, 26, 25, 28)}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[0][0]), 
                     HumanEval_37_Transformed.sortEven((List<Integer>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[1][0]), 
                     HumanEval_37_Transformed.sortEven((List<Integer>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[2][0]), 
                     HumanEval_37_Transformed.sortEven((List<Integer>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[3][0]), 
                     HumanEval_37_Transformed.sortEven((List<Integer>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[4][0]), 
                     HumanEval_37_Transformed.sortEven((List<Integer>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[5][0]), 
                     HumanEval_37_Transformed.sortEven((List<Integer>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[6][0]), 
                     HumanEval_37_Transformed.sortEven((List<Integer>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[7][0]), 
                     HumanEval_37_Transformed.sortEven((List<Integer>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[8][0]), 
                     HumanEval_37_Transformed.sortEven((List<Integer>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_37_Source.sortEven((List<Integer>) testCases[9][0]), 
                     HumanEval_37_Transformed.sortEven((List<Integer>) testCases[9][0]));
    }
}