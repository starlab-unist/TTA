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
    private static final String[][] testCases = {
        {"ClassName", "Ext1,EXT2,ext3"},
        {"Base", "AddonA,ADDONB,addonC"},
        {"Main", "UPPER,lower,MiXeD"},
        {"Test", "aBcDeFgHiJ,KLMnopQRSt,UVwxYZ123"},
        {"Sample", "abc,ABC,AbC"},
        {"Example", ",A,a"},
        {"Case", "UPPERCASE,lowercase,MixedCase"},
        {"Check", "same,SAME,SaMe"},
        {"Compare", "123456,!@#$%^,abcdef"},
        {"Evaluate", "UPPERlower,UPPERLOWER,upperlower"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(arr -> Arguments.of(arr[0], arr[1].split(",")));
    }

    @DisplayName("Compare Strongest_Extension and findPowerfulAddon outputs")
    @ParameterizedTest(name = "{index} => input={0}, {1}")
    @MethodSource("provideTestCases")
    void strongest_extension_vs_find_powerful_addon(String className, String[] extensions) {
        assertEquals(
            HumanEval_153_Source.Strongest_Extension(className, extensions),
            new HumanEval_153_Transformed().findPowerfulAddon(className, extensions)
        );
    }
}