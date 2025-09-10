import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream; // Add import for Stream
import java.util.Arrays; // Add import for Arrays

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void histogram_vs_generateFrequencyMap(String inputText) {
        assertEquals(
            new HumanEval_111_Source().histogram(inputText), // Create an instance to call non-static method
            new HumanEval_111_Transformed().generateFrequencyMap(inputText) // Create an instance to call non-static method
        );
    }
}