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
            i += 1;
        }
        if (end - start > 2) {
            newText.append("-");
        } else if (end - start > 0) {
            newText.append("_");
        }
        return newText.toString();
    }

    // Transformed Code
    public static String adjust_whitespace(String input_string) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        int begin = 0, finish = 0;
        while (index < input_string.length()) {
            if (input_string.charAt(index) == ' ') {
                finish += 1;
            } else {
                int space_count = finish - begin;
                if (space_count > 2) {
                    result.append("-").append(input_string.charAt(index));
                } else if (space_count > 0) {
                    for (int i = 0; i < space_count; i++) {
                        result.append("_");
                    }
                    result.append(input_string.charAt(index));
                } else {
                    result.append(input_string.charAt(index));
                }
                begin = index + 1;
                finish = index + 1;
            }
            index += 1;
        }
        int final_space_count = finish - begin;
        if (final_space_count > 2) {
            result.append("-");
        } else if (final_space_count > 0) {
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
        assertEquals(fixSpaces(testCases[0]), adjust_whitespace(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(fixSpaces(testCases[1]), adjust_whitespace(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(fixSpaces(testCases[2]), adjust_whitespace(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(fixSpaces(testCases[3]), adjust_whitespace(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(fixSpaces(testCases[4]), adjust_whitespace(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(fixSpaces(testCases[5]), adjust_whitespace(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(fixSpaces(testCases[6]), adjust_whitespace(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(fixSpaces(testCases[7]), adjust_whitespace(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(fixSpaces(testCases[8]), adjust_whitespace(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(fixSpaces(testCases[9]), adjust_whitespace(testCases[9]));
    }
}