import java.util.ArrayList;
import java.util.List;

public class HumanEval_29 {
    public static List<String> selectStringsWithStartingChars(List<String> wordList, String startSequence) {
        List<String> filteredWords = new ArrayList<>();
        for (String word : wordList) {
            if (word.startsWith(startSequence)) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }
}