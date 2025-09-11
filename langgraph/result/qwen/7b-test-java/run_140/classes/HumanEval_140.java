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
    static class HumanEval_140_Source {
        public static String fixSpaces(String text) {
            StringBuilder newText = new StringBuilder();
            int i = 0;
            int start = 0, end = 0;

            while (i < text.length()) {
                if (text.charAt(i) == ' ') {
                    end++;
                } else {
                    if (end - start > 2) {
                        newText.append('-').append(text.charAt(i));
                    } else if (end - start > 0) {
                        for (int j = 0; j < end - start; j++) {
                            newText.append('_');
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
                newText.append('-');
            } else if (end - start > 0) {
                for (int j = 0; j < end - start; j++) {
                    newText.append('_');
                }
            }

            return newText.toString();
        }
    }

    // Transformed Code
    static class HumanEval_140_Transformed {
        public static String fixSpaces(String text) {
            StringBuilder new_text = new StringBuilder();
            int i = 0;
            int start = 0, end = 0;
            while (i < text.length()) {
                if (text.charAt(i) == ' ') {
                    end++;
                } else {
                    int spaceCount = end - start;
                    if (spaceCount > 2) {
                        new_text.append('-').append(text.charAt(i));
                    } else if (spaceCount > 0) {
                        new_text.append("_".repeat(spaceCount)).append(text.charAt(i));
                    } else {
                        new_text.append(text.charAt(i));
                    }
                    start = i + 1;
                    end = i + 1;
                }
                i++;
            }
            int finalSpaceCount = end - start;
            if (finalSpaceCount > 2) {
                new_text.append('-');
            } else if (finalSpaceCount > 0) {
                new_text.append("_".repeat(finalSpaceCount));
            }
            return new_text.toString();
        }
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
        assertEquals(HumanEval_140_Source.fixSpaces(testCases[0]), HumanEval_140_Transformed.fixSpaces(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_140_Source.fixSpaces(testCases[1]), HumanEval_140_Transformed.fixSpaces(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_140_Source.fixSpaces(testCases[2]), HumanEval_140_Transformed.fixSpaces(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_140_Source.fixSpaces(testCases[3]), HumanEval_140_Transformed.fixSpaces(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_140_Source.fixSpaces(testCases[4]), HumanEval_140_Transformed.fixSpaces(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_140_Source.fixSpaces(testCases[5]), HumanEval_140_Transformed.fixSpaces(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_140_Source.fixSpaces(testCases[6]), HumanEval_140_Transformed.fixSpaces(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_140_Source.fixSpaces(testCases[7]), HumanEval_140_Transformed.fixSpaces(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_140_Source.fixSpaces(testCases[8]), HumanEval_140_Transformed.fixSpaces(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_140_Source.fixSpaces(testCases[9]), HumanEval_140_Transformed.fixSpaces(testCases[9]));
    }
}