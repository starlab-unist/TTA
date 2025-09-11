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
    public static List<String> oddCount(List<List<Integer>> lst) {
        List<String> result = new ArrayList<>();
        
        for (List<Integer> arr : lst) {
            int n = 0;
            for (int d : arr) {
                if (d % 2 != 0) {
                    n++;
                }
            }
            result.add("the number of odd elements " + n + " in the string " + n + " of the " + n + " input.");
        }
        
        return result;
    }

    // Transformed Code
    public static List<String> countOddsInSublists(List<List<Integer>> inputList) {
        List<String> result = new ArrayList<>();
        for (List<Integer> sublist : inputList) {
            int oddCount = 0;
            for (int digit : sublist) {
                if (digit % 2 != 0) {
                    oddCount++;
                }
            }
            result.add(String.format("the number of odd elements %d in the str%dng %d of the %dinput.", oddCount, oddCount, oddCount, oddCount));
        }
        return result;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList(Arrays.asList(1, 2, 3, 4, 5)), Arrays.asList("the number of odd elements 3 in the string 3 of the 3 input.")},
        {Arrays.asList(Arrays.asList(2, 4, 6, 8, 0), Arrays.asList(1, 3, 5, 7, 9)), Arrays.asList("the number of odd elements 0 in the string 0 of the 0 input.", "the number of odd elements 5 in the string 5 of the 5 input.")},
        {Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList(4), Arrays.asList(5)), Arrays.asList("the number of odd elements 1 in the string 1 of the 1 input.", "the number of odd elements 0 in the string 0 of the 0 input.", "the number of odd elements 1 in the string 1 of the 1 input.", "the number of odd elements 0 in the string 0 of the 0 input.", "the number of odd elements 1 in the string 1 of the 1 input.")},
        {Arrays.asList(), Arrays.asList()},
        {Arrays.asList(Arrays.asList(0), Arrays.asList(0, 0), Arrays.asList(0, 0, 0)), Arrays.asList("the number of odd elements 0 in the string 0 of the 0 input.", "the number of odd elements 0 in the string 0 of the 0 input.", "the number of odd elements 0 in the string 0 of the 0 input.")},
        {Arrays.asList(Arrays.asList(1, 1, 1), Arrays.asList(2, 2, 2), Arrays.asList(3, 3, 3)), Arrays.asList("the number of odd elements 3 in the string 3 of the 3 input.", "the number of odd elements 0 in the string 0 of the 0 input.", "the number of odd elements 3 in the string 3 of the 3 input.")},
        {Arrays.asList(Arrays.asList(1, 3, 5), Arrays.asList(7, 9), Arrays.asList(2, 4, 6, 8)), Arrays.asList("the number of odd elements 3 in the string 3 of the 3 input.", "the number of odd elements 2 in the string 2 of the 2 input.", "the number of odd elements 0 in the string 0 of the 0 input.")},
        {Arrays.asList(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1)), Arrays.asList("the number of odd elements 5 in the string 5 of the 5 input.")},
        {Arrays.asList(Arrays.asList(1, 1), Arrays.asList(2, 2), Arrays.asList(3, 3)), Arrays.asList("the number of odd elements 2 in the string 2 of the 2 input.", "the number of odd elements 0 in the string 0 of the 0 input.", "the number of odd elements 2 in the string 2 of the 2 input.")},
        {Arrays.asList(Arrays.asList(0, 0, 0, 0, 0), Arrays.asList(1, 1, 1, 1, 1), Arrays.asList(2, 2, 2, 2, 2)), Arrays.asList("the number of odd elements 0 in the string 0 of the 0 input.", "the number of odd elements 5 in the string 5 of the 5 input.", "the number of odd elements 0 in the string 0 of the 0 input.")}
    };

    @Test
    public void test_0() {
        assertEquals(oddCount((List<List<Integer>>) testCases[0][0]), countOddsInSublists((List<List<Integer>>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(oddCount((List<List<Integer>>) testCases[1][0]), countOddsInSublists((List<List<Integer>>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(oddCount((List<List<Integer>>) testCases[2][0]), countOddsInSublists((List<List<Integer>>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(oddCount((List<List<Integer>>) testCases[3][0]), countOddsInSublists((List<List<Integer>>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(oddCount((List<List<Integer>>) testCases[4][0]), countOddsInSublists((List<List<Integer>>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(oddCount((List<List<Integer>>) testCases[5][0]), countOddsInSublists((List<List<Integer>>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(oddCount((List<List<Integer>>) testCases[6][0]), countOddsInSublists((List<List<Integer>>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(oddCount((List<List<Integer>>) testCases[7][0]), countOddsInSublists((List<List<Integer>>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(oddCount((List<List<Integer>>) testCases[8][0]), countOddsInSublists((List<List<Integer>>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(oddCount((List<List<Integer>>) testCases[9][0]), countOddsInSublists((List<List<Integer>>) testCases[9][0]));
    }
}