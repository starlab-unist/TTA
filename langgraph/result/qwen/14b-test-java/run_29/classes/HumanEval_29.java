import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_29 {

    // Source Code
    public static List<String> filterByPrefix(List<String> strings, String prefix) {
        List<String> result = new ArrayList<>();
        for (String x : strings) {
            if (x.startsWith(prefix)) {
                result.add(x);
            }
        }
        return result;
    }

    // Transformed Code
    public static List<String> selectStringsWithStartingChars(List<String> wordList, String startSequence) {
        List<String> filteredWords = new ArrayList<>();
        for (String word : wordList) {
            if (word.startsWith(startSequence)) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of("apple", "banana", "apricot", "avocado"), "a"},
        {List.of("hello", "world", "hi", "house"), "h"},
        {List.of("test", "testing", "tested"), "te"},
        {List.of("one", "two", "three"), "f"},
        {List.of(), "a"},
        {List.of("same", "same", "same"), "sa"},
        {List.of("prefix", "preface", "presentation"), "pre"},
        {List.of("123abc", "abc123", "123456"), "123"},
        {List.of("no_match", "nomatch", "notmatch"), "noma"},
        {List.of("a", "b", "c", "d"), "z"}
    };

    @Test
    public void test_0() {
        assertEquals(filterByPrefix((List<String>) testCases[0][0], (String) testCases[0][1]), 
                     selectStringsWithStartingChars((List<String>) testCases[0][0], (String) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(filterByPrefix((List<String>) testCases[1][0], (String) testCases[1][1]), 
                     selectStringsWithStartingChars((List<String>) testCases[1][0], (String) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(filterByPrefix((List<String>) testCases[2][0], (String) testCases[2][1]), 
                     selectStringsWithStartingChars((List<String>) testCases[2][0], (String) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(filterByPrefix((List<String>) testCases[3][0], (String) testCases[3][1]), 
                     selectStringsWithStartingChars((List<String>) testCases[3][0], (String) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(filterByPrefix((List<String>) testCases[4][0], (String) testCases[4][1]), 
                     selectStringsWithStartingChars((List<String>) testCases[4][0], (String) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(filterByPrefix((List<String>) testCases[5][0], (String) testCases[5][1]), 
                     selectStringsWithStartingChars((List<String>) testCases[5][0], (String) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(filterByPrefix((List<String>) testCases[6][0], (String) testCases[6][1]), 
                     selectStringsWithStartingChars((List<String>) testCases[6][0], (String) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(filterByPrefix((List<String>) testCases[7][0], (String) testCases[7][1]), 
                     selectStringsWithStartingChars((List<String>) testCases[7][0], (String) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(filterByPrefix((List<String>) testCases[8][0], (String) testCases[8][1]), 
                     selectStringsWithStartingChars((List<String>) testCases[8][0], (String) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(filterByPrefix((List<String>) testCases[9][0], (String) testCases[9][1]), 
                     selectStringsWithStartingChars((List<String>) testCases[9][0], (String) testCases[9][1]));
    }
}