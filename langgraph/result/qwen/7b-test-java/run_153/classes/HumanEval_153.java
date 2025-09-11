import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_153 {

    // Source Code
    static class HumanEval_153_Source {
        public static String Strongest_Extension(String class_name, List<String> extensions) {
            String strong = extensions.get(0);
            int my_val = countUppercaseLetters(strong) - countLowercaseLetters(strong);

            for (String s : extensions) {
                int val = countUppercaseLetters(s) - countLowercaseLetters(s);
                if (val > my_val) {
                    strong = s;
                    my_val = val;
                }
            }

            String ans = class_name + "." + strong;
            return ans;
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
    }

    // Transformed Code
    static class HumanEval_153_Transformed {
        public static String findPowerfulAddon(String baseClass, List<String> extensionList) {
            String powerfulAddon = extensionList.get(0);
            int maxStrength = calculateStrength(powerfulAddon);

            for (String addon : extensionList) {
                int currentStrength = calculateStrength(addon);
                if (currentStrength > maxStrength) {
                    powerfulAddon = addon;
                    maxStrength = currentStrength;
                }
            }

            return baseClass + "." + powerfulAddon;
        }

        private static int calculateStrength(String addon) {
            long upperCaseCount = addon.chars().filter(Character::isUpperCase).count();
            long lowerCaseCount = addon.chars().filter(Character::isLowerCase).count();
            return (int) (upperCaseCount - lowerCaseCount);
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"ClassName", List.of("Ext1", "EXT2", "ext3")},
        {"Base", List.of("AddonA", "ADDONB", "addonC")},
        {"Main", List.of("UPPER", "lower", "MiXeD")},
        {"Test", List.of("aBcDeFgHiJ", "KLMnopQRSt", "UVwxYZ123")},
        {"Sample", List.of("abc", "ABC", "AbC")},
        {"Example", List.of("", "A", "a")},
        {"Case", List.of("UPPERCASE", "lowercase", "MixedCase")},
        {"Check", List.of("same", "SAME", "SaMe")},
        {"Compare", List.of("123456", "!@#$%^", "abcdef")},
        {"Evaluate", List.of("UPPERlower", "UPPERLOWER", "upperlower")}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[0][0], (List<String>) testCases[0][1]), 
                     HumanEval_153_Transformed.findPowerfulAddon((String) testCases[0][0], (List<String>) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[1][0], (List<String>) testCases[1][1]), 
                     HumanEval_153_Transformed.findPowerfulAddon((String) testCases[1][0], (List<String>) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[2][0], (List<String>) testCases[2][1]), 
                     HumanEval_153_Transformed.findPowerfulAddon((String) testCases[2][0], (List<String>) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[3][0], (List<String>) testCases[3][1]), 
                     HumanEval_153_Transformed.findPowerfulAddon((String) testCases[3][0], (List<String>) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[4][0], (List<String>) testCases[4][1]), 
                     HumanEval_153_Transformed.findPowerfulAddon((String) testCases[4][0], (List<String>) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[5][0], (List<String>) testCases[5][1]), 
                     HumanEval_153_Transformed.findPowerfulAddon((String) testCases[5][0], (List<String>) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[6][0], (List<String>) testCases[6][1]), 
                     HumanEval_153_Transformed.findPowerfulAddon((String) testCases[6][0], (List<String>) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[7][0], (List<String>) testCases[7][1]), 
                     HumanEval_153_Transformed.findPowerfulAddon((String) testCases[7][0], (List<String>) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[8][0], (List<String>) testCases[8][1]), 
                     HumanEval_153_Transformed.findPowerfulAddon((String) testCases[8][0], (List<String>) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[9][0], (List<String>) testCases[9][1]), 
                     HumanEval_153_Transformed.findPowerfulAddon((String) testCases[9][0], (List<String>) testCases[9][1]));
    }
}