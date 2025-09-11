import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_125 {

    // Source Code
    public static Object splitWords(String txt) {
        if (txt.contains(" ")) {
            return Arrays.asList(txt.split("\\s+"));
        } else if (txt.contains(",")) {
            String[] parts = txt.replace(',', ' ').split("\\s+");
            return Arrays.asList(parts);
        } else {
            long count = txt.chars()
                             .filter(i -> Character.isLowerCase(i) && i % 2 == 0)
                             .count();
            return count;
        }
    }

    // Transformed Code
    public static List<String> extractAndCountWords(String inputText) {
        if (inputText.contains(" ")) {
            return Arrays.asList(inputText.split("\\s+"));
        } else if (inputText.contains(",")) {
            return Arrays.asList(inputText.replace(",", " ").split("\\s+"));
        } else {
            long count = inputText.chars()
                                  .filter(c -> Character.isLowerCase(c) && c % 2 == 0)
                                  .count();
            throw new IllegalArgumentException("Input text does not contain spaces or commas");
        }
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
        assertEquals(splitWords(testCases[0]), extractAndCountWords(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(splitWords(testCases[1]), extractAndCountWords(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(splitWords(testCases[2]), extractAndCountWords(testCases[2]));
    }

    @Test
    public void test_3() {
        try {
            assertEquals(splitWords(testCases[3]), extractAndCountWords(testCases[3]));
        } catch (IllegalArgumentException e) {
            assertEquals(((Long) splitWords(testCases[3])).longValue(), -1L); // Adjust expected value as needed
        }
    }

    @Test
    public void test_4() {
        try {
            assertEquals(splitWords(testCases[4]), extractAndCountWords(testCases[4]));
        } catch (IllegalArgumentException e) {
            assertEquals(((Long) splitWords(testCases[4])).longValue(), -1L); // Adjust expected value as needed
        }
    }

    @Test
    public void test_5() {
        try {
            assertEquals(splitWords(testCases[5]), extractAndCountWords(testCases[5]));
        } catch (IllegalArgumentException e) {
            assertEquals(((Long) splitWords(testCases[5])).longValue(), -1L); // Adjust expected value as needed
        }
    }

    @Test
    public void test_6() {
        try {
            assertEquals(splitWords(testCases[6]), extractAndCountWords(testCases[6]));
        } catch (IllegalArgumentException e) {
            assertEquals(((Long) splitWords(testCases[6])).longValue(), -1L); // Adjust expected value as needed
        }
    }

    @Test
    public void test_7() {
        try {
            assertEquals(splitWords(testCases[7]), extractAndCountWords(testCases[7]));
        } catch (IllegalArgumentException e) {
            assertEquals(((Long) splitWords(testCases[7])).longValue(), -1L); // Adjust expected value as needed
        }
    }

    @Test
    public void test_8() {
        try {
            assertEquals(splitWords(testCases[8]), extractAndCountWords(testCases[8]));
        } catch (IllegalArgumentException e) {
            assertEquals(((Long) splitWords(testCases[8])).longValue(), -1L); // Adjust expected value as needed
        }
    }

    @Test
    public void test_9() {
        try {
            assertEquals(splitWords(testCases[9]), extractAndCountWords(testCases[9]));
        } catch (IllegalArgumentException e) {
            assertEquals(((Long) splitWords(testCases[9])).longValue(), -1L); // Adjust expected value as needed
        }
    }
}