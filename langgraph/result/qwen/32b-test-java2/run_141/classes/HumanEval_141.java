import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_141 {

    // Source Code
    static class HumanEval_141_Source {
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
    static class HumanEval_141_Transformed {
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
        "file..txt",
        ".hiddenfile.txt",
        "1234name.txt",
        "validName123.exe",
        "anotherValid.dll",
        "tooManyDigits1234.txt",
        "noextension",
        "wrongextension.doc"
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_141_Source().fileNameCheck(testCases[0]), 
                     new HumanEval_141_Transformed().validateFileIdentifier(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_141_Source().fileNameCheck(testCases[1]), 
                     new HumanEval_141_Transformed().validateFileIdentifier(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_141_Source().fileNameCheck(testCases[2]), 
                     new HumanEval_141_Transformed().validateFileIdentifier(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_141_Source().fileNameCheck(testCases[3]), 
                     new HumanEval_141_Transformed().validateFileIdentifier(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_141_Source().fileNameCheck(testCases[4]), 
                     new HumanEval_141_Transformed().validateFileIdentifier(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_141_Source().fileNameCheck(testCases[5]), 
                     new HumanEval_141_Transformed().validateFileIdentifier(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_141_Source().fileNameCheck(testCases[6]), 
                     new HumanEval_141_Transformed().validateFileIdentifier(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_141_Source().fileNameCheck(testCases[7]), 
                     new HumanEval_141_Transformed().validateFileIdentifier(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_141_Source().fileNameCheck(testCases[8]), 
                     new HumanEval_141_Transformed().validateFileIdentifier(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_141_Source().fileNameCheck(testCases[9]), 
                     new HumanEval_141_Transformed().validateFileIdentifier(testCases[9]));
    }

    @Test
    public void test_10() {
        assertEquals(new HumanEval_141_Source().fileNameCheck(testCases[10]), 
                     new HumanEval_141_Transformed().validateFileIdentifier(testCases[10]));
    }
}