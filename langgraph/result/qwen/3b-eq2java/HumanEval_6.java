import java.util.ArrayList;
import java.util.List;

public class HumanEval_6 {

    public static List<Integer> analyzeParenthesesDepth(String parenSequence) {
        return parenSequence.split("\\s+")
                .stream()
                .map(HumanEval_6::calculateMaxNestingLevel)
                .collect(ArrayList::new);
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