import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_93 {

    // Source Code
    static class HumanEval_93_Source {
        public static String encode(String message) {
            String vowels = "aeiouAEIOU";
            Map<Character, Character> vowelsReplace = new HashMap<>();
            for (char i : vowels.toCharArray()) {
                vowelsReplace.put(i, (char)(i + 2));
            }
            StringBuilder encodedMessage = new StringBuilder();
            for (char i : message.toCharArray()) {
                if (vowels.indexOf(i) != -1) {
                    encodedMessage.append(vowelsReplace.get(i));
                } else {
                    encodedMessage.append(i);
                }
            }
            return encodedMessage.toString().toUpperCase();
        }
    }

    // Transformed Code
    static class HumanEval_93_Transformed {
        public static String transformMessage(String inputText) {
            String vowelSet = "aeiouAEIOU";
            StringBuilder vowelMappingBuilder = new StringBuilder();
            for (char c : vowelSet.toCharArray()) {
                vowelMappingBuilder.append((char) (c + 2));
            }
            String vowelMapping = vowelMappingBuilder.toString();

            StringBuilder resultBuilder = new StringBuilder();
            for (char c : inputText.toCharArray()) {
                int index = vowelSet.indexOf(c);
                if (index != -1) {
                    resultBuilder.append(vowelMapping.charAt(index));
                } else {
                    resultBuilder.append(c);
                }
            }

            return resultBuilder.toString().toUpperCase().toLowerCase(); // This will always convert to lowercase
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
                     HumanEval_93_Transformed.transformMessage(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_93_Source.encode(testCases[1]), 
                     HumanEval_93_Transformed.transformMessage(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_93_Source.encode(testCases[2]), 
                     HumanEval_93_Transformed.transformMessage(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_93_Source.encode(testCases[3]), 
                     HumanEval_93_Transformed.transformMessage(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_93_Source.encode(testCases[4]), 
                     HumanEval_93_Transformed.transformMessage(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_93_Source.encode(testCases[5]), 
                     HumanEval_93_Transformed.transformMessage(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_93_Source.encode(testCases[6]), 
                     HumanEval_93_Transformed.transformMessage(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_93_Source.encode(testCases[7]), 
                     HumanEval_93_Transformed.transformMessage(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_93_Source.encode(testCases[8]), 
                     HumanEval_93_Transformed.transformMessage(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_93_Source.encode(testCases[9]), 
                     HumanEval_93_Transformed.transformMessage(testCases[9]));
    }
}