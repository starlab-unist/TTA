import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_134 {

    // Source Code
    static class SourceCode {
        public boolean checkIfLastCharIsALetter(String txt) {
            String[] parts = txt.split(" ");
            if (parts.length == 0) return false;
            String check = parts[parts.length - 1];
            return check.length() == 1 && (check.toLowerCase().charAt(0) >= 'a' && check.toLowerCase().charAt(0) <= 'z');
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean determineIfFinalCharacterIsAlphabetic(String inputString) {
            String[] words = inputString.split(" ");
            if (words.length == 0) return false;
            String lastWord = words[words.length - 1];
            return lastWord.length() == 1 && lastWord.toLowerCase().matches("[a-z]");
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"hello world a", true},
        {"test z", true},
        {"123 b", true},
        {"c", true},
        {"no letters here !", false},
        {"singleword x", true},
        {"spaces at the end ", false},
        {"  leading spaces y", true},
        {"", false},
        {"onlyoneletter", false},
        {"a b c d e f g h i j k l m n o p q r s t u v w x y z", true},
        {"! @ # $ % ^ & * ( )", false},
        {"1234567890", false},
        {"singleletter a", true},
        {"a ", false}
    };

    private static Object[][] provideTestCases() {
        return testCases;
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void checkIfLastCharIsALetter_vs_determineIfFinalCharacterIsAlphabetic(String inputText, boolean expected) {
        assertEquals(
            SourceCode.checkIfLastCharIsALetter(inputText),
            TransformedCode.determineIfFinalCharacterIsAlphabetic(inputText),
            "Failed on input: " + inputText
        );
    }
}