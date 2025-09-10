import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_143 {

    // Source Code
    static class HumanEval_143_Source {
        public String wordsInSentence(String sentence) {
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

    // Transformed Code
    static class HumanEval_143_Transformed {
        public String filterUniqueLengthWords(String phrase) {
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

    // Test Cases
    private static final String[] testCases = {
        "hello world",
        "a bb ccc dddd eeeee fffffff",
        "prime number test",
        "two three five seven eleven",
        "abc def ghi jkl mno pqr stu vwx yz",
        "one two one two",
        "x y z",
        "ab cd ef gh ij kl mn op qr st uv wx yz",
        "",
        "a"
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void wordsInSentence_vs_filterUniqueLengthWords(String inputText) {
        HumanEval_143_Source source = new HumanEval_143_Source();
        HumanEval_143_Transformed transformed = new HumanEval_143_Transformed();

        assertEquals(
            source.wordsInSentence(inputText),
            transformed.filterUniqueLengthWords(inputText)
        );
    }
}