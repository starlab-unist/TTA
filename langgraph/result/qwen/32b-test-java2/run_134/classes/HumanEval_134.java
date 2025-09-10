import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream; // Added import for Stream
import java.util.Arrays;     // Added import for Arrays

public class HumanEval_134 {

    // Source Code
    static class SourceCode {
        public boolean checkIfLastCharIsALetter(String txt) {
            String[] parts = txt.split(" ");
            String check = parts[parts.length - 1];
            return check.length() == 1 && (check.toLowerCase().charAt(0) >= 'a' && check.toLowerCase().charAt(0) <= 'z');
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean determineIfFinalCharacterIsAlphabetic(String inputString) {
            String[] words = inputString.split(" ");
            String lastWord = words[words.length - 1];
            return lastWord.length() == 1 && lastWord.toLowerCase().matches("[a-z]");
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"hello world a"},
        {"test z"},
        {"123 b"},
        {"c"},
        {"no letters here !"},
        {"singleword x"},
        {"spaces at the end "},
        {"  leading spaces y"},
        {""},
        {"onlyoneletter"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if both functions produce the same output for given inputs")
    void checkIfLastCharIsALetter_vs_determineIfFinalCharacterIsAlphabetic(String inputText) {
        SourceCode sourceInstance = new SourceCode(); // Create an instance of SourceCode
        TransformedCode transformedInstance = new TransformedCode(); // Create an instance of TransformedCode
        
        assertEquals(
            sourceInstance.checkIfLastCharIsALetter(inputText.trim()), // Use instance method
            transformedInstance.determineIfFinalCharacterIsAlphabetic(inputText.trim()) // Use instance method
        );
    }
}