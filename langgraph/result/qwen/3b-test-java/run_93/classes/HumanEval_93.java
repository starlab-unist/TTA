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
    public static String encode(String message) {
        String vowels = "aeiouAEIOU";
        java.util.Map<Character, Character> vowelsReplace = new java.util.HashMap<>();
        
        for (char i : vowels.toCharArray()) {
            vowelsReplace.put(i, (char) (i + 2));
        }
        
        message = message.toUpperCase();
        
        StringBuilder encodedMessage = new StringBuilder();
        
        for (char i : message.toCharArray()) {
            if (vowelsReplace.containsKey(i)) {
                encodedMessage.append(vowelsReplace.get(i));
            } else {
                encodedMessage.append(i);
            }
        }
        
        return encodedMessage.toString();
    }

    // Transformed Code
    public static String transformMessage(String inputText) {
        String vowelSet = "aeiouAEIOU";
        StringBuilder vowelMapping = new StringBuilder();
        for (int i = 0; i < vowelSet.length(); i++) {
            char originalChar = vowelSet.charAt(i);
            char newChar = (char) (originalChar + 2);
            vowelMapping.append(originalChar).append("=").append(newChar);
        }
        String modifiedText = inputText.toUpperCase();
        StringBuilder result = new StringBuilder();
        for (char charInText : modifiedText.toCharArray()) {
            int index = vowelMapping.indexOf("=" + charInText);
            if (index != -1) {
                // Find the character after '='
                char mappedChar = vowelMapping.charAt(index + 2); 
                result.append(mappedChar);
            } else {
                result.append(charInText);
            }
        }
        return result.toString();
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
        assertEquals(encode(testCases[0]), transformMessage(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(encode(testCases[1]), transformMessage(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(encode(testCases[2]), transformMessage(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(encode(testCases[3]), transformMessage(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(encode(testCases[4]), transformMessage(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(encode(testCases[5]), transformMessage(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(encode(testCases[6]), transformMessage(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(encode(testCases[7]), transformMessage(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(encode(testCases[8]), transformMessage(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(encode(testCases[9]), transformMessage(testCases[9]));
    }
}