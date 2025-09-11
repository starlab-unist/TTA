import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_12 {

    // Source Code
    static class HumanEval_12_Source {
        public static String longest(List<String> strings) {
            if (strings == null || strings.isEmpty()) {
                return null;
            }

            int maxlen = 0;
            for (String s : strings) {
                if (s.length() > maxlen) {
                    maxlen = s.length();
                }
            }

            for (String s : strings) {
                if (s.length() == maxlen) {
                    return s;
                }
            }

            return null; // This line is technically unreachable due to the logic above
        }
    }

    // Transformed Code
    static class HumanEval_12_Transformed {
        public static String findLongestString(List<String> stringList) {
            if (stringList == null || stringList.isEmpty()) {
                return null;
            }

            int maxLength = stringList.stream().mapToInt(String::length).max().orElse(0);
            for (String element : stringList) {
                if (element.length() == maxLength) {
                    return element;
                }
            }
            return null;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList("apple", "banana", "cherry"), "banana"},
        {Arrays.asList("dog", "cat"), "dog"},
        {Arrays.asList(), null},
        {Arrays.asList("a", "ab", "abc", "abcd", "abcde", "abcd"), "abcde"},
        {Arrays.asList("same", "size", "word"), "same"},
        {Arrays.asList("one", "two", "three", "four"), "three"},
        {Arrays.asList("short", "longer", "longest", "longerer", "longererest"), "longererest"},
        {Arrays.asList("1234567890", "123", "123456789"), "1234567890"},
        {Arrays.asList("same", "same", "same"), "same"},
        {Arrays.asList("unique"), "unique"}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_12_Source.longest((List<String>) testCases[0][0]), 
                     HumanEval_12_Transformed.findLongestString((List<String>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_12_Source.longest((List<String>) testCases[1][0]), 
                     HumanEval_12_Transformed.findLongestString((List<String>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_12_Source.longest((List<String>) testCases[2][0]), 
                     HumanEval_12_Transformed.findLongestString((List<String>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_12_Source.longest((List<String>) testCases[3][0]), 
                     HumanEval_12_Transformed.findLongestString((List<String>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_12_Source.longest((List<String>) testCases[4][0]), 
                     HumanEval_12_Transformed.findLongestString((List<String>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_12_Source.longest((List<String>) testCases[5][0]), 
                     HumanEval_12_Transformed.findLongestString((List<String>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_12_Source.longest((List<String>) testCases[6][0]), 
                     HumanEval_12_Transformed.findLongestString((List<String>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_12_Source.longest((List<String>) testCases[7][0]), 
                     HumanEval_12_Transformed.findLongestString((List<String>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_12_Source.longest((List<String>) testCases[8][0]), 
                     HumanEval_12_Transformed.findLongestString((List<String>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_12_Source.longest((List<String>) testCases[9][0]), 
                     HumanEval_12_Transformed.findLongestString((List<String>) testCases[9][0]));
    }
}