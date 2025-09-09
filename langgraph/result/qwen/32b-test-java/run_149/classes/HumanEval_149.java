import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class HumanEval_149 {
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

public class HumanEval_149 {
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

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquivTest_149 {

    // Simple test cases
    private static final String[][] testCases = {
        {"apple", "banana", "cherry", "date"},
        {"one", "two", "three", "four", "five"},
        {"a", "bb", "ccc", "dddd", "eeeee", "ffffff"},
        {"", "a", "ab", "abc", "abcd", "abcde", "abcdef"},
        {"python", "java", "c++", "ruby", "swift", "go"},
        {"hello", "world", "foo", "bar", "baz"},
        {"short", "longer", "longest", "tiny"},
        {"even", "odd", "pair", "single"},
        {"aa", "bb", "cc", "dd"},
        {"abcd", "efgh", "ijkl", "mnop"}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_149.sortedListSum(List.of(testCases[0])), Transformed_HumanEval_149.evenLengthSortedElements(List.of(testCases[0])));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_149.sortedListSum(List.of(testCases[1])), Transformed_HumanEval_149.evenLengthSortedElements(List.of(testCases[1])));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_149.sortedListSum(List.of(testCases[2])), Transformed_HumanEval_149.evenLengthSortedElements(List.of(testCases[2])));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_149.sortedListSum(List.of(testCases[3])), Transformed_HumanEval_149.evenLengthSortedElements(List.of(testCases[3])));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_149.sortedListSum(List.of(testCases[4])), Transformed_HumanEval_149.evenLengthSortedElements(List.of(testCases[4])));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_149.sortedListSum(List.of(testCases[5])), Transformed_HumanEval_149.evenLengthSortedElements(List.of(testCases[5])));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_149.sortedListSum(List.of(testCases[6])), Transformed_HumanEval_149.evenLengthSortedElements(List.of(testCases[6])));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_149.sortedListSum(List.of(testCases[7])), Transformed_HumanEval_149.evenLengthSortedElements(List.of(testCases[7])));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_149.sortedListSum(List.of(testCases[8])), Transformed_HumanEval_149.evenLengthSortedElements(List.of(testCases[8])));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_149.sortedListSum(List.of(testCases[9])), Transformed_HumanEval_149.evenLengthSortedElements(List.of(testCases[9])));
    }
}