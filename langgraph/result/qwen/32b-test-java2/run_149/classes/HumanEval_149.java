import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;  // Required for Collections.sort()
import java.util.Comparator;    // Required for Comparator.comparingInt()
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_149 {

    // Source Code
    static class HumanEval_149_Source {
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
    static class HumanEval_149_Transformed {
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
    private static final List<String[]> testCases = Arrays.asList(
        new String[]{"apple", "banana", "cherry", "date"},
        new String[]{"one", "two", "three", "four", "five"},
        new String[]{"a", "bb", "ccc", "dddd", "eeeee", "ffffff"},
        new String[]{"", "a", "ab", "abc", "abcd", "abcde", "abcdef"},
        new String[]{"python", "java", "c++", "ruby", "swift", "go"},
        new String[]{"hello", "world", "foo", "bar", "baz"},
        new String[]{"short", "longer", "longest", "tiny"},
        new String[]{"even", "odd", "pair", "single"},
        new String[]{"aa", "bb", "cc", "dd"},
        new String[]{"abcd", "efgh", "ijkl", "mnop"}
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void sortedListSum_vs_evenLengthSortedElements(String[] input) {
        List<String> inputList = Arrays.asList(input);
        assertEquals(
            HumanEval_149_Source.sortedListSum(new ArrayList<>(inputList)),
            new HumanEval_149_Transformed().evenLengthSortedElements(new ArrayList<>(inputList))
        );
    }
}