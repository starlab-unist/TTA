import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

public class HumanEval_162 {

    // Original Implementation
    public static class OriginalImpl {
        public static String stringToMD5(String text) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] hashBytes = md.digest(text.getBytes(StandardCharsets.US_ASCII));
                StringBuilder hexString = new StringBuilder();
                for (byte b : hashBytes) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                return hexString.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Transformed Implementation
    public static class TransformedImpl {
        public static String convertTextToHash(String inputString) {
            if (inputString == null || inputString.isEmpty()) {
                return null;
            }

            try {
                // Encode the input string to ASCII bytes
                byte[] encodedBytes = inputString.getBytes(StandardCharsets.US_ASCII);

                // Create a MessageDigest instance for MD5
                MessageDigest md = MessageDigest.getInstance("MD5");

                // Compute the hash
                byte[] hashBytes = md.digest(encodedBytes);

                // Convert the hash bytes to a hexadecimal string
                StringBuilder hexString = new StringBuilder();
                for (byte b : hashBytes) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) {
                        hexString.append('0');
                    }
                    hexString.append(hex);
                }

                return hexString.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("MD5 algorithm not found", e);
            }
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of("Hello, World!"),
            Arguments.of("OpenAI"),
            Arguments.of("Python is fun!"),
            Arguments.of("1234567890"),
            Arguments.of(""),
            Arguments.of("a"),
            Arguments.of("MD5 hash"),
            Arguments.of("unittest"),
            Arguments.of("transformed code"),
            Arguments.of("semantically equivalent")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testMD5Hash(String input) {
        assertEquals(OriginalImpl.stringToMD5(input), TransformedImpl.convertTextToHash(input));
    }
}