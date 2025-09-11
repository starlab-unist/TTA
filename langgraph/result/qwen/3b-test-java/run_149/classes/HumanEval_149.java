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

public class HumanEval_149 {

    // Source Code
    static class HumanEval_149_Source {
        public static List<Integer> sortedListSum(List<String> lst) {
            List<Integer> newLst = new ArrayList<>();

            for (String s : lst) {
                if (s.length() % 2 == 0) {
                    newLst.add(Integer.parseInt(s));
                }
            }

            Collections.sort(newLst);
            return newLst;
        }
    }

    // Transformed Code
    static class HumanEval_149_Transformed {
        public List<String> sortedListSum(List<String> lst) {
            Collections.sort(lst);
            List<String> filteredSequence = new ArrayList<>();
            for (String element : lst) {
                if (element.length() % 2 == 0) {
                    filteredSequence.add(element);
                }
            }
            Collections.sort(filteredSequence, (a, b) -> a.length() - b.length());
            return filteredSequence;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of("apple", "banana", "cherry", "date")},
        {List.of("one", "two", "three", "four", "five")},
        {List.of("a", "bb", "ccc", "dddd", "eeeee", "ffffff")},
        {List.of("", "a", "ab", "abc", "abcd", "abcde", "abcdef")},
        {List.of("python", "java", "c++", "ruby", "swift", "go")},
        {List.of("hello", "world", "foo", "bar", "baz")},
        {List.of("short", "longer", "longest", "tiny")},
        {List.of("even", "odd", "pair", "single")},
        {List.of("aa", "bb", "cc", "dd")},
        {List.of("abcd", "efgh", "ijkl", "mnop")}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_149_Source.sortedListSum((List<String>) testCases[0][0]), 
                     new HumanEval_149_Transformed().sortedListSum((List<String>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_149_Source.sortedListSum((List<String>) testCases[1][0]), 
                     new HumanEval_149_Transformed().sortedListSum((List<String>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_149_Source.sortedListSum((List<String>) testCases[2][0]), 
                     new HumanEval_149_Transformed().sortedListSum((List<String>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_149_Source.sortedListSum((List<String>) testCases[3][0]), 
                     new HumanEval_149_Transformed().sortedListSum((List<String>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_149_Source.sortedListSum((List<String>) testCases[4][0]), 
                     new HumanEval_149_Transformed().sortedListSum((List<String>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_149_Source.sortedListSum((List<String>) testCases[5][0]), 
                     new HumanEval_149_Transformed().sortedListSum((List<String>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_149_Source.sortedListSum((List<String>) testCases[6][0]), 
                     new HumanEval_149_Transformed().sortedListSum((List<String>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_149_Source.sortedListSum((List<String>) testCases[7][0]), 
                     new HumanEval_149_Transformed().sortedListSum((List<String>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_149_Source.sortedListSum((List<String>) testCases[8][0]), 
                     new HumanEval_149_Transformed().sortedListSum((List<String>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_149_Source.sortedListSum((List<String>) testCases[9][0]), 
                     new HumanEval_149_Transformed().sortedListSum((List<String>) testCases[9][0]));
    }
}