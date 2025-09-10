import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_74 {

    // Source Code
    static class SourceCode {
        public static List<String> totalMatch(List<String> lst1, List<String> lst2) {
            int l1 = 0;
            for (String st : lst1) {
                l1 += st.length();
            }
            
            int l2 = 0;
            for (String st : lst2) {
                l2 += st.length();
            }
            
            if (l1 <= l2) {
                return lst1;
            } else {
                return lst2;
            }
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<String> compareStringLists(List<String> listA, List<String> listB) {
            int lengthA = listA.stream().mapToInt(String::length).sum();
            
            int lengthB = 0;
            int index = 0;
            while (index < listB.size()) {
                lengthB += listB.get(index).length();
                index++;
            }
            
            if (lengthA <= lengthB) {
                return listA;
            }
            return listB;
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(Arrays.asList("hello", "world"), Arrays.asList("hi", "planet"))},
        {Arguments.of(Arrays.asList("apple", "banana"), Arrays.asList("kiwi", "grape", "melon"))},
        {Arguments.of(Arrays.asList("one"), Arrays.asList("two", "three"))},
        {Arguments.of(Arrays.asList(), Arrays.asList("single"))},
        {Arguments.of(Arrays.asList("same", "length"), Arrays.asList("even", "longer"))},
        {Arguments.of(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e", "f"))},
        {Arguments.of(Arrays.asList("short"), Arrays.asList("tiny", "bit"))},
        {Arguments.of(Arrays.asList("equal"), Arrays.asList("equal"))},
        {Arguments.of(Arrays.asList("abc"), Arrays.asList("defg"))},
        {Arguments.of(Arrays.asList(), Arrays.asList())}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(array -> array[0]);
    }

    @DisplayName("Test totalMatch vs compareStringLists")
    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("provideTestCases")
    void totalMatch_vs_compareStringLists(List<String> lst1, List<String> lst2) {
        assertEquals(
            SourceCode.totalMatch(lst1, lst2),
            TransformedCode.compareStringLists(lst1, lst2)
        );
    }
}