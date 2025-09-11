import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_11 {

    // Source Code
    public static String stringXOR(String a, String b) {
        StringBuilder result = new StringBuilder();
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            char x = a.charAt(i);
            char y = b.charAt(i);
            result.append(x == y ? '0' : '1');
        }
        return result.toString();
    }

    // Transformed Code
    public static String binaryStringDifference(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < Math.min(str1.length(), str2.length())) { // Adjusted to handle different length strings
            result.append(bitDiff(str1.charAt(index), str2.charAt(index)));
            index++;
        }
        return result.toString();
    }

    private static char bitDiff(char c1, char c2) {
        return c1 == c2 ? '0' : '1';
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(stringXOR("1101", "1001"), binaryStringDifference("1101", "1001"));
    }

    @Test
    public void test_1() {
        assertEquals(stringXOR("1111", "0000"), binaryStringDifference("1111", "0000"));
    }

    @Test
    public void test_2() {
        assertEquals(stringXOR("0000", "0000"), binaryStringDifference("0000", "0000"));
    }

    @Test
    public void test_3() {
        assertEquals(stringXOR("101010", "010101"), binaryStringDifference("101010", "010101"));
    }

    @Test
    public void test_4() {
        assertEquals(stringXOR("111000", "111000"), binaryStringDifference("111000", "111000"));
    }

    @Test
    public void test_5() {
        assertEquals(stringXOR("110011", "001100"), binaryStringDifference("110011", "001100"));
    }

    @Test
    public void test_6() {
        assertEquals(stringXOR("1", "1"), binaryStringDifference("1", "1"));
    }

    @Test
    public void test_7() {
        assertEquals(stringXOR("0", "0"), binaryStringDifference("0", "0"));
    }

    @Test
    public void test_8() {
        assertEquals(stringXOR("10", "01"), binaryStringDifference("10", "01"));
    }

    @Test
    public void test_9() {
        assertEquals(stringXOR("11111111", "00000000"), binaryStringDifference("11111111", "00000000"));
    }
}