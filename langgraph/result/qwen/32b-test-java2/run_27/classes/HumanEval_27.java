import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_27 {

    // Source Code
    public static String flipCase(String string) {
        return string == null ? null : string.chars()
            .mapToObj(c -> Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c))
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }

    // Transformed Code
    public String invertCharacterCase(String inputText) {
        if (inputText == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (char c : inputText.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Test Cases
    private static final String[] testCases = {
        "Hello World",
        "Python3.8",
        "1234567890",
        "FLIPCASEflipcase",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        "!@#$%^&*()_+",
        "ALLCAPS",
        "alllower",
        "MiXeD CaSe",
        ""
    };

    @Test
    public void test_0() {
        assertEquals(flipCase(testCases[0]), new HumanEval_27().invertCharacterCase(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(flipCase(testCases[1]), new HumanEval_27().invertCharacterCase(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(flipCase(testCases[2]), new HumanEval_27().invertCharacterCase(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(flipCase(testCases[3]), new HumanEval_27().invertCharacterCase(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(flipCase(testCases[4]), new HumanEval_27().invertCharacterCase(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(flipCase(testCases[5]), new HumanEval_27().invertCharacterCase(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(flipCase(testCases[6]), new HumanEval_27().invertCharacterCase(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(flipCase(testCases[7]), new HumanEval_27().invertCharacterCase(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(flipCase(testCases[8]), new HumanEval_27().invertCharacterCase(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(flipCase(testCases[9]), new HumanEval_27().invertCharacterCase(testCases[9]));
    }
}