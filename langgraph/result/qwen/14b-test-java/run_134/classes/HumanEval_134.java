import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_134 {

    // Source Code
    public static boolean checkIfLastCharIsALetter(String txt) {
        String[] parts = txt.split(" ");
        String check = parts[parts.length - 1];
        return check.length() == 1 && (check.toLowerCase().charAt(0) >= 'a' && check.toLowerCase().charAt(0) <= 'z');
    }

    // Transformed Code
    public static boolean determineIfFinalCharacterIsAlphabetic(String inputString) {
        String[] words = inputString.split("\\s+");
        String lastWord = words[words.length - 1];
        return lastWord.length() == 1 && "a" <= lastWord.toLowerCase().charAt(0) && lastWord.toLowerCase().charAt(0) <= 'z';
    }

    // Test Cases
    private static final String[] testCases = {
        "hello world a",
        "test z",
        "123 b",
        "c",
        "no letters here !",
        "singleword x",
        "spaces at the end ",
        "  leading spaces y",
        "",
        "onlyoneletter"
    };

    @Test
    public void test_0() {
        assertEquals(checkIfLastCharIsALetter(testCases[0]), determineIfFinalCharacterIsAlphabetic(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(checkIfLastCharIsALetter(testCases[1]), determineIfFinalCharacterIsAlphabetic(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(checkIfLastCharIsALetter(testCases[2]), determineIfFinalCharacterIsAlphabetic(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(checkIfLastCharIsALetter(testCases[3]), determineIfFinalCharacterIsAlphabetic(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(checkIfLastCharIsALetter(testCases[4]), determineIfFinalCharacterIsAlphabetic(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(checkIfLastCharIsALetter(testCases[5]), determineIfFinalCharacterIsAlphabetic(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(checkIfLastCharIsALetter(testCases[6]), determineIfFinalCharacterIsAlphabetic(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(checkIfLastCharIsALetter(testCases[7]), determineIfFinalCharacterIsAlphabetic(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(checkIfLastCharIsALetter(testCases[8]), determineIfFinalCharacterIsAlphabetic(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(checkIfLastCharIsALetter(testCases[9]), determineIfFinalCharacterIsAlphabetic(testCases[9]));
    }
}