import java.util.ArrayList;
import java.util.List;

public class HumanEval_117 {
    public static List<String> selectWords(String s, int n) {
        List<String> result = new ArrayList<>();
        String[] words = s.split("\\s+");
        
        for (String word : words) {
            int nConsonants = 0;
            for (char c : word.toLowerCase().toCharArray()) {
                if ("bcdfghjklmnpqrstvwxyz".indexOf(c) != -1) {
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