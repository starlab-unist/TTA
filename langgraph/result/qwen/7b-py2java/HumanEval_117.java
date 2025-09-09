import java.util.ArrayList;
import java.util.List;

public class HumanEval_117 {
    public List<String> selectWords(String s, int n) {
        List<String> result = new ArrayList<>();
        String[] words = s.split();
        for (String word : words) {
            int nConsonants = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = Character.toLowerCase(word.charAt(i));
                if (!"aeiou".contains(String.valueOf(c))) {
                    nConsonants++;
                }
            }
            if (nConsonants == n) {
                result.add(word);
            }
        }
        return result;
    }
}