import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_143 {

    // Original Implementation
    static class OriginalImpl {
        public static String wordsInSentence(String sentence) {
            List<String> newList = new ArrayList<>();
            for (String word : sentence.split("\\s+")) {
                int flg = 0;
                if (word.length() == 1) {
                    flg = 1;
                }
                for (int i = 2; i < word.length(); i++) {
                    if (word.length() % i == 0) {
                        flg = 1;
                    }
                }
                if (flg == 0 || word.length() == 2) {
                    newList.add(word);
                }
            }
            return String.join(" ", newList);
        }
    }

    // Transformed Implementation
    static class TransformedImpl {
        public static String filterUniqueLengthWords(String phrase) {
            List<String> result = new ArrayList<>();
            for (String term : phrase.split("\\s+")) {
                boolean flag = false;
                if (term.length() == 1) {
                    flag = true;
                }
                int divisor = 2;
                while (divisor < term.length()) {
                    if (term.length() % divisor == 0) {
                        flag = true;
                        break;
                    }
                    divisor++;
                }
                if (!flag || term.length() == 2) {
                    result.add(term);
                }
            }
            return String.join(" ", result);
        }
    }

    // Method to provide test cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("hello world"),
            Arguments.of("a bb ccc dddd eeeee fffffff"),
            Arguments.of("prime number test"),
            Arguments.of("two three five seven eleven"),
            Arguments.of("abc def ghi jkl mno pqr stu vwx yz"),
            Arguments.of("one two one two"),
            Arguments.of("x y z"),
            Arguments.of("ab cd ef gh ij kl mn op qr st uv wx yz"),
            Arguments.of(""),
            Arguments.of("a")
        );
    }

    // Parameterized test method
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testWordsInSentence(String input) {
        assertEquals(OriginalImpl.wordsInSentence(input), 
                     TransformedImpl.filterUniqueLengthWords(input));
    }
}