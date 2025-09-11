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
    static class HumanEval_23_Source {
        public int strlen(String string) {
            return string.length();
        }
    }

    // Transformed Code
    static class HumanEval_23_Transformed {
        public int calculateStringLength(String text) {
            int count = 0;
            for (char character : text.toCharArray()) {
                count += 1;
            }
            return count;
        }
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
        assertEquals(new HumanEval_23_Source().strlen(testCases[0]), 
                     new HumanEval_23_Transformed().calculateStringLength(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_23_Source().strlen(testCases[1]), 
                     new HumanEval_23_Transformed().calculateStringLength(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_23_Source().strlen(testCases[2]), 
                     new HumanEval_23_Transformed().calculateStringLength(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_23_Source().strlen(testCases[3]), 
                     new HumanEval_23_Transformed().calculateStringLength(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_23_Source().strlen(testCases[4]), 
                     new HumanEval_23_Transformed().calculateStringLength(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_23_Source().strlen(testCases[5]), 
                     new HumanEval_23_Transformed().calculateStringLength(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_23_Source().strlen(testCases[6]), 
                     new HumanEval_23_Transformed().calculateStringLength(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_23_Source().strlen(testCases[7]), 
                     new HumanEval_23_Transformed().calculateStringLength(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_23_Source().strlen(testCases[8]), 
                     new HumanEval_23_Transformed().calculateStringLength(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_23_Source().strlen(testCases[9]), 
                     new HumanEval_23_Transformed().calculateStringLength(testCases[9]));
    }
}