public class HumanEval_132 {

    public static boolean checkForNesting(String expression) {
        int[] startBracketsPositions = new int[expression.length()];
        int[] endBracketsPositions = new int[expression.length()];
        int index = 0;
        int openPos = -1;
        
        while (index < expression.length()) {
            if (expression.charAt(index) == '[') {
                startBracketsPositions[++openPos] = index;
            } else {
                endBracketsPositions[openPos--] = index;
            }
            index++;
        }
        
        int matchCount = 0;
        int j = 0;
        int totalEndBrackets = openPos + 1;
        
        for (int openPos : startBracketsPositions) {
            if (j < totalEndBrackets && openPos < endBracketsPositions[j]) {
                matchCount++;
                j++;
            }
        }
        
        return matchCount >= 2;
    }
}