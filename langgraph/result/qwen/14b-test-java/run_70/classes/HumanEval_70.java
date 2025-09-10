import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_70 {

    // Source Code
    static class SourceCode {
        public static List<Integer> strangeSortList(List<Integer> lst) {
            List<Integer> res = new ArrayList<>();
            boolean switchFlag = true;
            while (!lst.isEmpty()) {
                int value = switchFlag ? Collections.min(lst) : Collections.max(lst);
                res.add(value);
                lst.remove(Integer.valueOf(value));
                switchFlag = !switchFlag;
            }
            return res;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> alternateSortSequence(List<Integer> sequence) {
            List<Integer> result = new ArrayList<>();
            boolean toggle = true;
            while (!sequence.isEmpty()) {
                int selectedValue = toggle ? Collections.min(sequence) : Collections.max(sequence);
                result.add(selectedValue);
                sequence.remove(Integer.valueOf(selectedValue));
                toggle = !toggle;
            }
            return result;
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(new ArrayList<>(List.of(3, 1, 2))),
        Arguments.of(new ArrayList<>(List.of(9, 7, 5, 3, 1))),
        Arguments.of(new ArrayList<>(List.of(10, 20, 30, 40, 50))),
        Arguments.of(new ArrayList<>(List.of(5, 5, 5, 5))),
        Arguments.of(new ArrayList<>(List.of(1))),
        Arguments.of(new ArrayList<>(List.of())),
        Arguments.of(new ArrayList<>(List.of(8, 6, 7, 5, 3, 0, 9))),
        Arguments.of(new ArrayList<>(List.of(2, 2, 2, 1, 1, 1, 3, 3, 3))),
        Arguments.of(new ArrayList<>(List.of(-1, -2, -3, -4, -5))),
        Arguments.of(new ArrayList<>(List.of(100, 200, 150, 50, 250)))
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void strangeSortList_vs_alternateSortSequence(List<Integer> inputList) {
        assertEquals(
            SourceCode.strangeSortList(new ArrayList<>(inputList)),
            TransformedCode.alternateSortSequence(new ArrayList<>(inputList))
        );
    }
}