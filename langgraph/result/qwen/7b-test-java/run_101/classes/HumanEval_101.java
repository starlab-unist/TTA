import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_101 {

    // Source Code
    static class HumanEval_101_Source {
        public static List<String> wordsString(String s) {
            if (s == null || s.isEmpty()) {
                return new ArrayList<>();
            }

            List<String> sList = new ArrayList<>();

            for (char letter : s.toCharArray()) {
                if (letter == ',') {
                    sList.add(" ");
                } else {
                    sList.add(String.valueOf(letter));
                }
            }

            String result = String.join("", sList);
            return List.of(result.split("\\s+"));
        }
    }

    // Transformed Code
    static class HumanEval_101_Transformed {
        public static List<String> processText(String inputString) {
            if (inputString == null || inputString.isEmpty()) {
                return new ArrayList<>();
            }

            List<Character> processedChars = new ArrayList<>();

            int index = 0;
            while (index < inputString.length()) {
                char ch = inputString.charAt(index);
                if (ch == ',') {
                    processedChars.add(' ');
                } else {
                    processedChars.add(ch);
                }
                index++;
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : processedChars) {
                sb.append(ch);
            }

            String processedString = sb.toString();
            return List.of(processedString.split("\\s+"));
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "Hello,world",
        "Python,is,great!",
        "OpenAI,ChatGPT",
        "This,is,a,test,string",
        "No commas here",
        ",Leading and trailing,",
        "Multiple,,,commas,,here",
        "",
        " ",
        "OneWord"
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_101_Source.wordsString(testCases[0]), 
                     HumanEval_101_Transformed.processText(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_101_Source.wordsString(testCases[1]), 
                     HumanEval_101_Transformed.processText(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_101_Source.wordsString(testCases[2]), 
                     HumanEval_101_Transformed.processText(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_101_Source.wordsString(testCases[3]), 
                     HumanEval_101_Transformed.processText(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_101_Source.wordsString(testCases[4]), 
                     HumanEval_101_Transformed.processText(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_101_Source.wordsString(testCases[5]), 
                     HumanEval_101_Transformed.processText(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_101_Source.wordsString(testCases[6]), 
                     HumanEval_101_Transformed.processText(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_101_Source.wordsString(testCases[7]), 
                     HumanEval_101_Transformed.processText(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_101_Source.wordsString(testCases[8]), 
                     HumanEval_101_Transformed.processText(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_101_Source.wordsString(testCases[9]), 
                     HumanEval_101_Transformed.processText(testCases[9]));
    }
}