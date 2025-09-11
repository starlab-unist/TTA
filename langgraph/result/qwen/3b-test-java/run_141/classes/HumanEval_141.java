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
    public static String fileNameCheck(String fileName) {
        String[] suf = {"txt", "exe", "dll"};
        String[] parts = fileName.split("\\.");
        
        if (parts.length != 2) {
            return "No";
        }
        
        String extension = parts[1];
        if (!Arrays.asList(suf).contains(extension)) {
            return "No";
        }
        
        if (parts[0].isEmpty()) {
            return "No";
        }
        
        char firstChar = parts[0].charAt(0);
        if (!Character.isLetter(firstChar)) {
            return "No";
        }
        
        int digitCount = (int) parts[0].chars()
                                .filter(Character::isDigit)
                                .count();
        
        if (digitCount > 3) {
            return "No";
        }
        
        return "Yes";
    }

    // Transformed Code
    public static String validateFileIdentifier(String filename) {
        String[] validExtensions = {"txt", "exe", "dll"};
        String[] parts = filename.split("\\.", 2);
        
        if (parts.length != 2) {
            return "No";
        }
        
        String extension = parts[1];
        String name = parts[0];
        
        if (!Arrays.asList(validExtensions).contains(extension)) {
            return "No";
        }
        
        if (name.isEmpty()) {
            return "No";
        }
        
        if (!Character.isLetter(name.charAt(0))) {
            return "No";
        }
        
        int digitCount = (int) name.chars().filter(Character::isDigit).count();
        if (digitCount > 3) {
            return "No";
        }
        
        return "Yes";
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
        assertEquals(fileNameCheck(testCases[0]), validateFileIdentifier(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(fileNameCheck(testCases[1]), validateFileIdentifier(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(fileNameCheck(testCases[2]), validateFileIdentifier(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(fileNameCheck(testCases[3]), validateFileIdentifier(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(fileNameCheck(testCases[4]), validateFileIdentifier(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(fileNameCheck(testCases[5]), validateFileIdentifier(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(fileNameCheck(testCases[6]), validateFileIdentifier(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(fileNameCheck(testCases[7]), validateFileIdentifier(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(fileNameCheck(testCases[8]), validateFileIdentifier(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(fileNameCheck(testCases[9]), validateFileIdentifier(testCases[9]));
    }

    @Test
    public void test_10() {
        assertEquals(fileNameCheck(testCases[10]), validateFileIdentifier(testCases[10]));
    }
}