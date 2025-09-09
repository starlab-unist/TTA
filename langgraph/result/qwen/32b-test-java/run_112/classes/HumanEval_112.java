import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_112 {

    // Source Code
    static class HumanEval_112_Source {
        public static java.util.AbstractMap.SimpleEntry<String, Boolean> reverseDelete(String s, String c) {
            StringBuilder filtered = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (c.indexOf(ch) == -1) {
                    filtered.append(ch);
                }
            }
            String result = filtered.toString();
            String reversed = filtered.reverse().toString();
            return new java.util.AbstractMap.SimpleEntry<>(result, result.equals(reversed));
        }
    }

    // Transformed Code
    static class HumanEval_112_Transformed {
        public static Pair<String, Boolean> filterAndCheckPalindrome(String inputString, String charsToRemove) {
            StringBuilder filteredString = new StringBuilder();
            for (char character : inputString.toCharArray()) {
                if (charsToRemove.indexOf(character) == -1) {
                    filteredString.append(character);
                }
            }
            boolean isPalindrome = filteredString.toString().equals(filteredString.reverse().toString());
            return new Pair<>(filteredString.toString(), isPalindrome);
        }
    }

    // Custom Pair class
    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (!key.equals(pair.key)) return false;
            return value.equals(pair.value);
        }

        @Override
        public int hashCode() {
            int result = key.hashCode();
            result = 31 * result + value.hashCode();
            return result;
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"abcba", "x"},
        {"abccba", "x"},
        {"hello", "aeiou"},
        {"racecar", ""},
        {"palindrome", "xyz"},
        {"", "a"},
        {"aabbcc", "abc"},
        {"rotor", "r"},
        {"deified", "d"},
        {"noon", "n"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Source Code vs Transformed Code")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void reverseDelete_vs_filterAndCheckPalindrome(String inputString, String charsToRemove) {
        java.util.AbstractMap.SimpleEntry<String, Boolean> sourceResult = HumanEval_112_Source.reverseDelete(inputString, charsToRemove);
        Pair<String, Boolean> transformedResult = HumanEval_112_Transformed.filterAndCheckPalindrome(inputString, charsToRemove);

        assertEquals(
            new Pair<>(sourceResult.getKey(), sourceResult.getValue()),
            transformedResult
        );
    }
}