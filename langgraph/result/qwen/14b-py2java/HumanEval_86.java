import java.util.Arrays;

public class HumanEval_86 {
    public static String antiShuffle(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            result.append(new String(chars)).append(" ");
        }
        
        return result.toString().trim();
    }
}