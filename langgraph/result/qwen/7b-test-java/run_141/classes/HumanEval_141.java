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
        String[] lst = fileName.split("\\.");
        if (lst.length != 2) {
            return "No";
        }
        if (!contains(suf, lst[1])) {
            return "No";
        }
        if (lst[0].length() == 0) {
            return "No";
        }
        if (!Character.isLetter(lst[0].charAt(0))) {
            return "No";
        }
        long t = lst[0].chars().filter(Character::isDigit).count();
        if (t > 3) {
            return "No";
        }
        return "Yes";
    }

    private static boolean contains(String[] array, String element) {
        for (String item : array) {
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    // Transformed Code
    public static String validate_file_identifier(String filename) {
        String[] validExtensions = {"txt", "exe", "dll"};
        String[] parts = filename.split("\\.", 2);
        
        if (parts.length != 2) {
            return "No";
        }
        
        String name = parts[0];
        String extension = parts[1];
        
        if (!contains(validExtensions, extension)) {
            return "No";
        }
        
        if (name.isEmpty()) {
            return "No";
        }
        
        if (!Character.isLetter(name.charAt(0))) {
            return "No";
        }
        
        long digitCount = name.chars().filter(Character::isDigit).count();
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
        assertEquals(fileNameCheck(testCases[0]), validate_file_identifier(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(fileNameCheck(testCases[1]), validate_file_identifier(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(fileNameCheck(testCases[2]), validate_file_identifier(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(fileNameCheck(testCases[3]), validate_file_identifier(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(fileNameCheck(testCases[4]), validate_file_identifier(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(fileNameCheck(testCases[5]), validate_file_identifier(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(fileNameCheck(testCases[6]), validate_file_identifier(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(fileNameCheck(testCases[7]), validate_file_identifier(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(fileNameCheck(testCases[8]), validate_file_identifier(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(fileNameCheck(testCases[9]), validate_file_identifier(testCases[9]));
    }

    @Test
    public void test_10() {
        assertEquals(fileNameCheck(testCases[10]), validate_file_identifier(testCases[10]));
    }
}