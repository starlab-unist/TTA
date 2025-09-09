import java.util.HashSet;
import java.util.Set;

public class HumanEval_118 {
    public static String getClosestVowel(String word) {
        if (word.length() < 3) {
            return "";
        }

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        for (int i = word.length() - 2; i > 0; i--) {
            if (vowels.contains(word.charAt(i))) {
                if (!vowels.contains(word.charAt(i + 1)) && !vowels.contains(word.charAt(i - 1))) {
                    return String.valueOf(word.charAt(i));
                }
            }
        }
        return "";
    }
}