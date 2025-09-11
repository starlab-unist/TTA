import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_140 {

    // Source Code
    public static String fixSpaces(String text) {
        StringBuilder newText = new StringBuilder();
        int i = 0;
        int start = 0, end = 0;
        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                end += 1;
            } else {
                if (end - start > 2) {
                    newText.append("-").append(text.charAt(i));
                } else if (end - start > 0) {
                    for (int j = 0; j < end - start; j++) {
                        newText.append("_");
                    }
                    newText.append(text.charAt(i));
                } else {
                    newText.append(text.charAt(i));
                }
                start = i + 1;
                end = i + 1;
            }
            i++;
        }
        if (end - start > 2) {
            newText.append("-");
        } else if (end - start > 0) {
            newText.append("_");
        }
        return newText.toString();
    }

    // Transformed Code
    public String adjustWhitespace(String inputString) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        int begin = 0, finish = 0;
        while (index < inputString.length()) {
            if (inputString.charAt(index) == ' ') {
                finish++;
            } else {
                int spaceCount = finish - begin;
                if (spaceCount > 2) {
                    result.append("-").append(inputString.charAt(index));
                } else if (spaceCount > 0) {
                    for (int i = 0; i < spaceCount; i++) {
                        result.append("_");
                    }
                    result.append(inputString.charAt(index));
                } else {
                    result.append(inputString.charAt(index));
                }
                begin = index + 1;
                finish = index + 1;
            }
            index++;
        }
        int finalSpaceCount = finish - begin;
        if (finalSpaceCount > 2) {
            result.append("-");
        } else if (finalSpaceCount > 0) {
            result.append("_");
        }
        return result.toString();
    }

    // Test Cases
    private static final String[] testCases = {
        "Hello   world",
        "This is  a test",
        "Multiple     spaces",
        "NoSpacesHere",
        " ",
        "  ",
        "   ",
        "    ",
        "a b c d e f g h i j",
        "OpenAI     Inc"
    };

    @Test
    public void test_0() {
        assertEquals(fixSpaces(testCases[0]), new HumanEval_140().adjustWhitespace(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(fixSpaces(testCases[1]), new HumanEval_140().adjustWhitespace(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(fixSpaces(testCases[2]), new HumanEval_140().adjustWhitespace(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(fixSpaces(testCases[3]), new HumanEval_140().adjustWhitespace(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(fixSpaces(testCases[4]), new HumanEval_140().adjustWhitespace(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(fixSpaces(testCases[5]), new HumanEval_140().adjustWhitespace(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(fixSpaces(testCases[6]), new HumanEval_140().adjustWhitespace(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(fixSpaces(testCases[7]), new HumanEval_140().adjustWhitespace(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(fixSpaces(testCases[8]), new HumanEval_140().adjustWhitespace(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(fixSpaces(testCases[9]), new HumanEval_140().adjustWhitespace(testCases[9]));
    }
}