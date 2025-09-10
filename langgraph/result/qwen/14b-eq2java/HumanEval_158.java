import java.util.*;

public class HumanEval_158 {
    public static String determineLongestUniqueCharString(List<String> wordList) {
        Comparator<String> customSortKey = new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                int uniqueChars1 = new HashSet<Character>(toCharacterList(word1)).size();
                int uniqueChars2 = new HashSet<Character>(toCharacterList(word2)).size();
                
                if (uniqueChars1 != uniqueChars2) {
                    return Integer.compare(uniqueChars2, uniqueChars1);
                } else {
                    return word1.compareTo(word2);
                }
            }
        };
        
        Collections.sort(wordList, customSortKey);
        return wordList.get(0);
    }

    private static List<Character> toCharacterList(String s) {
        List<Character> characterList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characterList.add(c);
        }
        return characterList;
    }
}