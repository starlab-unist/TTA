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

public class HumanEval_7 {

    // Source Code
    public static List<String> filterBySubstring(List<String> strings, String substring) {
        List<String> filteredList = new ArrayList<>();
        for (String x : strings) {
            if (x.contains(substring)) {
                filteredList.add(x);
            }
        }
        return filteredList;
    }

    // Transformed Code
    public static List<String> extractMatchingStrings(List<String> sequence, String pattern) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < sequence.size()) {
            if (sequence.get(index).contains(pattern)) {
                result.add(sequence.get(index));
            }
            index++;
        }
        return result;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList("hello", "world", "help"), "he"},
        {Arrays.asList("apple", "banana", "cherry"), "a"},
        {Arrays.asList("one", "two", "three"), "four"},
        {new ArrayList<>(), "test"},
        {Arrays.asList("abc", "def", "ghi"), ""},
        {Arrays.asList("123", "456", "789"), "5"},
        {Arrays.asList("repeat", "repeal", "replace"), "rep"},
        {Arrays.asList("same", "same", "same"), "s"},
        {Arrays.asList("unique"), "uni"},
        {Arrays.asList("different", "words", "here"), "word"}
    };

    @Test
    public void test_0() {
        assertEquals(filterBySubstring((List<String>) testCases[0][0], (String) testCases[0][1]), 
                     extractMatchingStrings((List<String>) testCases[0][0], (String) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(filterBySubstring((List<String>) testCases[1][0], (String) testCases[1][1]), 
                     extractMatchingStrings((List<String>) testCases[1][0], (String) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(filterBySubstring((List<String>) testCases[2][0], (String) testCases[2][1]), 
                     extractMatchingStrings((List<String>) testCases[2][0], (String) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(filterBySubstring((List<String>) testCases[3][0], (String) testCases[3][1]), 
                     extractMatchingStrings((List<String>) testCases[3][0], (String) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(filterBySubstring((List<String>) testCases[4][0], (String) testCases[4][1]), 
                     extractMatchingStrings((List<String>) testCases[4][0], (String) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(filterBySubstring((List<String>) testCases[5][0], (String) testCases[5][1]), 
                     extractMatchingStrings((List<String>) testCases[5][0], (String) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(filterBySubstring((List<String>) testCases[6][0], (String) testCases[6][1]), 
                     extractMatchingStrings((List<String>) testCases[6][0], (String) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(filterBySubstring((List<String>) testCases[7][0], (String) testCases[7][1]), 
                     extractMatchingStrings((List<String>) testCases[7][0], (String) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(filterBySubstring((List<String>) testCases[8][0], (String) testCases[8][1]), 
                     extractMatchingStrings((List<String>) testCases[8][0], (String) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(filterBySubstring((List<String>) testCases[9][0], (String) testCases[9][1]), 
                     extractMatchingStrings((List<String>) testCases[9][0], (String) testCases[9][1]));
    }
}