import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_158 {

    // Source Code
    static class HumanEval_158_Source {
        public static String findMax(List<String> words) {
            return Collections.max(words, Comparator.comparing((String x) -> -new java.util.HashSet<Character>(toCharacterList(x)).size()).thenComparing(Comparator.naturalOrder()));
        }

        private static List<Character> toCharacterList(String s) {
            List<Character> characterList = new java.util.ArrayList<>();
            for (char c : s.toCharArray()) {
                characterList.add(c);
            }
            return characterList;
        }
    }

    // Transformed Code
    static class HumanEval_158_Transformed {
        public static String determineLongestUniqueCharString(List<String> wordList) {
            Comparator<String> customSortKey = (word1, word2) -> {
                int uniqueCharsCount1 = new HashSet<>(Arrays.asList(word1.split(""))).size();
                int uniqueCharsCount2 = new HashSet<>(Arrays.asList(word2.split(""))).size();
                if (uniqueCharsCount1 != uniqueCharsCount2) {
                    return Integer.compare(uniqueCharsCount2, uniqueCharsCount1);
                } else {
                    return word1.compareTo(word2);
                }
            };

            List<String> sortedWords = new ArrayList<>(wordList);
            Collections.sort(sortedWords, customSortKey);
            return sortedWords.get(0);
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"apple", "banana", "cherry"},
        {"abc", "abcd", "abcde"},
        {"aaaa", "bb", "c"},
        {"hello", "world", "python"},
        {"same", "size", "test"},
        {"unique", "chars", "words"},
        {"one", "two", "three"},
        {"four", "five", "six"},
        {"seven", "eight", "nine"},
        {"ten", "eleven", "twelve"}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_158_Source.findMax(Arrays.asList(testCases[0])), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString(Arrays.asList(testCases[0])));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_158_Source.findMax(Arrays.asList(testCases[1])), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString(Arrays.asList(testCases[1])));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_158_Source.findMax(Arrays.asList(testCases[2])), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString(Arrays.asList(testCases[2])));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_158_Source.findMax(Arrays.asList(testCases[3])), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString(Arrays.asList(testCases[3])));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_158_Source.findMax(Arrays.asList(testCases[4])), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString(Arrays.asList(testCases[4])));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_158_Source.findMax(Arrays.asList(testCases[5])), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString(Arrays.asList(testCases[5])));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_158_Source.findMax(Arrays.asList(testCases[6])), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString(Arrays.asList(testCases[6])));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_158_Source.findMax(Arrays.asList(testCases[7])), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString(Arrays.asList(testCases[7])));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_158_Source.findMax(Arrays.asList(testCases[8])), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString(Arrays.asList(testCases[8])));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_158_Source.findMax(Arrays.asList(testCases[9])), 
                     HumanEval_158_Transformed.determineLongestUniqueCharString(Arrays.asList(testCases[9])));
    }
}