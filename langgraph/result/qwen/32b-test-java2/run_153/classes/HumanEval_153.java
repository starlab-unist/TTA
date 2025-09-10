import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

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

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void Strongest_Extension_vs_findPowerfulAddon(String className, String[] extensions) {
        assertEquals(
            HumanEval_153_Source.Strongest_Extension(className, extensions),
            new HumanEval_153_Transformed().findPowerfulAddon(className, extensions)
        );
    }
}