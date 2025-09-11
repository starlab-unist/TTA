import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_149 {

    // Source Code
    static class OriginalImpl {
        public static List<String> sortedListSum(List<String> lst) {
            java.util.Collections.sort(lst);
            List<String> newLst = new ArrayList<>();
            for (String i : lst) {
                if (i.length() % 2 == 0) {
                    newLst.add(i);
                }
            }
            java.util.Collections.sort(newLst, java.util.Comparator.comparingInt(String::length));
            return newLst;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static ArrayList<String> sortedListSum(ArrayList<String> lst) {
            java.util.Collections.sort(lst);
            ArrayList<String> new_lst = new ArrayList<>();
            for (String element : lst) {
                if (element.length() % 2 == 0) {
                    new_lst.add(element);
                }
            }
            java.util.Collections.sort(new_lst, java.util.Comparator.comparingInt(String::length));
            return new_lst;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date"))),
            Arguments.of(new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"))),
            Arguments.of(new ArrayList<>(Arrays.asList("a", "bb", "ccc", "dddd", "eeeee", "ffffff"))),
            Arguments.of(new ArrayList<>(Arrays.asList("", "a", "ab", "abc", "abcd", "abcde", "abcdef"))),
            Arguments.of(new ArrayList<>(Arrays.asList("python", "java", "c++", "ruby", "swift", "go"))),
            Arguments.of(new ArrayList<>(Arrays.asList("hello", "world", "foo", "bar", "baz"))),
            Arguments.of(new ArrayList<>(Arrays.asList("short", "longer", "longest", "tiny"))),
            Arguments.of(new ArrayList<>(Arrays.asList("even", "odd", "pair", "single"))),
            Arguments.of(new ArrayList<>(Arrays.asList("aa", "bb", "cc", "dd"))),
            Arguments.of(new ArrayList<>(Arrays.asList("abcd", "efgh", "ijkl", "mnop")))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testSortedListSum(ArrayList<String> testCase) {
        assertEquals(OriginalImpl.sortedListSum(new ArrayList<>(testCase)), 
                     TransformedImpl.sortedListSum(testCase));
    }
}