import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_143 {

    // Source Code
    public static String wordsInSentence(String sentence) {
        StringBuilder newLst = new StringBuilder();
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
                if (newLst.length() > 0) {
                    newLst.append(" ");
                }
                newLst.append(word);
            }
        }
        return newLst.toString();
    }

    // Transformed Code
    public static String filterUniqueLengthWords(String phrase) {
        StringBuilder result = new StringBuilder();
        String[] terms = phrase.split("\\s+");
        
        for (String term : terms) {
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
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(term);
            }
        }
        
        return result.toString();
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
        assertEquals(wordsInSentence(testCases[0]), filterUniqueLengthWords(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(wordsInSentence(testCases[1]), filterUniqueLengthWords(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(wordsInSentence(testCases[2]), filterUniqueLengthWords(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(wordsInSentence(testCases[3]), filterUniqueLengthWords(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(wordsInSentence(testCases[4]), filterUniqueLengthWords(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(wordsInSentence(testCases[5]), filterUniqueLengthWords(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(wordsInSentence(testCases[6]), filterUniqueLengthWords(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(wordsInSentence(testCases[7]), filterUniqueLengthWords(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(wordsInSentence(testCases[8]), filterUniqueLengthWords(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(wordsInSentence(testCases[9]), filterUniqueLengthWords(testCases[9]));
    }
}