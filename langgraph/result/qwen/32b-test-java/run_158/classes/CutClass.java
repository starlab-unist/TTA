import java.util.*;

class HumanEval_158 {
    public static String determineLongestUniqueCharString(List<String> wordList) {
        Comparator<String> customSortKey = (word1, word2) -> {
            int uniqueCharsCount1 = new HashSet<>(Arrays.asList(word1.split(""))).size();
            int uniqueCharsCount2 = new HashSet<>(Arrays.asList(word2.split(""))).size();
            if (uniqueCharsCount1 != uniqueCharsCount2) {
                return Integer.compare(uniqueCharsCount2, uniqueCharsCount1);
            } else {
                return word1.compareTo(word2);
            }
        };

        List<String> sortedWords = new ArrayList<>(wordList);
        Collections.sort(sortedWords, customSortKey);
        return sortedWords.get(0);
    }
}