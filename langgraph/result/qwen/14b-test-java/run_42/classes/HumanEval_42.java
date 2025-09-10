import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_42 {

    // Source Code
    static class SourceCode {
        public static List<Integer> incrList(List<Integer> l) {
            List<Integer> result = new ArrayList<>();
            for (Integer e : l) {
                result.add(e + 1);
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> incrementElements(List<Integer> inputList) {
            List<Integer> result = new ArrayList<>();
            int index = 0;
            while (index < inputList.size()) {
                result.add(inputList.get(index) + 1);
                index += 1;
            }
            return result;
        }
    }

    // Test Cases
    private static final Integer[][] testCases = {
        {1, 2, 3, 4, 5},
        {-1, -2, -3, -4, -5},
        {0, 0, 0, 0},
        {},
        {100, 200, 300},
        {-100, 0, 100},
        {1},
        {-1},
        {0},
        {9, 8, 7, 6, 5}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Test equivalence of incrList and incrementElements")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void incrList_vs_incrementElements(Integer[] inputArray) {
        List<Integer> inputList = Arrays.asList(inputArray);
        assertEquals(
            SourceCode.incrList(inputList),
            TransformedCode.incrementElements(inputList)
        );
    }
}