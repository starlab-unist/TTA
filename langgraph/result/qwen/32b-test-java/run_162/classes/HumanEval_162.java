import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

public class HumanEval_162 {

    // Source Code
    static class HumanEval_162 {
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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Testing equivalence of stringToMd5 and convertTextToHash")
    @ParameterizedTest(name = "{index} => input={0}")
    @MethodSource("provideTestCases")
    void testEquivalence(String inputText) {
        assertEquals(
            HumanEval_162.stringToMd5(inputText),
            HumanEval_162_Transformed.convertTextToHash(inputText)
        );
    }
}