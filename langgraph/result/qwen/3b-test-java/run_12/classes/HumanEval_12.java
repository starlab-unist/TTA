import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_12 {

    // Source Code
    static class HumanEval_12_Source {
        public static Optional<String> longest(List<String> strings) {
            if (strings == null || strings.isEmpty()) {
                return Optional.empty();
            }

            int maxlen = strings.stream().mapToInt(String::length).max().orElse(-1);
            for (String s : strings) {
                if (s.length() == maxlen) {
                    return Optional.of(s);
                }
            }

            return Optional.empty();
        }
    }

    // Transformed Code
    static class HumanEval_12_Transformed {
        public static Optional<String> findLongestString(List<String> stringList) {
            if (stringList == null || stringList.isEmpty()) {
                return Optional.empty();
            }

            int maxLength = stringList.stream()
                    .mapToInt(String::length)
                    .max()
                    .orElse(0);

            for (String element : stringList) {
                if (element.length() == maxLength) {
                    return Optional.of(element);
                }
            }

            return Optional.empty();
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of("apple", "banana", "cherry"), "banana"},
        {List.of("dog", "cat"), "dog"},
        {List.of(), null},
        {List.of("a", "ab", "abc", "abcd", "abcde", "abcd"), "abcde"},
        {List.of("same", "size", "word"), "same"},
        {List.of("one", "two", "three", "four"), "three"},
        {List.of("short", "longer", "longest", "longerer", "longererest"), "longererest"},
        {List.of("1234567890", "123", "123456789"), "1234567890"},
        {List.of("same", "same", "same"), "same"},
        {List.of("unique"), "unique"}
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