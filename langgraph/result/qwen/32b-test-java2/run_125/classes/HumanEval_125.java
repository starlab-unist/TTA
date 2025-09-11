import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_125 {

    // Source Code
    public static List<String> splitWords(String txt) {
        if (txt.contains(" ")) {
            return List.of(txt.split("\\s+"));
        } else if (txt.contains(",")) {
            return List.of(txt.replace(',', ' ').split("\\s+"));
        } else {
            int count = 0;
            for (char c : txt.toCharArray()) {
                if (Character.isLowerCase(c) && c % 2 == 0) {
                    count++;
                }
            }
            return List.of(String.valueOf(count));
        }
    }

    // Transformed Code
    public List<String> extract_and_count_words(String input_text) {
        if (input_text.contains(" ")) {
            return List.of(input_text.split("\\s+"));
        } else if (input_text.contains(",")) {
            String cleanedText = input_text.replace(',', ' ');
            return List.of(cleanedText.split("\\s+"));
        } else {
            int count = 0;
            for (char c : input_text.toCharArray()) {
                if (Character.isLowerCase(c) && ((int) c) % 2 == 0) {
                    count++;
                }
            }
            return List.of(String.valueOf(count));
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
        assertEquals(HumanEval_125.splitWords(testCases[0]), 
                     new HumanEval_125().extract_and_count_words(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_125.splitWords(testCases[1]), 
                     new HumanEval_125().extract_and_count_words(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_125.splitWords(testCases[2]), 
                     new HumanEval_125().extract_and_count_words(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_125.splitWords(testCases[3]), 
                     new HumanEval_125().extract_and_count_words(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_125.splitWords(testCases[4]), 
                     new HumanEval_125().extract_and_count_words(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_125.splitWords(testCases[5]), 
                     new HumanEval_125().extract_and_count_words(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_125.splitWords(testCases[6]), 
                     new HumanEval_125().extract_and_count_words(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_125.splitWords(testCases[7]), 
                     new HumanEval_125().extract_and_count_words(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_125.splitWords(testCases[8]), 
                     new HumanEval_125().extract_and_count_words(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_125.splitWords(testCases[9]), 
                     new HumanEval_125().extract_and_count_words(testCases[9]));
    }
}