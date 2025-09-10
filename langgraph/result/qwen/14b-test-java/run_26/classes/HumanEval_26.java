import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_26 {

    // Source Code
    static class SourceCode {
        public static List<Integer> removeDuplicates(List<Integer> numbers) {
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
        public static List<Integer> filterUniqueElements(List<Integer> numList) {
            Map<Integer, Integer> countMap = new HashMap<>();
            
            for (int num : numList) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
            
            List<Integer> uniqueNumbers = new ArrayList<>();
            for (int num : numList) {
                if (countMap.get(num) == 1) {
                    uniqueNumbers.add(num);
                }
            }
            
            return uniqueNumbers;
        }
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(new ArrayList<>(List.of(1, 2, 2, 3, 4, 4, 5)), new ArrayList<>(List.of(1, 3, 5))),
        Arguments.of(new ArrayList<>(List.of(10, 20, 20, 30, 30, 30, 40)), new ArrayList<>(List.of(10, 40))),
        Arguments.of(new ArrayList<>(List.of(1, 1, 1, 1, 1)), new ArrayList<>()),
        Arguments.of(new ArrayList<>(List.of(5, 7, 8, 9, 10)), new ArrayList<>(List.of(5, 7, 8, 9, 10))),
        Arguments.of(new ArrayList<>(), new ArrayList<>()),
        Arguments.of(new ArrayList<>(List.of(123, 456, 789)), new ArrayList<>(List.of(123, 456, 789))),
        Arguments.of(new ArrayList<>(List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)), new ArrayList<>()),
        Arguments.of(new ArrayList<>(List.of(0, 0, 0, 1, 1, 1, 2, 2, 3)), new ArrayList<>(List.of(3))),
        Arguments.of(new ArrayList<>(List.of(7, 8, 9, 7, 8, 10)), new ArrayList<>(List.of(9, 10))),
        Arguments.of(new ArrayList<>(List.of(42)), new ArrayList<>(List.of(42)))
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
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