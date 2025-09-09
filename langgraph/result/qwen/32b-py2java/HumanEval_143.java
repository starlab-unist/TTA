import java.util.ArrayList;
import java.util.List;

class HumanEval_143 {
    public String wordsInSentence(String sentence) {
        List<String> newList = new ArrayList<>();
        for (String word : sentence.split("\\s+")) {
            int flg = 0;
            if (word.length() == 1) {
                flg = 1;
            }
            for (int i = 2; i < word.length(); i++) {
                if (word.length() % i == 0) {
                    flg = 1;
                }
            }
            if (flg == 0 || word.length() == 2) {
                newList.add(word);
            }
        }
        return String.join(" ", newList);
    }
}