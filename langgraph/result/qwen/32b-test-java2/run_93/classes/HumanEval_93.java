import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_93 {

    // Source Code
    static class HumanEval_93_Source {
        public static String encode(String message) {
            String vowels = "aeiouAEIOU";
            Map<Character, Character> vowelsReplace = new HashMap<>();
            for (char i : vowels.toCharArray()) {
                vowelsReplace.put(i, (char) (i + 2));
            }
            StringBuilder encodedMessage = new StringBuilder();
            for (char i : message.toCharArray()) {
                char swappedChar = Character.isUpperCase(i) ? Character.toLowerCase(i) : Character.toUpperCase(i);
                encodedMessage.append(vowelsReplace.getOrDefault(swappedChar, swappedChar));
            }
            return encodedMessage.toString();
        }
    }

    // Transformed Code
    static class HumanEval_93_Transformed {
        public String transformMessage(String inputText) {
            String vowelSet = "aeiouAEIOU";
            StringBuilder result = new StringBuilder();

            for (char c : inputText.toCharArray()) {
                char mappedChar = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
                if (vowelSet.indexOf(mappedChar) != -1) {
                    mappedChar = (char) (mappedChar + 2);
                }
                result.append(mappedChar);
            }

            return result.toString();
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "Hello World",
        "Python Programming",
        "OpenAI",
        "encode",
        "AEIOUaeiou",
        "1234567890",
        "Symbols #$%^&*()",
        "Mixed CASE",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        ""
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_93_Source.encode(testCases[0]), 
                     new HumanEval_93_Transformed().transformMessage(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_93_Source.encode(testCases[1]), 
                     new HumanEval_93_Transformed().transformMessage(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_93_Source.encode(testCases[2]), 
                     new HumanEval_93_Transformed().transformMessage(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_93_Source.encode(testCases[3]), 
                     new HumanEval_93_Transformed().transformMessage(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_93_Source.encode(testCases[4]), 
                     new HumanEval_93_Transformed().transformMessage(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_93_Source.encode(testCases[5]), 
                     new HumanEval_93_Transformed().transformMessage(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_93_Source.encode(testCases[6]), 
                     new HumanEval_93_Transformed().transformMessage(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_93_Source.encode(testCases[7]), 
                     new HumanEval_93_Transformed().transformMessage(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_93_Source.encode(testCases[8]), 
                     new HumanEval_93_Transformed().transformMessage(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_93_Source.encode(testCases[9]), 
                     new HumanEval_93_Transformed().transformMessage(testCases[9]));
    }
}