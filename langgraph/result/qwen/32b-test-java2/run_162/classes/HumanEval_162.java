import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_162 {

    // Source Code
    static class HumanEval_162_Source {
        public static String stringToMd5(String text) {
            if (text == null || text.isEmpty()) {
                return null;
            }
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] hashBytes = md.digest(text.getBytes(java.nio.charset.StandardCharsets.US_ASCII));
                StringBuilder sb = new StringBuilder();
                for (byte b : hashBytes) {
                    sb.append(String.format("%02x", b));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Transformed Code
    static class HumanEval_162_Transformed {
        public static String convertTextToHash(String inputString) {
            if (inputString == null || inputString.isEmpty()) {
                return null;
            }
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] encodedString = inputString.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
                byte[] hashBytes = md.digest(encodedString);
                StringBuilder sb = new StringBuilder();
                for (byte b : hashBytes) {
                    sb.append(String.format("%02x", b));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "Hello, World!",
        "OpenAI",
        "Python is fun!",
        "1234567890",
        "",
        "a",
        "MD5 hash",
        "unittest",
        "transformed code",
        "semantically equivalent"
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_162_Source.stringToMd5(testCases[0]), 
                     HumanEval_162_Transformed.convertTextToHash(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_162_Source.stringToMd5(testCases[1]), 
                     HumanEval_162_Transformed.convertTextToHash(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_162_Source.stringToMd5(testCases[2]), 
                     HumanEval_162_Transformed.convertTextToHash(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_162_Source.stringToMd5(testCases[3]), 
                     HumanEval_162_Transformed.convertTextToHash(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_162_Source.stringToMd5(testCases[4]), 
                     HumanEval_162_Transformed.convertTextToHash(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_162_Source.stringToMd5(testCases[5]), 
                     HumanEval_162_Transformed.convertTextToHash(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_162_Source.stringToMd5(testCases[6]), 
                     HumanEval_162_Transformed.convertTextToHash(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_162_Source.stringToMd5(testCases[7]), 
                     HumanEval_162_Transformed.convertTextToHash(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_162_Source.stringToMd5(testCases[8]), 
                     HumanEval_162_Transformed.convertTextToHash(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_162_Source.stringToMd5(testCases[9]), 
                     HumanEval_162_Transformed.convertTextToHash(testCases[9]));
    }
}