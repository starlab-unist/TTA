import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_149 {

    // Source Code
    static class OriginalImpl {
        public static List<String> sortedListSum(List<String> lst) {
            Collections.sort(lst);
            List<String> newLst = new ArrayList<>();
            for (String i : lst) {
                if (i.length() % 2 == 0) {
                    newLst.add(i);
                }
            }
            Collections.sort(newLst, Comparator.comparingInt(String::length));
            return newLst;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public List<String> evenLengthSortedElements(List<String> sequence) {
            Collections.sort(sequence);
            List<String> filteredSequence = new ArrayList<>();
            for (String element : sequence) {
                if (element.length() % 2 == 0) {
                    filteredSequence.add(element);
                }
            }
            Collections.sort(filteredSequence, Comparator.comparingInt(String::length));
            return filteredSequence;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of("apple", "banana", "cherry", "date")),
            Arguments.of(List.of("one", "two", "three", "four", "five")),
            Arguments.of(List.of("a", "bb", "ccc", "dddd", "eeeee", "ffffff")),
            Arguments.of(List.of("", "a", "ab", "abc", "abcd", "abcde", "abcdef")),
            Arguments.of(List.of("python", "java", "c++", "ruby", "swift", "go")),
            Arguments.of(List.of("hello", "world", "foo", "bar", "baz")),
            Arguments.of(List.of("short", "longer", "longest", "tiny")),
            Arguments.of(List.of("even", "odd", "pair", "single")),
            Arguments.of(List.of("aa", "bb", "cc", "dd")),
            Arguments.of(List.of("abcd", "efgh", "ijkl", "mnop"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testSortedListsAreEqual(List<String> input) {
        assertEquals(OriginalImpl.sortedListSum(input), new TransformedImpl().evenLengthSortedElements(new ArrayList<>(input)));
    }
}