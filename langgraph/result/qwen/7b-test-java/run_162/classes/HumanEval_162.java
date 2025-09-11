import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_162 {

    // Source Code
    static class OriginalImpl {
        public static String stringToMd5(String text) {
            if (text == null || text.isEmpty()) {
                return null;
            }
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] messageDigest = md.digest(text.getBytes());
                StringBuilder hexString = new StringBuilder();
                for (byte b : messageDigest) {
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

    // Transformed Code
    static class TransformedImpl {
        public static String stringToMd5(String inputString) {
            if (inputString == null || inputString.isEmpty()) {
                return null;
            }
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                byte[] hashBytes = digest.digest(inputString.getBytes("ASCII"));
                StringBuilder hexString = new StringBuilder();
                for (byte b : hashBytes) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) {
                        hexString.append('0');
                    }
                    hexString.append(hex);
                }
                return hexString.toString();
            } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
                throw new RuntimeException(e);
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
    public void testStringToMd5(String input) {
        assertEquals(OriginalImpl.stringToMd5(input), TransformedImpl.stringToMd5(input));
    }
}