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
    public static String findMax(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt((String x) -> -new HashSet<Character>(toCharacterList(x)).size())
                        .thenComparing(Comparator.naturalOrder()))
                .findFirst()
                .orElse(null);
    }

    // Transformed Code
    public static String determineLongestUniqueCharString(List<String> wordList) {
        Comparator<String> customSortKey = new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                int uniqueChars1 = new HashSet<Character>(toCharacterList(word1)).size();
                int uniqueChars2 = new HashSet<Character>(toCharacterList(word2)).size();
                
                if (uniqueChars1 != uniqueChars2) {
                    return Integer.compare(uniqueChars2, uniqueChars1);
                } else {
                    return word1.compareTo(word2);
                }
            }
        };
        
        Collections.sort(wordList, customSortKey);
        return wordList.get(0);
    }

    private static List<Character> toCharacterList(String s) {
        List<Character> characterList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characterList.add(c);
        }
        return characterList;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Arrays.asList("apple", "banana", "cherry")},
        {Arrays.asList("abc", "abcd", "abcde")},
        {Arrays.asList("aaaa", "bb", "c")},
        {Arrays.asList("hello", "world", "python")},
        {Arrays.asList("same", "size", "test")},
        {Arrays.asList("unique", "chars", "words")},
        {Arrays.asList("one", "two", "three")},
        {Arrays.asList("four", "five", "six")},
        {Arrays.asList("seven", "eight", "nine")},
        {Arrays.asList("ten", "eleven", "twelve")}
    };

    @Test
    public void test_0() {
        assertEquals(findMax((List<String>) testCases[0][0]), 
                     determineLongestUniqueCharString((List<String>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(findMax((List<String>) testCases[1][0]), 
                     determineLongestUniqueCharString((List<String>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(findMax((List<String>) testCases[2][0]), 
                     determineLongestUniqueCharString((List<String>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(findMax((List<String>) testCases[3][0]), 
                     determineLongestUniqueCharString((List<String>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(findMax((List<String>) testCases[4][0]), 
                     determineLongestUniqueCharString((List<String>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(findMax((List<String>) testCases[5][0]), 
                     determineLongestUniqueCharString((List<String>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(findMax((List<String>) testCases[6][0]), 
                     determineLongestUniqueCharString((List<String>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(findMax((List<String>) testCases[7][0]), 
                     determineLongestUniqueCharString((List<String>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(findMax((List<String>) testCases[8][0]), 
                     determineLongestUniqueCharString((List<String>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(findMax((List<String>) testCases[9][0]), 
                     determineLongestUniqueCharString((List<String>) testCases[9][0]));
    }
}