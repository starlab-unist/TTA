import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
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

    @Test
    public void test_0() {
        assertEquals(
            new HumanEval_143_Source().wordsInSentence(testCases[0]),
            new HumanEval_143_Transformed().filterUniqueLengthWords(testCases[0])
        );
    }

    @Test
    public void test_1() {
        assertEquals(
            new HumanEval_143_Source().wordsInSentence(testCases[1]),
            new HumanEval_143_Transformed().filterUniqueLengthWords(testCases[1])
        );
    }

    @Test
    public void test_2() {
        assertEquals(
            new HumanEval_143_Source().wordsInSentence(testCases[2]),
            new HumanEval_143_Transformed().filterUniqueLengthWords(testCases[2])
        );
    }

    @Test
    public void test_3() {
        assertEquals(
            new HumanEval_143_Source().wordsInSentence(testCases[3]),
            new HumanEval_143_Transformed().filterUniqueLengthWords(testCases[3])
        );
    }

    @Test
    public void test_4() {
        assertEquals(
            new HumanEval_143_Source().wordsInSentence(testCases[4]),
            new HumanEval_143_Transformed().filterUniqueLengthWords(testCases[4])
        );
    }

    @Test
    public void test_5() {
        assertEquals(
            new HumanEval_143_Source().wordsInSentence(testCases[5]),
            new HumanEval_143_Transformed().filterUniqueLengthWords(testCases[5])
        );
    }

    @Test
    public void test_6() {
        assertEquals(
            new HumanEval_143_Source().wordsInSentence(testCases[6]),
            new HumanEval_143_Transformed().filterUniqueLengthWords(testCases[6])
        );
    }

    @Test
    public void test_7() {
        assertEquals(
            new HumanEval_143_Source().wordsInSentence(testCases[7]),
            new HumanEval_143_Transformed().filterUniqueLengthWords(testCases[7])
        );
    }

    @Test
    public void test_8() {
        assertEquals(
            new HumanEval_143_Source().wordsInSentence(testCases[8]),
            new HumanEval_143_Transformed().filterUniqueLengthWords(testCases[8])
        );
    }

    @Test
    public void test_9() {
        assertEquals(
            new HumanEval_143_Source().wordsInSentence(testCases[9]),
            new HumanEval_143_Transformed().filterUniqueLengthWords(testCases[9])
        );
    }
}