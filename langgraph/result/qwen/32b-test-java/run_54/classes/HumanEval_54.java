import java.util.Set;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HumanEval_54 {

    // Source Code
    static class SourceCode {
        public static boolean sameChars(String s0, String s1) {
            Set<Character> set0 = new HashSet<>();
            Set<Character> set1 = new HashSet<>();

            for (char c : s0.toCharArray()) {
                set0.add(c);
            }

            for (char c : s1.toCharArray()) {
                set1.add(c);
            }

            return set0.equals(set1);
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean compareCharacterSets(String stringOne, String stringTwo) {
            Set<Character> setOfCharsOne = new HashSet<>();
            Set<Character> setOfCharsTwo = new HashSet<>();

            for (char c : stringOne.toCharArray()) {
                setOfCharsOne.add(c);
            }

            for (char c : stringTwo.toCharArray()) {
                setOfCharsTwo.add(c);
            }

            return setOfCharsOne.equals(setOfCharsTwo);
        }
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(SourceCode.sameChars("hello", "olleh"), new TransformedCode().compareCharacterSets("hello", "olleh"));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.sameChars("world", "dlrow"), new TransformedCode().compareCharacterSets("world", "dlrow"));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.sameChars("python", "nothyp"), new TransformedCode().compareCharacterSets("python", "nothyp"));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.sameChars("openai", "ipaneo"), new TransformedCode().compareCharacterSets("openai", "ipaneo"));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.sameChars("", ""), new TransformedCode().compareCharacterSets("", ""));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.sameChars("a", "a"), new TransformedCode().compareCharacterSets("a", "a"));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.sameChars("ab", "ba"), new TransformedCode().compareCharacterSets("ab", "ba"));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.sameChars("abc", "cba"), new TransformedCode().compareCharacterSets("abc", "cba"));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.sameChars("abcd", "dcba"), new TransformedCode().compareCharacterSets("abcd", "dcba"));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.sameChars("xyz", "zyx"), new TransformedCode().compareCharacterSets("xyz", "zyx"));
    }

    // Additional Test Cases to ensure comprehensive coverage

    @Test
    public void test_10() {
        assertEquals(SourceCode.sameChars("java", "avaj"), new TransformedCode().compareCharacterSets("java", "avaj"));
    }

    @Test
    public void test_11() {
        assertEquals(SourceCode.sameChars("test", "sett"), new TransformedCode().compareCharacterSets("test", "sett"));
    }

    @Test
    public void test_12() {
        assertEquals(SourceCode.sameChars("unit", "nitu"), new TransformedCode().compareCharacterSets("unit", "nitu"));
    }

    @Test
    public void test_13() {
        assertEquals(SourceCode.sameChars("case", "aces"), new TransformedCode().compareCharacterSets("case", "aces"));
    }

    @Test
    public void test_14() {
        assertEquals(SourceCode.sameChars("equal", "laueq"), new TransformedCode().compareCharacterSets("equal", "laueq"));
    }

    // Additional Simple Value Tests

    @Test
    public void test_15() {
        assertEquals(SourceCode.sameChars("same", "ames"), new TransformedCode().compareCharacterSets("same", "ames"));
    }

    @Test
    public void test_16() {
        assertEquals(SourceCode.sameChars("chars", "hracs"), new TransformedCode().compareCharacterSets("chars", "hracs"));
    }

    @Test
    public void test_17() {
        assertEquals(SourceCode.sameChars("hello123", "321olleh"), new TransformedCode().compareCharacterSets("hello123", "321olleh"));
    }

    @Test
    public void test_18() {
        assertEquals(SourceCode.sameChars("!@#", "#@!"), new TransformedCode().compareCharacterSets("!@#", "#@!"));
    }

    @Test
    public void test_19() {
        assertEquals(SourceCode.sameChars(" ", " "), new TransformedCode().compareCharacterSets(" ", " "));
    }
}