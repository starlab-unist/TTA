import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream; // Import Stream

public class HumanEval_26 {

    // Source Code
    static class SourceCode {
        public static List<Integer> removeDuplicates(List<Integer> numbers) { // Declare as static
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
        public static List<Integer> filterUniqueElements(List<Integer> numList) { // Declare as static
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
    private static final Arguments[][] testCases = {
        {Arguments.of(Arrays.asList(1, 2, 2, 3, 4, 4, 5), Arrays.asList(1, 3, 5))},
        {Arguments.of(Arrays.asList(10, 20, 20, 30, 30, 30, 40), Arrays.asList(10, 40))},
        {Arguments.of(Arrays.asList(1, 1, 1, 1, 1), Collections.emptyList())},
        {Arguments.of(Arrays.asList(5, 7, 8, 9, 10), Arrays.asList(5, 7, 8, 9, 10))},
        {Arguments.of(Collections.emptyList(), Collections.emptyList())},
        {Arguments.of(Arrays.asList(123, 456, 789), Arrays.asList(123, 456, 789))},
        {Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5), Collections.emptyList())},
        {Arguments.of(Arrays.asList(0, 0, 0, 1, 1, 1, 2, 2, 3), Arrays.asList(3))},
        {Arguments.of(Arrays.asList(7, 8, 9, 7, 8, 10), Arrays.asList(9, 10))},
        {Arguments.of(Arrays.asList(42), Arrays.asList(42))}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).flatMap(Arrays::stream);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("removeDuplicates vs filterUniqueElements")
    void removeDuplicates_vs_filterUniqueElements(List<Integer> input, List<Integer> expected) {
        assertEquals(
            SourceCode.removeDuplicates(input),
            TransformedCode.filterUniqueElements(input)
        );
    }
}