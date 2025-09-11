import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_153 {

    // Source Code
    public static String StrongestExtension(String className, String[] extensions) {
        String strong = extensions[0];
        int myVal = countUppercaseLetters(extensions[0]) - countLowercaseLetters(extensions[0]);

        for (String s : extensions) {
            int val = countUppercaseLetters(s) - countLowercaseLetters(s);
            if (val > myVal) {
                strong = s;
                myVal = val;
            }
        }

        return className + "." + strong;
    }

    private static int countUppercaseLetters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    private static int countLowercaseLetters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                count++;
            }
        }
        return count;
    }

    // Transformed Code
    public static String findPowerfulAddon(String baseClass, String[] addonList) {
        String powerfulAddon = addonList[0];
        int maxStrength = 0;

        for (String addon : addonList) {
            int currentStrength = 0;
            for (char c : addon.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    currentStrength++;
                } else if (Character.isLowerCase(c)) {
                    currentStrength--;
                }
            }

            if (currentStrength > maxStrength) {
                powerfulAddon = addon;
                maxStrength = currentStrength;
            }
        }

        return baseClass + "." + powerfulAddon;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"ClassName", new String[]{"Ext1", "EXT2", "ext3"}},
        {"Base", new String[]{"AddonA", "ADDONB", "addonC"}},
        {"Main", new String[]{"UPPER", "lower", "MiXeD"}},
        {"Test", new String[]{"aBcDeFgHiJ", "KLMnopQRSt", "UVwxYZ123"}},
        {"Sample", new String[]{"abc", "ABC", "AbC"}},
        {"Example", new String[]{"", "A", "a"}},
        {"Case", new String[]{"UPPERCASE", "lowercase", "MixedCase"}},
        {"Check", new String[]{"same", "SAME", "SaMe"}},
        {"Compare", new String[]{"123456", "!@#$%^", "abcdef"}},
        {"Evaluate", new String[]{"UPPERlower", "UPPERLOWER", "upperlower"}}
    };

    @Test
    public void test_0() {
        assertEquals(StrongestExtension((String) testCases[0][0], (String[]) testCases[0][1]), 
                     findPowerfulAddon((String) testCases[0][0], (String[]) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(StrongestExtension((String) testCases[1][0], (String[]) testCases[1][1]), 
                     findPowerfulAddon((String) testCases[1][0], (String[]) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(StrongestExtension((String) testCases[2][0], (String[]) testCases[2][1]), 
                     findPowerfulAddon((String) testCases[2][0], (String[]) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(StrongestExtension((String) testCases[3][0], (String[]) testCases[3][1]), 
                     findPowerfulAddon((String) testCases[3][0], (String[]) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(StrongestExtension((String) testCases[4][0], (String[]) testCases[4][1]), 
                     findPowerfulAddon((String) testCases[4][0], (String[]) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(StrongestExtension((String) testCases[5][0], (String[]) testCases[5][1]), 
                     findPowerfulAddon((String) testCases[5][0], (String[]) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(StrongestExtension((String) testCases[6][0], (String[]) testCases[6][1]), 
                     findPowerfulAddon((String) testCases[6][0], (String[]) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(StrongestExtension((String) testCases[7][0], (String[]) testCases[7][1]), 
                     findPowerfulAddon((String) testCases[7][0], (String[]) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(StrongestExtension((String) testCases[8][0], (String[]) testCases[8][1]), 
                     findPowerfulAddon((String) testCases[8][0], (String[]) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(StrongestExtension((String) testCases[9][0], (String[]) testCases[9][1]), 
                     findPowerfulAddon((String) testCases[9][0], (String[]) testCases[9][1]));
    }
}