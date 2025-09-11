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
    static class HumanEval_153_Source {
        public static String Strongest_Extension(String className, String[] extensions) {
            String strong = extensions[0];
            int myVal = countUpper(extensions[0]) - countLower(extensions[0]);

            for (String s : extensions) {
                int val = countUpper(s) - countLower(s);
                if (val > myVal) {
                    strong = s;
                    myVal = val;
                }
            }

            return className + "." + strong;
        }

        private static int countUpper(String s) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    count++;
                }
            }
            return count;
        }

        private static int countLower(String s) {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    count++;
                }
            }
            return count;
        }
    }

    // Transformed Code
    static class HumanEval_153_Transformed {
        public String findPowerfulAddon(String baseClass, String[] addonList) {
            String powerfulAddon = addonList[0];
            int maxStrength = calculateStrength(addonList[0]);

            for (String addon : addonList) {
                int currentStrength = calculateStrength(addon);
                if (currentStrength > maxStrength) {
                    powerfulAddon = addon;
                    maxStrength = currentStrength;
                }
            }

            return baseClass + "." + powerfulAddon;
        }

        private int calculateStrength(String addon) {
            int strength = 0;
            for (char c : addon.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    strength++;
                } else if (Character.isLowerCase(c)) {
                    strength--;
                }
            }
            return strength;
        }
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
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[0][0], (String[]) testCases[0][1]), 
                     new HumanEval_153_Transformed().findPowerfulAddon((String) testCases[0][0], (String[]) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[1][0], (String[]) testCases[1][1]), 
                     new HumanEval_153_Transformed().findPowerfulAddon((String) testCases[1][0], (String[]) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[2][0], (String[]) testCases[2][1]), 
                     new HumanEval_153_Transformed().findPowerfulAddon((String) testCases[2][0], (String[]) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[3][0], (String[]) testCases[3][1]), 
                     new HumanEval_153_Transformed().findPowerfulAddon((String) testCases[3][0], (String[]) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[4][0], (String[]) testCases[4][1]), 
                     new HumanEval_153_Transformed().findPowerfulAddon((String) testCases[4][0], (String[]) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[5][0], (String[]) testCases[5][1]), 
                     new HumanEval_153_Transformed().findPowerfulAddon((String) testCases[5][0], (String[]) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[6][0], (String[]) testCases[6][1]), 
                     new HumanEval_153_Transformed().findPowerfulAddon((String) testCases[6][0], (String[]) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[7][0], (String[]) testCases[7][1]), 
                     new HumanEval_153_Transformed().findPowerfulAddon((String) testCases[7][0], (String[]) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[8][0], (String[]) testCases[8][1]), 
                     new HumanEval_153_Transformed().findPowerfulAddon((String) testCases[8][0], (String[]) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_153_Source.Strongest_Extension((String) testCases[9][0], (String[]) testCases[9][1]), 
                     new HumanEval_153_Transformed().findPowerfulAddon((String) testCases[9][0], (String[]) testCases[9][1]));
    }
}