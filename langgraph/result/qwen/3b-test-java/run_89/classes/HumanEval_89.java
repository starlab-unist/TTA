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
            if (d.indexOf(c) != -1) {
                int index = (d.indexOf(c) + 2 * 2) % 26;
                out.append(d.charAt(index));
            } else {
                out.append(c);
            }
        }
        
        return out.toString();
    }

    // Transformed Code
    public static String cipherText(String inputString) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        
        for (char character : inputString.toCharArray()) {
            if (alphabet.indexOf(character) != -1) {
                int newIndex = (alphabet.indexOf(character) + 4) % 26;
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
        assertEquals(encrypt(testCases[0]), cipherText(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(encrypt(testCases[1]), cipherText(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(encrypt(testCases[2]), cipherText(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(encrypt(testCases[3]), cipherText(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(encrypt(testCases[4]), cipherText(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(encrypt(testCases[5]), cipherText(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(encrypt(testCases[6]), cipherText(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(encrypt(testCases[7]), cipherText(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(encrypt(testCases[8]), cipherText(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(encrypt(testCases[9]), cipherText(testCases[9]));
    }
}