import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_28 {

    // Source Code
    static class SourceCode {
        public static String concatenate(List<String> strings) {
            StringBuilder result = new StringBuilder();
            for (String str : strings) {
                result.append(str);
            }
            return result.toString();
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static String mergeStrings(List<String> stringList) {
            StringBuilder result = new StringBuilder();
            int index = 0;
            while (index < stringList.size()) {
                result.append(stringList.get(index));
                index += 1;
            }
            return result.toString();
        }
    }

    // Test Cases
    private static final List<Arguments> testCases = List.of(
        Arguments.of(List.of("Hello", " ", "World"), "Hello World"),
        Arguments.of(List.of("Python", "3.9"), "Python3.9"),
        Arguments.of(List.of(), ""),
        Arguments.of(List.of("single"), "single"),
        Arguments.of(List.of("a", "b", "c", "d"), "abcd"),
        Arguments.of(List.of("123", "456", "789"), "123456789"),
        Arguments.of(List.of("space", " ", "between"), "space between"),
        Arguments.of(List.of("no", "spaces"), "nospaces"),
        Arguments.of(List.of("multiple", "   ", "spaces"), "multiple   spaces"),
        Arguments.of(List.of("line1\n", "line2\n", "line3"), "line1\nline2\nline3")
    );

    private static Stream<Arguments> provideTestCases() {
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void concatenate_vs_mergeStrings(List<String> inputList, String expectedOutput) {
        assertEquals(
            SourceCode.concatenate(inputList),
            TransformedCode.mergeStrings(inputList)
        );
    }
}