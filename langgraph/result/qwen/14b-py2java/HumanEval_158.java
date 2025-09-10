import java.util.*;

public class HumanEval_158 {
    public static String findMax(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt((String x) -> -new HashSet<Character>(toCharacterList(x)).size())
                        .thenComparing(Comparator.naturalOrder()))
                .findFirst()
                .orElse(null);
    }

    private static List<Character> toCharacterList(String s) {
        List<Character> characterList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characterList.add(c);
        }
        return characterList;
    }
}