import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_30 {

    // Source Code
    static class SourceCode {
        public List<Integer> getPositive(List<Integer> l) {
            List<Integer> result = new ArrayList<>();
            for (Integer e : l) {
                if (e > 0) {
                    result.add(e);
                }
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<Integer> extractPositiveNumbers(List<Integer> inputList) {
            List<Integer> positiveNumbers = new ArrayList<>();
            int index = 0;

            while (index < inputList.size()) {
                if (inputList.get(index) > 0) {
                    positiveNumbers.add(inputList.get(index));
                }
                index++;
            }

            return positiveNumbers;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, -2, 3, 4, -5)),
            Arguments.of(Arrays.asList(-1, -2, -3, -4, -5)),
            Arguments.of(Arrays.asList(0, 0, 0, 0)),
            Arguments.of(Arrays.asList(10, 20, 30, 40, 50)),
            Arguments.of(Arrays.asList()),
            Arguments.of(Arrays.asList(-10, 0, 10)),
            Arguments.of(Arrays.asList(5)),
            Arguments.of(Arrays.asList(-5)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, -6, -7, -8, -9, -10)),
            Arguments.of(Arrays.asList(100, 200, 300, -100, -200, -300))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void getPositive_vs_extractPositiveNumbers(List<Integer> inputList) {
        SourceCode source = new SourceCode();
        TransformedCode transformed = new TransformedCode();

        assertEquals(
            source.getPositive(inputList),
            transformed.extractPositiveNumbers(inputList)
        );
    }
}