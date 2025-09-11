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
    static class HumanEval_111_Source {
        public Map<String, Integer> histogram(String test) {
            Map<String, Integer> dict1 = new HashMap<>();
            String[] list1 = test.split(" ");
            int t = 0;

            for (String i : list1) {
                if (!i.isEmpty() && countOccurrences(list1, i) > t) {
                    t = countOccurrences(list1, i);
                }
            }
            if (t > 0) {
                for (String i : list1) {
                    if (countOccurrences(list1, i) == t) {
                        dict1.put(i, t);
                    }
                }
            }
            return dict1;
        }

        private int countOccurrences(String[] array, String value) {
            int count = 0;
            for (String element : array) {
                if (element.equals(value)) {
                    count++;
                }
            }
            return count;
        }
    }

    // Transformed Code
    static class HumanEval_111_Transformed {

        public Map<String, Integer> generateFrequencyMap(String inputString) {
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
                    int count = 0;
                    for (String w : wordList) {
                        if (w.equals(word)) {
                            count++;
                        }
                    }
                    if (count == maxCount) {
                        frequencyDict.put(word, maxCount);
                    }
                }
            }

            return frequencyDict;
        }
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
        assertEquals(new HumanEval_111_Source().histogram(testCases[0]), 
                     new HumanEval_111_Transformed().generateFrequencyMap(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_111_Source().histogram(testCases[1]), 
                     new HumanEval_111_Transformed().generateFrequencyMap(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_111_Source().histogram(testCases[2]), 
                     new HumanEval_111_Transformed().generateFrequencyMap(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_111_Source().histogram(testCases[3]), 
                     new HumanEval_111_Transformed().generateFrequencyMap(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_111_Source().histogram(testCases[4]), 
                     new HumanEval_111_Transformed().generateFrequencyMap(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_111_Source().histogram(testCases[5]), 
                     new HumanEval_111_Transformed().generateFrequencyMap(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_111_Source().histogram(testCases[6]), 
                     new HumanEval_111_Transformed().generateFrequencyMap(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_111_Source().histogram(testCases[7]), 
                     new HumanEval_111_Transformed().generateFrequencyMap(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_111_Source().histogram(testCases[8]), 
                     new HumanEval_111_Transformed().generateFrequencyMap(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_111_Source().histogram(testCases[9]), 
                     new HumanEval_111_Transformed().generateFrequencyMap(testCases[9]));
    }
}