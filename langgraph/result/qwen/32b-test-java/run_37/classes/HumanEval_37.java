import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_37 {

    // Source Code
    static class HumanEval_37_Source {
        public static List<Integer> sortEven(List<Integer> l) {
            List<Integer> evens = new ArrayList<>();
            List<Integer> odds = new ArrayList<>();

            for (int i = 0; i < l.size(); i++) {
                if (i % 2 == 0) {
                    evens.add(l.get(i));
                } else {
                    odds.add(l.get(i));
                }
            }

            Collections.sort(evens);

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < odds.size(); i++) {
                ans.add(evens.get(i));
                ans.add(odds.get(i));
            }

            if (evens.size() > odds.size()) {
                ans.add(evens.get(evens.size() - 1));
            }

            return ans;
        }
    }

    // Transformed Code
    static class HumanEval_37_Transformed {
        public List<Integer> rearrangeEvenOdd(List<Integer> numbers) {
            List<Integer> evenElements = new ArrayList<>();
            List<Integer> oddElements = new ArrayList<>();

            for (int i = 0; i < numbers.size(); i++) {
                if (i % 2 == 0) {
                    evenElements.add(numbers.get(i));
                } else {
                    oddElements.add(numbers.get(i));
                }
            }

            Collections.sort(evenElements);
            List<Integer> result = new ArrayList<>();

            int index = 0;
            while (index < oddElements.size()) {
                result.add(evenElements.get(index));
                result.add(oddElements.get(index));
                index++;
            }

            if (evenElements.size() > oddElements.size()) {
                result.add(evenElements.get(evenElements.size() - 1));
            }

            return result;
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList(2, 3, 4, 5, 6), Arrays.asList(2, 3, 4, 5, 6)),
        Arguments.of(Arrays.asList(10, 9, 8, 7, 6, 5), Arrays.asList(6, 9, 8, 7, 10, 5)),
        Arguments.of(Arrays.asList(1, 3, 5, 7, 2, 4, 6, 8), Arrays.asList(1, 3, 2, 4, 5, 7, 6, 8)),
        Arguments.of(Arrays.asList(1, 2), Arrays.asList(1, 2)),
        Arguments.of(Arrays.asList(5), Arrays.asList(5)),
        Arguments.of(Arrays.asList(), Arrays.asList()),
        Arguments.of(Arrays.asList(7, 1, 9, 3, 11, 5, 13), Arrays.asList(7, 1, 9, 3, 11, 5, 13)),
        Arguments.of(Arrays.asList(4, 2, 6, 8, 0, 10, 12, 14), Arrays.asList(0, 2, 4, 8, 6, 10, 12, 14)),
        Arguments.of(Arrays.asList(15, 14, 13, 12, 11, 10, 9), Arrays.asList(9, 14, 11, 12, 13, 10, 15)),
        Arguments.of(Arrays.asList(20, 19, 22, 21, 24, 23, 26, 25, 28), Arrays.asList(20, 19, 22, 21, 24, 23, 26, 25, 28))
    );

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Testing Equivalence of sortEven and rearrangeEvenOdd")
    void testSortEven_vs_RearrangeEvenOdd(List<Integer> input, List<Integer> expectedOutput) {
        assertEquals(
            HumanEval_37_Source.sortEven(input),
            new HumanEval_37_Transformed().rearrangeEvenOdd(input)
        );
    }

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }
}