import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays; // Importing Arrays class for stream conversion
import java.util.List;
import java.util.stream.Stream;

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
    private static final Object[][] testCases = {
        {List.of("Hello", " ", "World"), "Hello World"},
        {List.of("Python", "3.9"), "Python3.9"},
        {List.of(), ""},
        {List.of("single"), "single"},
        {List.of("a", "b", "c", "d"), "abcd"},
        {List.of("123", "456", "789"), "123456789"},
        {List.of("space", " ", "between"), "space between"},
        {List.of("no", "spaces"), "nospaces"},
        {List.of("multiple", "   ", "spaces"), "multiple   spaces"},
        {List.of("line1\n", "line2\n", "line3"), "line1\nline2\nline3"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void concatenate_vs_mergeStrings(List<String> input, String expected) {
        SourceCode source = new SourceCode(); // Instantiate SourceCode class
        TransformedCode transformed = new TransformedCode(); // Instantiate TransformedCode class

        assertEquals(
            source.concatenate(input), // Call concatenate on the instance of SourceCode
            transformed.mergeStrings(input) // Call mergeStrings on the instance of TransformedCode
        );
    }
}