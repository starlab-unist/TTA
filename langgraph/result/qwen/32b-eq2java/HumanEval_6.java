import java.util.ArrayList;
import java.util.List;

public class HumanEval_6 {

    public List<Integer> analyzeParenthesesDepth(String parenSequence) {
        List<Integer> result = new ArrayList<>();
        
        for (String segment : parenSequence.split("\\s+")) {
            if (!segment.isEmpty()) {
                result.add(calculateMaxNestingLevel(segment));
            }
        }
        
        return result;
    }

    private int calculateMaxNestingLevel(String substring) {
        int currentLevel = 0;
        int peakLevel = 0;
        
        for (char character : substring.toCharArray()) {
            if (character == '(') {
                currentLevel++;
                peakLevel = Math.max(currentLevel, peakLevel);
            } else if (character == ')') {
                currentLevel--;
            }
        }
        
        return peakLevel;
    }
}