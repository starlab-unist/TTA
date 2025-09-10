import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_90 {

    // Source Code
    static class HumanEval_90_Source {
        public static Integer nextSmallest(List<Integer> lst) {
            List<Integer> uniqueList = new ArrayList<>(new HashSet<>(lst));
            Collections.sort(uniqueList);
            return uniqueList.size() < 2 ? null : uniqueList.get(1);
        }
    }

    // Transformed Code
    static class HumanEval_90_Transformed {
        public Integer findSecondMinimum(List<Integer> numbers) {
            Set<Integer> uniqueSet = new HashSet<>(numbers);
            List<Integer> uniqueNumbers = new ArrayList<>(uniqueSet);
            Collections.sort(uniqueNumbers);

            if (uniqueNumbers.size() < 2) {
                return null;
            }

            return uniqueNumbers.get(1);
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(List.of(3, 1, 4, 1, 5, 9), 3)},
        {Arguments.of(List.of(10, 20, 20, 10, 30), 20)},
        {Arguments.of(List.of(1, 2, 3, 4, 5), 2)},
        {Arguments.of(List.of(5, 5, 5, 5, 5), null)},
        {Arguments.of(List.of(7), null)},
        {Arguments.of(List.of(), null)},
        {Arguments.of(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1), 2)},
        {Arguments.of(List.of(0, -1, -2, -3, -4), -3)},
        {Arguments.of(List.of(-10, -20, -10, -30, -20), -20)},
        {Arguments.of(List.of(100, 200, 300, 100, 200, 300), 200)}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(args -> args[0]);
    }

    @DisplayName("Test equivalence of nextSmallest and findSecondMinimum")
    @ParameterizedTest(name = "with input {0}")
    @MethodSource("provideTestCases")
    void testNextSmallest_vs_findSecondMinimum(List<Integer> inputList, Integer expected) {
        HumanEval_90_Transformed transformedInstance = new HumanEval_90_Transformed();
        
        assertEquals(
            HumanEval_90_Source.nextSmallest(inputList),
            transformedInstance.findSecondMinimum(inputList)
        );
    }
}