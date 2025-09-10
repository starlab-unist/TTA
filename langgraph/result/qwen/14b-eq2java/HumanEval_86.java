import java.util.Arrays;

public class HumanEval_86 {
    public static String orderWordsCharacters(String inputString) {
        StringBuilder result = new StringBuilder();
        String[] words = inputString.split(" ");
        
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            result.append(sortedWord).append(" ");
        }
        
        return result.toString().trim();
    }
}