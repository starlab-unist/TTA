import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_89 {

    // Source Code
    public static String encrypt(String s) {
        String d = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder out = new StringBuilder();
        for (char c : s.toCharArray()) {
            int index = d.indexOf(c);
            if (index != -1) {
                out.append(d.charAt((index + 2 * 2) % 26));
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    // Transformed Code
    public static String cipher_text(String input_string) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for (char character : input_string.toCharArray()) {
            int index = alphabet.indexOf(character);
            if (index != -1) {
                int newIndex = (index + 4) % 26;
                result.append(alphabet.charAt(newIndex));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    // Test Cases
    private static final String[] testCases = {
        "hello",
        "world",
        "abcxyz",
        "python",
        "12345",
        "!@#$%",
        "encrypt this string",
        "a quick brown fox jumps over the lazy dog",
        "the quick brown fox jumps over the lazy dog",
        "abcdefghijklmnopqrstuvwxyz"
    };

    @Test
    public void test_0() {
        assertEquals(encrypt(testCases[0]), cipher_text(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(encrypt(testCases[1]), cipher_text(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(encrypt(testCases[2]), cipher_text(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(encrypt(testCases[3]), cipher_text(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(encrypt(testCases[4]), cipher_text(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(encrypt(testCases[5]), cipher_text(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(encrypt(testCases[6]), cipher_text(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(encrypt(testCases[7]), cipher_text(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(encrypt(testCases[8]), cipher_text(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(encrypt(testCases[9]), cipher_text(testCases[9]));
    }
}