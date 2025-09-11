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
    static class HumanEval_134_Source {
        public static boolean checkIfLastCharIsALetter(String txt) {
            String[] words = txt.split(" ");
            if (words.length == 0) {
                return false;
            }
            String lastWord = words[words.length - 1];
            return lastWord.length() == 1 && (lastWord.charAt(0) >= 'a' && lastWord.charAt(0) <= 'z');
        }
    }

    // Transformed Code
    static class HumanEval_134_Transformed {
        public boolean determineIfFinalCharacterIsAlphabetic(String inputString) {
            String[] words = inputString.split(" ", -1);
            String lastWord = words[words.length - 1];
            return lastWord.length() == 1 && lastWord.toLowerCase().equals("a");
        }
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
        assertEquals(HumanEval_134_Source.checkIfLastCharIsALetter(testCases[0]), 
                     new HumanEval_134_Transformed().determineIfFinalCharacterIsAlphabetic(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_134_Source.checkIfLastCharIsALetter(testCases[1]), 
                     new HumanEval_134_Transformed().determineIfFinalCharacterIsAlphabetic(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_134_Source.checkIfLastCharIsALetter(testCases[2]), 
                     new HumanEval_134_Transformed().determineIfFinalCharacterIsAlphabetic(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_134_Source.checkIfLastCharIsALetter(testCases[3]), 
                     new HumanEval_134_Transformed().determineIfFinalCharacterIsAlphabetic(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_134_Source.checkIfLastCharIsALetter(testCases[4]), 
                     new HumanEval_134_Transformed().determineIfFinalCharacterIsAlphabetic(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_134_Source.checkIfLastCharIsALetter(testCases[5]), 
                     new HumanEval_134_Transformed().determineIfFinalCharacterIsAlphabetic(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_134_Source.checkIfLastCharIsALetter(testCases[6]), 
                     new HumanEval_134_Transformed().determineIfFinalCharacterIsAlphabetic(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_134_Source.checkIfLastCharIsALetter(testCases[7]), 
                     new HumanEval_134_Transformed().determineIfFinalCharacterIsAlphabetic(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_134_Source.checkIfLastCharIsALetter(testCases[8]), 
                     new HumanEval_134_Transformed().determineIfFinalCharacterIsAlphabetic(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_134_Source.checkIfLastCharIsALetter(testCases[9]), 
                     new HumanEval_134_Transformed().determineIfFinalCharacterIsAlphabetic(testCases[9]));
    }
}