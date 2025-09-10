import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_42 {

    // Source Code
    static class SourceCode {
        public List<Integer> incrList(List<Integer> l) {
            List<Integer> result = new ArrayList<>();
            for (Integer e : l) {
                result.add(e + 1);
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> incrementElements(List<Integer> inputList) {
            List<Integer> result = new ArrayList<>();
            int index = 0;
            while (index < inputList.size()) {
                result.add(inputList.get(index) + 1);
                index++;
            }
            return result;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        { List.of(1, 2, 3, 4, 5) },
        { List.of(-1, -2, -3, -4, -5) },
        { List.of(0, 0, 0, 0) },
        { List.of() },
        { List.of(100, 200, 300) },
        { List.of(-100, 0, 100) },
        { List.of(1) },
        { List.of(-1) },
        { List.of(0) },
        { List.of(9, 8, 7, 6, 5) }
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Testing incrList vs incrementElements")
    @ParameterizedTest(name = "Test case {index}")
    @MethodSource("provideTestCases")
    void incrList_vs_incrementElements(List<Integer> inputList) {
        assertEquals(
            new SourceCode().incrList(inputList),
            new TransformedCode().incrementElements(inputList)
        );
    }
}