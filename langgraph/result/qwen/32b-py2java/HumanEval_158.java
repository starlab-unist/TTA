import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class HumanEval_158 {
    public static String findMax(List<String> words) {
        return Collections.max(words, Comparator.comparing((String x) -> -new java.util.HashSet<Character>(toCharacterList(x)).size()).thenComparing(Comparator.naturalOrder()));
    }

    private static List<Character> toCharacterList(String s) {
        List<Character> characterList = new java.util.ArrayList<>();
        for (char c : s.toCharArray()) {
            characterList.add(c);
        }
        return characterList;
    }
}