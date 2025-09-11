import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_111 {

    // Source Code
    public static Map<String, Integer> histogram(String test) {
        Map<String, Integer> dict1 = new HashMap<>();
        String[] list1 = test.split(" ");
        int t = 0;

        for (String i : list1) {
            if (list1.length > 0 && list1[0].equals(i)) {
                continue;
            }
            int count = 0;
            for (String j : list1) {
                if (i.equals(j)) {
                    count++;
                }
            }
            if (count > t && !i.isEmpty()) {
                t = count;
            }
        }

        if (t > 0) {
            for (String i : list1) {
                if (i.equals("") || dict1.containsKey(i)) {
                    continue;
                }
                int count = 0;
                for (String j : list1) {
                    if (i.equals(j)) {
                        count++;
                    }
                }
                if (count == t) {
                    dict1.put(i, t);
                }
            }
        }

        return dict1;
    }

    // Transformed Code
    public static Map<String, Integer> generateFrequencyMap(String inputString) {
        Map<String, Integer> frequencyDict = new HashMap<>();
        String[] wordList = inputString.split("\\s+");
        int maxCount = 0;

        for (String word : wordList) {
            int currentCount = 0;
            for (String w : wordList) {
                if (w.equals(word)) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount && !word.isEmpty()) {
                maxCount = currentCount;
            }
        }

        if (maxCount > 0) {
            for (String word : wordList) {
                if (wordList.length - 1 - word.lastIndexOf(word) == maxCount) {
                    frequencyDict.put(word, maxCount);
                }
            }
        }

        return frequencyDict;
    }

    // Test Cases
    private static final String[] testCases = {
        "apple apple banana",
        "one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty",
        "a a a b b c",
        "hello world hello",
        "test test test test",
        "unique words only here",
        "repeated repeated repeated repeated",
        "no no no no no no no",
        "singleword",
        ""
    };

    @Test
    public void test_0() {
        assertEquals(histogram(testCases[0]), generateFrequencyMap(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(histogram(testCases[1]), generateFrequencyMap(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(histogram(testCases[2]), generateFrequencyMap(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(histogram(testCases[3]), generateFrequencyMap(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(histogram(testCases[4]), generateFrequencyMap(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(histogram(testCases[5]), generateFrequencyMap(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(histogram(testCases[6]), generateFrequencyMap(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(histogram(testCases[7]), generateFrequencyMap(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(histogram(testCases[8]), generateFrequencyMap(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(histogram(testCases[9]), generateFrequencyMap(testCases[9]));
    }
}