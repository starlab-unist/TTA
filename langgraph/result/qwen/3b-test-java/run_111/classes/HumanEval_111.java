import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_111 {

    // Source Code
    static class HumanEval_111_Source {
        public static Map<String, Integer> histogram(String test) {
            Map<String, Integer> dict1 = new HashMap<>();
            String[] list1 = test.split(" ");
            int t = 0;

            for (String i : list1) {
                if (!i.isEmpty()) {
                    int count = dict1.getOrDefault(i, 0) + 1;
                    dict1.put(i, count);
                    t = Math.max(t, count);
                }
            }

            Map<String, Integer> result = new HashMap<>();
            for (Map.Entry<String, Integer> entry : dict1.entrySet()) {
                if (entry.getValue() == t) {
                    result.put(entry.getKey(), t);
                }
            }

            return result;
        }
    }

    // Transformed Code
    static class HumanEval_111_Transformed {
        public static Map<String, Integer> generateFrequencyMap(String inputString) {
            Map<String, Integer> frequencyDict = new HashMap<>();
            String[] wordList = inputString.split("\\s+");
            int maxCount = 0;

            for (String word : wordList) {
                if (!word.isEmpty()) {
                    int currentCount = frequencyDict.getOrDefault(word, 0) + 1;
                    frequencyDict.put(word, currentCount);
                    maxCount = Math.max(maxCount, currentCount);
                }
            }

            Map<String, Integer> result = new HashMap<>();
            for (Map.Entry<String, Integer> entry : frequencyDict.entrySet()) {
                if (entry.getValue() == maxCount) {
                    result.put(entry.getKey(), maxCount);
                }
            }

            return result;
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
        assertEquals(HumanEval_111_Source.histogram(testCases[0]), HumanEval_111_Transformed.generateFrequencyMap(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_111_Source.histogram(testCases[1]), HumanEval_111_Transformed.generateFrequencyMap(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_111_Source.histogram(testCases[2]), HumanEval_111_Transformed.generateFrequencyMap(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_111_Source.histogram(testCases[3]), HumanEval_111_Transformed.generateFrequencyMap(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_111_Source.histogram(testCases[4]), HumanEval_111_Transformed.generateFrequencyMap(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_111_Source.histogram(testCases[5]), HumanEval_111_Transformed.generateFrequencyMap(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_111_Source.histogram(testCases[6]), HumanEval_111_Transformed.generateFrequencyMap(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_111_Source.histogram(testCases[7]), HumanEval_111_Transformed.generateFrequencyMap(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_111_Source.histogram(testCases[8]), HumanEval_111_Transformed.generateFrequencyMap(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_111_Source.histogram(testCases[9]), HumanEval_111_Transformed.generateFrequencyMap(testCases[9]));
    }
}