import java.util.Set;
import java.util.HashSet;

public class HumanEval_16 {
    public static int countDistinctCharacters(String inputText) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : inputText.toLowerCase().toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }
}