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

public class HumanEval_113 {

    // Source Code
    public List<String> oddCount(List<String> lst) {
        List<String> res = new ArrayList<>();
        for (String arr : lst) {
            int n = 0;
            for (char c : arr.toCharArray()) {
                if ((c - '0') % 2 == 1) {
                    n++;
                }
            }
            res.add("the number of odd elements " + n + "n the str" + n + "ng " + n + " of the " + n + "nput.");
        }
        return res;
    }

    // Transformed Code
    public List<String> countOddsInSublists(List<List<Integer>> inputList) {
        List<String> result = new ArrayList<>();
        for (List<Integer> sublist : inputList) {
            long oddCount = sublist.stream().filter(digit -> digit % 2 != 0).count();
            result.add("the number of odd elements " + oddCount + "n the str" + oddCount + "ng " + oddCount + " of the " + oddCount + "nput.");
        }
        return result;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList("12345")},
        {Arrays.asList("24680", "13579")},
        {Arrays.asList("1", "2", "3", "4", "5")},
        {new ArrayList<String>()},
        {Arrays.asList("0", "00", "000")},
        {Arrays.asList("111", "222", "333")},
        {Arrays.asList("135", "79", "2468")},
        {Arrays.asList("987654321")},
        {Arrays.asList("11", "22", "33")},
        {Arrays.asList("00000", "11111", "22222")}
    };

    @Test
    public void test_0() {
        assertEquals(oddCount((List<String>) testCases[0][0]), 
                     countOddsInSublists(convertToIntegerLists((List<String>) testCases[0][0])));
    }

    @Test
    public void test_1() {
        assertEquals(oddCount((List<String>) testCases[1][0]), 
                     countOddsInSublists(convertToIntegerLists((List<String>) testCases[1][0])));
    }

    @Test
    public void test_2() {
        assertEquals(oddCount((List<String>) testCases[2][0]), 
                     countOddsInSublists(convertToIntegerLists((List<String>) testCases[2][0])));
    }

    @Test
    public void test_3() {
        assertEquals(oddCount((List<String>) testCases[3][0]), 
                     countOddsInSublists(convertToIntegerLists((List<String>) testCases[3][0])));
    }

    @Test
    public void test_4() {
        assertEquals(oddCount((List<String>) testCases[4][0]), 
                     countOddsInSublists(convertToIntegerLists((List<String>) testCases[4][0])));
    }

    @Test
    public void test_5() {
        assertEquals(oddCount((List<String>) testCases[5][0]), 
                     countOddsInSublists(convertToIntegerLists((List<String>) testCases[5][0])));
    }

    @Test
    public void test_6() {
        assertEquals(oddCount((List<String>) testCases[6][0]), 
                     countOddsInSublists(convertToIntegerLists((List<String>) testCases[6][0])));
    }

    @Test
    public void test_7() {
        assertEquals(oddCount((List<String>) testCases[7][0]), 
                     countOddsInSublists(convertToIntegerLists((List<String>) testCases[7][0])));
    }

    @Test
    public void test_8() {
        assertEquals(oddCount((List<String>) testCases[8][0]), 
                     countOddsInSublists(convertToIntegerLists((List<String>) testCases[8][0])));
    }

    @Test
    public void test_9() {
        assertEquals(oddCount((List<String>) testCases[9][0]), 
                     countOddsInSublists(convertToIntegerLists((List<String>) testCases[9][0])));
    }

    private List<List<Integer>> convertToIntegerLists(List<String> stringList) {
        List<List<Integer>> integerLists = new ArrayList<>();
        for (String str : stringList) {
            List<Integer> sublist = new ArrayList<>();
            for (char c : str.toCharArray()) {
                sublist.add(c - '0');
            }
            integerLists.add(sublist);
        }
        return integerLists;
    }
}