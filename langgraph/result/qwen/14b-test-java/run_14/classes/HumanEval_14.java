import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_14 {

    // Source Code
    static class HumanEval_14_Source {
        public static List<String> allPrefixes(String string) {
            List<String> result = new ArrayList<>();

            for (int i = 0; i < string.length(); i++) {
                result.add(string.substring(0, i + 1));
            }
            return result;
        }
    }

    // Transformed Code
    static class HumanEval_14_Transformed {
        public static List<String> generateStringPrefixes(String inputStr) {
            List<String> prefixes = new ArrayList<>();
            int index = 0;

            while (index < inputStr.length()) {
                prefixes.add(inputStr.substring(0, index + 1));
                index += 1;
            }

            return prefixes;
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "hello",
        "world",
        "a",
        "",
        "python",
        "unittest",
        "12345",
        "prefixes",
        "testcase",
        "semantics"
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_14_Source.allPrefixes(testCases[0]), 
                     HumanEval_14_Transformed.generateStringPrefixes(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_14_Source.allPrefixes(testCases[1]), 
                     HumanEval_14_Transformed.generateStringPrefixes(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_14_Source.allPrefixes(testCases[2]), 
                     HumanEval_14_Transformed.generateStringPrefixes(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_14_Source.allPrefixes(testCases[3]), 
                     HumanEval_14_Transformed.generateStringPrefixes(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_14_Source.allPrefixes(testCases[4]), 
                     HumanEval_14_Transformed.generateStringPrefixes(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_14_Source.allPrefixes(testCases[5]), 
                     HumanEval_14_Transformed.generateStringPrefixes(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_14_Source.allPrefixes(testCases[6]), 
                     HumanEval_14_Transformed.generateStringPrefixes(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_14_Source.allPrefixes(testCases[7]), 
                     HumanEval_14_Transformed.generateStringPrefixes(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_14_Source.allPrefixes(testCases[8]), 
                     HumanEval_14_Transformed.generateStringPrefixes(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_14_Source.allPrefixes(testCases[9]), 
                     HumanEval_14_Transformed.generateStringPrefixes(testCases[9]));
    }
}