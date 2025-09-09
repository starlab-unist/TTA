import java.util.Arrays;

public class HumanEval_86 {
    public String orderWordsCharacters(String inputString) {
        StringBuilder result = new StringBuilder();
        String[] words = inputString.split(" ");
        
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(sortedWord);
        }
        
        return result.toString();
    }
}