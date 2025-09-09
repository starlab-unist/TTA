import java.util.ArrayList;
import java.util.List;

public class HumanEval_117 {
    public static List<String> selectWords(String s, int n) {
        List<String> result = new ArrayList<>();
        String[] words = s.split();

        for (String word : words) {
            int nConsonants = 0;
            int index = 0;
            while (index < word.length()) {
                if (!"aeiou".contains(Character.toString(word.charAt(index)).toLowerCase())) {
                    nConsonants++;
                }
                index++;
            }

            if (nConsonants == n) {
                result.add(word);
            }
        }

        return result;
    }
}