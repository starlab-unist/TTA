import java.util.ArrayList;
import java.util.List;

public class HumanEval_132 {
    public static boolean isNested(String expression) {
        List<Integer> openingBracketIndex = new ArrayList<>();
        List<Integer> closingBracketIndex = new ArrayList<>();
        int index = 0;
        
        while (index < expression.length()) {
            if (expression.charAt(index) == '[') {
                openingBracketIndex.add(index);
            } else {
                closingBracketIndex.add(index);
            }
            index++;
        }
        
        closingBracketIndex.reverse();
        
        int matchCount = 0;
        int j = 0;
        int totalEndBrackets = closingBracketIndex.size();
        
        for (int openPos : openingBracketIndex) {
            if (j < totalEndBrackets && openPos < closingBracketIndex.get(j)) {
                matchCount++;
                j++;
            }
        }
        
        return matchCount >= 2;
    }
}