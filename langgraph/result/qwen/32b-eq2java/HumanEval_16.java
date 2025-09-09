import java.util.HashSet;
import java.util.Set;

public class HumanEval_16 {
    public int determineUniqueCharCount(String inputText) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : inputText.toLowerCase().toCharArray()) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }
}