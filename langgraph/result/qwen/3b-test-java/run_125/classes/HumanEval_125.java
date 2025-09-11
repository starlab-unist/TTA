import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_125 {

    // Source Code
    public static String[] splitWords(String txt) {
        if (txt.contains(" ")) {
            return txt.split(" ");
        } else if (txt.contains(",")) {
            return txt.replace(',', ' ').split(" ");
        } else {
            int count = 0;
            for (char i : txt.toCharArray()) {
                if (Character.isLowerCase(i) && (i % 2 == 0)) {
                    count++;
                }
            }
            return new String[count];
        }
    }

    // Transformed Code
    public static List<String> extractAndCountWords(String inputText) {
        if (inputText.contains(" ")) {
            String[] wordList = inputText.split(" ");
            return Arrays.asList(wordList);
        } else if (inputText.contains(",")) {
            String[] wordList = inputText.replace(",", " ").split(" ");
            return Arrays.asList(wordList);
        } else {
            int count = 0;
            for (char c : inputText.toCharArray()) {
                if (Character.isLowerCase(c) && (c - 'a') % 2 == 0) {
                    count++;
                }
            }
            return Collections.singletonList(Integer.toString(count));
        }

        // Unreachable code
        // return Arrays.asList(wordList);
    }

    // Test Cases
    private static final String[] testCases = {
        "hello world",
        "apple,banana,cherry",
        "one,two three",
        "abcdefg",
        "hijklmno",
        "pqrstuvw",
        "xyz",
        "123456",
        "",
        "a,b,c,d,e,f,g,h,i,j"
    };

    @Test
    public void test_0() {
        assertEquals(Arrays.asList(splitWords(testCases[0])), extractAndCountWords(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(Arrays.asList(splitWords(testCases[1])), extractAndCountWords(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(Arrays.asList(splitWords(testCases[2])), extractAndCountWords(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(Arrays.asList(splitWords(testCases[3])), extractAndCountWords(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(Arrays.asList(splitWords(testCases[4])), extractAndCountWords(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(Arrays.asList(splitWords(testCases[5])), extractAndCountWords(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(Arrays.asList(splitWords(testCases[6])), extractAndCountWords(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(Arrays.asList(splitWords(testCases[7])), extractAndCountWords(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(Arrays.asList(splitWords(testCases[8])), extractAndCountWords(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(Arrays.asList(splitWords(testCases[9])), extractAndCountWords(testCases[9]));
    }
}