import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_132 {
    public boolean checkForNesting(String expression) {
        List<Integer> startBracketsPositions = new ArrayList<>();
        List<Integer> endBracketsPositions = new ArrayList<>();
        int index = 0;
        while (index < expression.length()) {
            if (expression.charAt(index) == '[') {
                startBracketsPositions.add(index);
            } else {
                endBracketsPositions.add(index);
            }
            index++;
        }
        Collections.reverse(endBracketsPositions);
        int matchCount = 0;
        int j = 0;
        int totalEndBrackets = endBracketsPositions.size();
        for (int openPos : startBracketsPositions) {
            if (j < totalEndBrackets && openPos < endBracketsPositions.get(j)) {
                matchCount++;
                j++;
            }
        }
        return matchCount >= 2;
    }
}