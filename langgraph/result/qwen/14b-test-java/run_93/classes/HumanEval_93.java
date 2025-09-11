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
        StringBuilder encodedMessage = new StringBuilder();
        
        for (char c : message.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                char replacedChar = (char) (c + 2);
                encodedMessage.append(replacedChar);
            } else {
                encodedMessage.append(c);
            }
        }
        
        return swapCase(encodedMessage.toString());
    }

    private static String swapCase(String text) {
        StringBuilder swappedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                swappedText.append(Character.toLowerCase(c));
            } else {
                swappedText.append(Character.toUpperCase(c));
            }
        }
        return swappedText.toString();
    }

    // Transformed Code
    public static String transformMessage(String inputText) {
        String vowelSet = "aeiouAEIOU";
        StringBuilder vowelMapping = new StringBuilder();
        for (char c : vowelSet.toCharArray()) {
            vowelMapping.append(c).append((char)(c + 2));
        }
        
        String modifiedText = swapCase(inputText);
        StringBuilder result = new StringBuilder();
        
        for (char charInText : modifiedText.toCharArray()) {
            int index = vowelMapping.indexOf(charInText);
            if (index != -1 && index % 2 == 0) {
                result.append(vowelMapping.charAt(index + 1));
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