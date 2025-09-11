import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Source Code
public class HumanEval_86 {

    public static String anti_shuffle(String s) {
        return String.join(" ", 
                s.split(" ")
                        .map(str -> String.join("", 
                                str.chars()
                                        .sorted()
                                        .mapToObj(c -> String.valueOf((char) c))
                                        .collect(java.util.stream.Collectors.toList()))));
    }

    // Transformed Code
    public static String orderWordsCharacters(String inputString) {
        String[] words = inputString.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            char[] chars = word.toCharArray();
            java.util.Arrays.sort(chars);
            String sortedWord = new String(chars);
            result.append(sortedWord).append(" ");
        }

        return result.toString().trim();
    }

    // Nested classes to wrap the implementations
    static class OriginalImpl {
        public static String anti_shuffle(String s) {
            return HumanEval_86.anti_shuffle(s);
        }
    }

    static class TransformedImpl {
        public static String orderWordsCharacters(String inputString) {
            return HumanEval_86.orderWordsCharacters(inputString);
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("hello world"),
                Arguments.of("python is fun"),
                Arguments.of("openai gpt"),
                Arguments.of("shuffle this string"),
                Arguments.of("keep it sorted"),
                Arguments.of("characters in words"),
                Arguments.of("simple test case"),
                Arguments.of("another example here"),
                Arguments.of("singleword"),
                Arguments.of("")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testAntiShuffleAndOrderWordsCharacters(String input) {
        assertEquals(OriginalImpl.anti_shuffle(input), TransformedImpl.orderWordsCharacters(input));
    }
}