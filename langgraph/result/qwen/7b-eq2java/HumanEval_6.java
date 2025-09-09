import java.util.ArrayList;
import java.util.List;

public class HumanEval_6 {
    public static List<Integer> analyzeParenthesesDepth(String parenSequence) {
        String[] segments = parenSequence.trim().split("\\s+");
        List<Integer> result = new ArrayList<>();

        for (String segment : segments) {
            result.add(calculateMaxNestingLevel(segment));
        }

        return result;
    }

    private static int calculateMaxNestingLevel(String substring) {
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