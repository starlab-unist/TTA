import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_37 {

    // Source Code
    static class SourceCode {
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
            for (int i = 0; i < Math.min(evens.size(), odds.size()); i++) {
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
    static class TransformedCode {
        public static List<Integer> rearrangeEvenOdd(List<Integer> numbers) {
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
    private static final Object[][] testCases = {
        {List.of(2, 3, 4, 5, 6), List.of(2, 3, 4, 5, 6)},
        {List.of(10, 9, 8, 7, 6, 5), List.of(6, 9, 8, 7, 10, 5)},
        {List.of(1, 3, 5, 7, 2, 4, 6, 8), List.of(1, 3, 2, 4, 5, 7, 6, 8)},
        {List.of(1, 2), List.of(1, 2)},
        {List.of(5), List.of(5)},
        {List.of(), List.of()},
        {List.of(7, 1, 9, 3, 11, 5, 13), List.of(7, 1, 9, 3, 11, 5, 13)},
        {List.of(4, 2, 6, 8, 0, 10, 12, 14), List.of(0, 2, 4, 8, 6, 10, 12, 14)},
        {List.of(15, 14, 13, 12, 11, 10, 9), List.of(9, 14, 11, 12, 13, 10, 15)},
        {List.of(20, 19, 22, 21, 24, 23, 26, 25, 28), List.of(20, 19, 22, 21, 24, 23, 26, 25, 28)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> Arguments.arguments((List<Integer>) args[0], (List<Integer>) args[1]));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void sortEven_vs_rearrangeEvenOdd(List<Integer> inputList, List<Integer> expectedOutput) {
        assertEquals(
            SourceCode.sortEven(inputList),
            TransformedCode.rearrangeEvenOdd(inputList)
        );
        assertEquals(expectedOutput, SourceCode.sortEven(inputList));
        assertEquals(expectedOutput, TransformedCode.rearrangeEvenOdd(inputList));
    }
}