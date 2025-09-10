import java.util.ArrayList;
import java.util.List;

public class HumanEval_143 {
    public static String wordsInSentence(String sentence) {
        List<String> newList = new ArrayList<>();
        String[] words = sentence.split("\\s+");
        
        for (String word : words) {
            int flag = 0;
            if (word.length() == 1) {
                flag = 1;
            }
            for (int i = 2; i < word.length(); i++) {
                if (word.length() % i == 0) {
                    flag = 1;
                }
            }
            if (flag == 0 || word.length() == 2) {
                newList.add(word);
            }
        }
        
        return String.join(" ", newList);
    }
}