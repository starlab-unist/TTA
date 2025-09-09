import java.util.Arrays;

public class HumanEval_86 {
    public static String orderWordsCharacters(String inputString) {
        String[] words = inputString.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            result.append(new String(characters)).append(" ");
        }
        
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        
        return result.toString();
    }
}