import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import java.util.Arrays;

public class HumanEval_141 {

    // Source Code
    static class SourceCode {
        public String fileNameCheck(String fileName) {
            String[] suf = {"txt", "exe", "dll"};
            String[] lst = fileName.split("\\.");
            if (lst.length != 2) {
                return "No";
            }
            boolean isValidSuffix = false;
            for (String suffix : suf) {
                if (lst[1].equals(suffix)) {
                    isValidSuffix = true;
                    break;
                }
            }
            if (!isValidSuffix) {
                return "No";
            }
            if (lst[0].length() == 0) {
                return "No";
            }
            if (!Character.isLetter(lst[0].charAt(0))) {
                return "No";
            }
            int digitCount = 0;
            for (char c : lst[0].toCharArray()) {
                if (Character.isDigit(c)) {
                    digitCount++;
                }
            }
            if (digitCount > 3) {
                return "No";
            }
            return "Yes";
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String validateFileIdentifier(String filename) {
            String[] validExtensions = {"txt", "exe", "dll"};
            String[] parts = filename.split("\\.", 2);
            
            if (parts.length != 2) {
                return "No";
            }
            
            String extension = parts[1];
            String name = parts[0];
            
            boolean isValidExtension = false;
            for (String ext : validExtensions) {
                if (extension.equals(ext)) {
                    isValidExtension = true;
                    break;
                }
            }
            
            if (!isValidExtension) {
                return "No";
            }
            
            if (name.isEmpty()) {
                return "No";
            }
            
            if (!Character.isLetter(name.charAt(0))) {
                return "No";
            }
            
            int digitCount = 0;
            for (char c : name.toCharArray()) {
                if (Character.isDigit(c)) {
                    digitCount++;
                }
            }
            
            if (digitCount > 3) {
                return "No";
            }
            
            return "Yes";
        }
    }

    // Test Cases
    private static final String[] testCases = {
        "example.txt",
        "test.exe",
        "data.dll",
        "file..txt",      // Invalid due to double dot
        ".hiddenfile.txt",  // Invalid as name starts with a dot
        "1234name.txt",   // Valid but starts with digits
        "validName123.exe", // Valid with up to 3 digits
        "anotherValid.dll",// Valid without digits
        "tooManyDigits1234.txt", // Invalid due to more than 3 digits
        "noextension",    // Invalid as no extension
        "wrongextension.doc" // Invalid as invalid extension
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void fileNameCheck_vs_validateFileIdentifier(String inputFileName) {
        assertEquals(
            SourceCode.fileNameCheck(inputFileName),
            TransformedCode.validateFileIdentifier(inputFileName)
        );
    }
}