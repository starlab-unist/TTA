import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;  // Added import for Stream

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_5 {

    // Source Code
    static class SourceCode {
        public static List<Integer> intersperse(List<Integer> numbers, int delimiter) {
            if (numbers.isEmpty()) {
                return new ArrayList<>();
            }

            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < numbers.size() - 1; i++) {
                result.add(numbers.get(i));
                result.add(delimiter);
            }

            result.add(numbers.get(numbers.size() - 1));

            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> weaveNumbers(List<Integer> sequence, int separator) {
            if (sequence.isEmpty()) {
                return new ArrayList<>();
            }

            List<Integer> interleaved = new ArrayList<>();
            int index = 0;

            while (index < sequence.size() - 1) {
                interleaved.add(sequence.get(index));
                interleaved.add(separator);
                index++;
            }

            interleaved.add(sequence.get(sequence.size() - 1));

            return interleaved;
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = List.of(
        Arguments.of(List.of(1, 2, 3), 0),
        Arguments.of(List.of(5, 6, 7, 8), -1),
        Arguments.of(List.of(10), 5),
        Arguments.of(List.of(), 3),
        Arguments.of(List.of(1, 1, 1, 1), 2),
        Arguments.of(List.of(9, 8, 7), 4),
        Arguments.of(List.of(2, 4, 6, 8, 10), 1),
        Arguments.of(List.of(3, 3, 3), 3),
        Arguments.of(List.of(5), 5),
        Arguments.of(List.of(7, 8), 9)
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void intersperse_vs_weaveNumbers(List<Integer> inputList, int delimiter) {
        assertEquals(
            SourceCode.intersperse(inputList, delimiter),
            TransformedCode.weaveNumbers(inputList, delimiter)
        );
    }
}