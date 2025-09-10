import java.util.Set;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;
import java.util.Arrays;

// Source Code
class SourceCode {
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
class TransformedCode {
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
public class HumanEval_54 {

    private static final String[][] testCases = {
        {"hello", "olleh"},
        {"world", "dlrow"},
        {"python", "nothyp"},
        {"openai", "ipaneo"},
        {"", ""},
        {"a", "a"},
        {"ab", "ba"},
        {"abc", "cba"},
        {"abcd", "dcba"},
        {"xyz", "zyx"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void sameChars_vs_compareCharacterSets(String inputText1, String inputText2) {
        assertEquals(
            SourceCode.sameChars(inputText1, inputText2),
            new TransformedCode().compareCharacterSets(inputText1, inputText2)
        );
    }
}