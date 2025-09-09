import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_26 {

    // Source Code
    static class SourceCode {
        public List<Integer> removeDuplicates(List<Integer> numbers) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (Integer number : numbers) {
                countMap.put(number, countMap.getOrDefault(number, 0) + 1);
            }
            List<Integer> result = new ArrayList<>();
            for (Integer number : numbers) {
                if (countMap.get(number) <= 1) {
                    result.add(number);
                }
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> filterUniqueElements(List<Integer> numList) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (Integer num : numList) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
            
            List<Integer> uniqueNumbers = new ArrayList<>();
            for (Integer num : numList) {
                if (countMap.get(num) == 1) {
                    uniqueNumbers.add(num);
                }
            }
            
            return uniqueNumbers;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(List.of(1, 2, 2, 3, 4, 4, 5), List.of(1, 3, 5)), // Both should include 1, 3, 5
        Arguments.of(List.of(10, 20, 20, 30, 30, 30, 40), List.of(10, 40)), // Both should include 10, 40
        Arguments.of(List.of(1, 1, 1, 1, 1), List.of()), // Both should return empty list
        Arguments.of(List.of(5, 7, 8, 9, 10), List.of(5, 7, 8, 9, 10)), // Both should include all numbers
        Arguments.of(List.of(), List.of()), // Both should return empty list
        Arguments.of(List.of(123, 456, 789), List.of(123, 456, 789)), // Both should include all numbers
        Arguments.of(List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5), List.of()), // Both should return empty list
        Arguments.of(List.of(0, 0, 0, 1, 1, 1, 2, 2, 3), List.of(3)), // Both should include 3
        Arguments.of(List.of(7, 8, 9, 7, 8, 10), List.of(9, 10)), // Both should include 9, 10
        Arguments.of(List.of(42), List.of(42)), // Both should include 42
        Arguments.of(List.of(6, 6, 7, 8, 8, 9, 9, 10), List.of(7, 10)), // Both should include 7, 10
        Arguments.of(List.of(25, 25, 25, 30, 40, 50, 50), List.of(30, 40)), // Both should include 30, 40
        Arguments.of(List.of(100, 200, 300, 400, 500), List.of(100, 200, 300, 400, 500)), // Both should include all numbers
    };

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(testCases);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void removeDuplicates_vs_filterUniqueElements(List<Integer> input, List<Integer> expectedOutput) {
        assertEquals(
            SourceCode.removeDuplicates(input),
            TransformedCode.filterUniqueElements(input)
        );
    }
}