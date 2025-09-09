import java.util.*;

public class HumanEval_158 {
    public static String findMax(List<String> words) {
        Comparator<String> customSortKey = new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                int lenCompare = Integer.compare(w2.length(), w1.length());
                if (lenCompare != 0) {
                    return lenCompare;
                }
                return w1.compareTo(w2);
            }
        };

        List<String> sortedWords = new ArrayList<>(words);
        Collections.sort(sortedWords, customSortKey);

        return sortedWords.get(0);
    }
}