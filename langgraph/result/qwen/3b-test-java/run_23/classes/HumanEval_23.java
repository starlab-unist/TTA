import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_23 {

    // Source Code
    public static int strlen(String string) {
        return string.length();
    }

    // Transformed Code
    public static int calculateStringLength(String text) {
        int count = 0;
        for (char character : text.toCharArray()) {
            count++;
        }
        return count;
    }

    // Test Cases
    private static final String[] testCases = {
        "",
        "a",
        "hello",
        "OpenAI",
        "1234567890",
        "!@#$%^&*()",
        "spaces in between",
        "repeated repeated repeated",
        "A quick brown fox jumps over the lazy dog",
        "Python unittest framework"
    };

    @Test
    public void test_0() {
        assertEquals(strlen(testCases[0]), calculateStringLength(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(strlen(testCases[1]), calculateStringLength(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(strlen(testCases[2]), calculateStringLength(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(strlen(testCases[3]), calculateStringLength(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(strlen(testCases[4]), calculateStringLength(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(strlen(testCases[5]), calculateStringLength(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(strlen(testCases[6]), calculateStringLength(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(strlen(testCases[7]), calculateStringLength(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(strlen(testCases[8]), calculateStringLength(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(strlen(testCases[9]), calculateStringLength(testCases[9]));
    }
}