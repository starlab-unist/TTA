import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_112 {

    // Source Code
    public static Pair<String, Boolean> reverseDelete(String s, String c) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!c.contains(String.valueOf(ch))) {
                sb.append(ch);
            }
        }
        String result = sb.toString();
        String reversed = new StringBuilder(result).reverse().toString();
        return new Pair<>(result, result.equals(reversed));
    }

    // Transformed Code
    public static Pair<String, Boolean> reverseDeleteTransformed(String inputString, String charsToRemove) {
        StringBuilder filteredStringBuilder = new StringBuilder();
        for (char character : inputString.toCharArray()) {
            if (!charsToRemove.contains(String.valueOf(character))) {
                filteredStringBuilder.append(character);
            }
        }
        String filteredString = filteredStringBuilder.toString();
        boolean isPalindrome = filteredString.equals(new StringBuilder(filteredString).reverse().toString());
        return new Pair<>(filteredString, isPalindrome);
    }

    // Helper class to return two values
    public static class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            return first.equals(pair.first) && second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            int result = first.hashCode();
            result = 31 * result + second.hashCode();
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

    @Test
    public void test_0() {
        assertEquals(reverseDelete(testCases[0][0], testCases[0][1]), 
                     reverseDeleteTransformed(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(reverseDelete(testCases[1][0], testCases[1][1]), 
                     reverseDeleteTransformed(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(reverseDelete(testCases[2][0], testCases[2][1]), 
                     reverseDeleteTransformed(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(reverseDelete(testCases[3][0], testCases[3][1]), 
                     reverseDeleteTransformed(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(reverseDelete(testCases[4][0], testCases[4][1]), 
                     reverseDeleteTransformed(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(reverseDelete(testCases[5][0], testCases[5][1]), 
                     reverseDeleteTransformed(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(reverseDelete(testCases[6][0], testCases[6][1]), 
                     reverseDeleteTransformed(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(reverseDelete(testCases[7][0], testCases[7][1]), 
                     reverseDeleteTransformed(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(reverseDelete(testCases[8][0], testCases[8][1]), 
                     reverseDeleteTransformed(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(reverseDelete(testCases[9][0], testCases[9][1]), 
                     reverseDeleteTransformed(testCases[9][0], testCases[9][1]));
    }
}