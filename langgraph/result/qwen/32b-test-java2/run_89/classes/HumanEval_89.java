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
    static class HumanEval_89_Source {
        public String encrypt(String s) {
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
    }

    // Transformed Code
    static class HumanEval_89_Transformed {
        public String cipherText(String inputString) {
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
        assertEquals(new HumanEval_89_Source().encrypt(testCases[0]), 
                     new HumanEval_89_Transformed().cipherText(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_89_Source().encrypt(testCases[1]), 
                     new HumanEval_89_Transformed().cipherText(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_89_Source().encrypt(testCases[2]), 
                     new HumanEval_89_Transformed().cipherText(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_89_Source().encrypt(testCases[3]), 
                     new HumanEval_89_Transformed().cipherText(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_89_Source().encrypt(testCases[4]), 
                     new HumanEval_89_Transformed().cipherText(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_89_Source().encrypt(testCases[5]), 
                     new HumanEval_89_Transformed().cipherText(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_89_Source().encrypt(testCases[6]), 
                     new HumanEval_89_Transformed().cipherText(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_89_Source().encrypt(testCases[7]), 
                     new HumanEval_89_Transformed().cipherText(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_89_Source().encrypt(testCases[8]), 
                     new HumanEval_89_Transformed().cipherText(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_89_Source().encrypt(testCases[9]), 
                     new HumanEval_89_Transformed().cipherText(testCases[9]));
    }
}