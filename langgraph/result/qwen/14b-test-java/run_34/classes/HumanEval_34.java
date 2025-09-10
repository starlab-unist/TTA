import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// JUnit imports
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_34 {

    // Source Code
    static class SourceCode {
        public static List<Integer> unique(List<Integer> l) {
            HashSet<Integer> set = new HashSet<>(l);
            List<Integer> result = new ArrayList<>(set);
            Collections.sort(result);
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> extract_distinct_elements(List<Integer> input_list) {
            Set<Integer> distinct_elements = new TreeSet<>(input_list);
            List<Integer> sorted_elements = new ArrayList<>(distinct_elements);
            return sorted_elements;
        }
    }

    // Test Cases
    @DisplayName("Tests for HumanEval_34 equivalence")
    public static class TestHumanEval_34 {

        private static final List<Arguments> testCases = List.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 5, 6)),
            Arguments.of(List.of(1, 2, 3, 1, 2)),
            Arguments.of(new ArrayList<>()),
            Arguments.of(List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5)),
            Arguments.of(List.of(1, 2, 3, 1, 4)),
            Arguments.of(List.of(0, 1, 0, 0, 1)),
            Arguments.of(List.of(1, 2, 3, 2, 1)),
            Arguments.of(List.of(1, 1, 2)),
            Arguments.of(List.of(1)),
            Arguments.of(List.of()),
            Arguments.of(List.of(-1, -2, -3, -2, -1))
        );

        private static java.util.stream.Stream<Arguments> provideTestCases() {
            return testCases.stream();
        }

        @ParameterizedTest
        @MethodSource("provideTestCases")
        void unique_vs_extract_distinct_elements(List<Integer> inputList) {
            assertEquals(
                SourceCode.unique(inputList),
                TransformedCode.extract_distinct_elements(inputList)
            );
        }
    }
}