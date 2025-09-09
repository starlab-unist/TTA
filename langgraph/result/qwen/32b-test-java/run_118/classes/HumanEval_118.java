import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_118 {

    // Source Code
    static class SourceCode {
        public String getClosestVowel(String word) {
            if (word.length() < 3) {
                return "";
            }

            String vowels = "aeiouAEIOU";
            for (int i = word.length() - 2; i > 0; i--) {
                if (vowels.indexOf(word.charAt(i)) != -1) {
                    if (vowels.indexOf(word.charAt(i + 1)) == -1 && vowels.indexOf(word.charAt(i - 1)) == -1) {
                        return String.valueOf(word.charAt(i));
                    }
                }
            }
            return "";
        }
    }

    // Transformed Code
    static class TransformedCode {
        public String findNearestIsolatedVowel(String sequence) {
            if (sequence.length() < 3) {
                return "";
            }

            String vowels = "aeiouAEIOU";
            int index = sequence.length() - 3;

            while (index > 0) {
                if (vowels.indexOf(sequence.charAt(index)) != -1) {
                    if (vowels.indexOf(sequence.charAt(index + 1)) == -1 && vowels.indexOf(sequence.charAt(index - 1)) == -1) {
                        return String.valueOf(sequence.charAt(index));
                    }
                }
                index--;
            }

            return "";
        }
    }

    // Test Inputs
    private static final String[] testCases = {
        "hello",
        "beautiful",
        "sequence",
        "aeiou",
        "bcdfg",
        "aebcdfg",
        "racecar",
        "xylophone",
        "umbrella",
        "algorithm"
    };

    @Test
    public void test_0() {
        assertEquals(SourceCode.getClosestVowel(testCases[0]), TransformedCode.findNearestIsolatedVowel(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.getClosestVowel(testCases[1]), TransformedCode.findNearestIsolatedVowel(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.getClosestVowel(testCases[2]), TransformedCode.findNearestIsolatedVowel(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.getClosestVowel(testCases[3]), TransformedCode.findNearestIsolatedVowel(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.getClosestVowel(testCases[4]), TransformedCode.findNearestIsolatedVowel(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.getClosestVowel(testCases[5]), TransformedCode.findNearestIsolatedVowel(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.getClosestVowel(testCases[6]), TransformedCode.findNearestIsolatedVowel(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.getClosestVowel(testCases[7]), TransformedCode.findNearestIsolatedVowel(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.getClosestVowel(testCases[8]), TransformedCode.findNearestIsolatedVowel(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.getClosestVowel(testCases[9]), TransformedCode.findNearestIsolatedVowel(testCases[9]));
    }
}