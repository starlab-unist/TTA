import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_28 {

    // Source Code
    static class SourceCode {
        public String concatenate(List<String> strings) {
            return String.join("", strings);
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String mergeStrings(List<String> stringList) {
            StringBuilder result = new StringBuilder();
            int index = 0;
            while (index < stringList.size()) {
                result.append(stringList.get(index));
                index++;
            }
            return result.toString();
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = Arrays.asList(
        Arguments.of(Arrays.asList("Hello", " ", "World"), "Hello World"),
        Arguments.of(Arrays.asList("Python", "3.9"), "Python3.9"),
        Arguments.of(Collections.emptyList(), ""),
        Arguments.of(Arrays.asList("single"), "single"),
        Arguments.of(Arrays.asList("a", "b", "c", "d"), "abcd"),
        Arguments.of(Arrays.asList("123", "456", "789"), "123456789"),
        Arguments.of(Arrays.asList("space", " ", "between"), "space between"),
        Arguments.of(Arrays.asList("no", "spaces"), "nospaces"),
        Arguments.of(Arrays.asList("multiple", "   ", "spaces"), "multiple   spaces"),
        Arguments.of(Arrays.asList("line1\n", "line2\n", "line3"), "line1\nline2\nline3")
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void concatenate_vs_mergeStrings(List<String> input, String expectedOutput) {
        assertEquals(
            new SourceCode().concatenate(input),
            new TransformedCode().mergeStrings(input)
        );
    }
}