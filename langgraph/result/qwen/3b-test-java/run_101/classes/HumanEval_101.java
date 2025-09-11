import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_101 {

    // Source Code
    public static String[] wordsString(String s) {
        if (s == null || s.isEmpty()) {
            return new String[0];
        }

        StringBuilder sList = new StringBuilder();

        for (char letter : s.toCharArray()) {
            if (letter == ',') {
                sList.append(' ');
            } else {
                sList.append(letter);
            }
        }

        sList = new StringBuilder(sList.toString());
        return sList.toString().split("\\s+");
    }

    // Transformed Code
    public static String[] processText(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return new String[0];
        }

        StringBuilder processedChars = new StringBuilder();

        int index = 0;
        while (index < inputString.length()) {
            char charAt = inputString.charAt(index);
            if (charAt == ',') {
                processedChars.append(' ');
            } else {
                processedChars.append(charAt);
            }
            index++;
        }

        String processedString = processedChars.toString();
        return processedString.split("\\s+");
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
        assertEquals(Arrays.toString(wordsString(testCases[0])), 
                     Arrays.toString(processText(testCases[0])));
    }

    @Test
    public void test_1() {
        assertEquals(Arrays.toString(wordsString(testCases[1])), 
                     Arrays.toString(processText(testCases[1])));
    }

    @Test
    public void test_2() {
        assertEquals(Arrays.toString(wordsString(testCases[2])), 
                     Arrays.toString(processText(testCases[2])));
    }

    @Test
    public void test_3() {
        assertEquals(Arrays.toString(wordsString(testCases[3])), 
                     Arrays.toString(processText(testCases[3])));
    }

    @Test
    public void test_4() {
        assertEquals(Arrays.toString(wordsString(testCases[4])), 
                     Arrays.toString(processText(testCases[4])));
    }

    @Test
    public void test_5() {
        assertEquals(Arrays.toString(wordsString(testCases[5])), 
                     Arrays.toString(processText(testCases[5])));
    }

    @Test
    public void test_6() {
        assertEquals(Arrays.toString(wordsString(testCases[6])), 
                     Arrays.toString(processText(testCases[6])));
    }

    @Test
    public void test_7() {
        assertEquals(Arrays.toString(wordsString(testCases[7])), 
                     Arrays.toString(processText(testCases[7])));
    }

    @Test
    public void test_8() {
        assertEquals(Arrays.toString(wordsString(testCases[8])), 
                     Arrays.toString(processText(testCases[8])));
    }

    @Test
    public void test_9() {
        assertEquals(Arrays.toString(wordsString(testCases[9])), 
                     Arrays.toString(processText(testCases[9])));
    }
}