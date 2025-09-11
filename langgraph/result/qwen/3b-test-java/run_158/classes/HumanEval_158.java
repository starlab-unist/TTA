import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_158 {

    // Source Code
    static class HumanEval_158_Source {
        public static String findMax(String[] words) {
            return Arrays.stream(words)
                    .sorted(Comparator.comparingInt(word -> -word.length())
                            .thenComparing(word -> word))
                    .findFirst()
                    .orElse(null);
        }
    }

    // Transformed Code
    static class HumanEval_158_Transformed {
        public static String determineLongestUniqueCharString(String[] words) {
            // Define a custom comparator to sort words based on the number of unique characters and lexicographical order
            java.util.Comparator<String> customSortKey = (word1, word2) -> {
                int uniqueCount1 = word1.chars().distinct().count();
                int uniqueCount2 = word2.chars().distinct().count();
                
                if (uniqueCount1 != uniqueCount2) {
                    return Integer.compare(uniqueCount2, uniqueCount1); // Descending order of unique characters
                } else {
                    return word1.compareTo(word2); // Lexicographical order
                }
            };

            // Sort the words using the custom comparator
            java.util.Arrays.sort(words, customSortKey);

            // Return the first word in the sorted list, which will be the longest with unique characters
            return words[0];
        }

        // Main method for testing
        public static void main(String[] args) {
            String[] words = {"apple", "banana", "cherry", "date"};
            System.out.println(determineLongestUniqueCharString(words)); // Output: "banana"
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new String[]{"apple", "banana", "cherry"}},
        {new String[]{"abc", "abcd", "abcde"}},
        {new String[]{"aaaa", "bb", "c"}},
        {new String[]{"hello", "world", "python"}},
        {new String[]{"same", "size", "test"}},
        {new String[]{"unique", "chars", "words"}},
        {new String[]{"one", "two", "three"}},
        {new String[]{"four", "five", "six"}},
        {new String[]{"seven", "eight", "nine"}},
        {new String[]{"ten", "eleven", "twelve"}}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_158_Source.findMax((String[]) testCases[0][0]), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString((String[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_158_Source.findMax((String[]) testCases[1][0]), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString((String[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_158_Source.findMax((String[]) testCases[2][0]), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString((String[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_158_Source.findMax((String[]) testCases[3][0]), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString((String[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_158_Source.findMax((String[]) testCases[4][0]), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString((String[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_158_Source.findMax((String[]) testCases[5][0]), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString((String[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_158_Source.findMax((String[]) testCases[6][0]), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString((String[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_158_Source.findMax((String[]) testCases[7][0]), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString((String[]) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_158_Source.findMax((String[]) testCases[8][0]), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString((String[]) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_158_Source.findMax((String[]) testCases[9][0]), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString((String[]) testCases[9][0]));
    }
}