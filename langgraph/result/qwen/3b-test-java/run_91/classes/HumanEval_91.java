import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_91 {

    // Source Code
    static class HumanEval_91_Source {
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
    }

    // Transformed Code
    static class HumanEval_91_Transformed {
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
        assertEquals(HumanEval_91_Source.isBored(testCases[0]), 
                     HumanEval_91_Transformed.countPersonalStatements(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_91_Source.isBored(testCases[1]), 
                     HumanEval_91_Transformed.countPersonalStatements(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_91_Source.isBored(testCases[2]), 
                     HumanEval_91_Transformed.countPersonalStatements(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_91_Source.isBored(testCases[3]), 
                     HumanEval_91_Transformed.countPersonalStatements(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_91_Source.isBored(testCases[4]), 
                     HumanEval_91_Transformed.countPersonalStatements(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_91_Source.isBored(testCases[5]), 
                     HumanEval_91_Transformed.countPersonalStatements(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_91_Source.isBored(testCases[6]), 
                     HumanEval_91_Transformed.countPersonalStatements(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_91_Source.isBored(testCases[7]), 
                     HumanEval_91_Transformed.countPersonalStatements(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_91_Source.isBored(testCases[8]), 
                     HumanEval_91_Transformed.countPersonalStatements(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_91_Source.isBored(testCases[9]), 
                     HumanEval_91_Transformed.countPersonalStatements(testCases[9]));
    }
}