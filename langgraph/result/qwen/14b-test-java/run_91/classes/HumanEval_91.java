import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_91 {

    // Source Code
    public static int isBored(String S) {
        String[] sentences = S.split("[.?!]\\s*");
        int count = 0;
        for (String sentence : sentences) {
            if (sentence.startsWith("I ")) {
                count++;
            }
        }
        return count;
    }

    // Transformed Code
    public static int countPersonalStatements(String text) {
        String[] segments = text.split("[.?!]\\s*");
        int personalStatementCount = 0;

        for (String segment : segments) {
            if (segment.startsWith("I ")) {
                personalStatementCount++;
            }
        }

        return personalStatementCount;
    }

    // Test Cases
    private static final String[] testCases = {
        "I am bored. I think so.",
        "This is a test. I am testing.",
        "Hello world! I am here. Are you there?",
        "No personal statements here.",
        "I I I. I? I!",
        "I am fine. You are fine.",
        "I",
        "",
        "I am alone.I think so.I am sad.",
        "I. I! I?"
    };

    @Test
    public void test_0() {
        assertEquals(isBored(testCases[0]), countPersonalStatements(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(isBored(testCases[1]), countPersonalStatements(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(isBored(testCases[2]), countPersonalStatements(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(isBored(testCases[3]), countPersonalStatements(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(isBored(testCases[4]), countPersonalStatements(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(isBored(testCases[5]), countPersonalStatements(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(isBored(testCases[6]), countPersonalStatements(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(isBored(testCases[7]), countPersonalStatements(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(isBored(testCases[8]), countPersonalStatements(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(isBored(testCases[9]), countPersonalStatements(testCases[9]));
    }
}