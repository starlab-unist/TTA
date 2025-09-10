public class HumanEval_132 {
    public static boolean checkForNesting(String expression) {
        List<Integer> startBracketsPositions = new ArrayList<>();
        List<Integer> endBracketsPositions = new ArrayList<>();
        int index = 0;
        while (index < expression.length()) {
            if (expression.charAt(index) == '[') {
                startBracketsPositions.add(index);
            } else {
                endBracketsPositions.add(index);
            }
            index += 1;
        }
        Collections.reverse(endBracketsPositions);
        int matchCount = 0;
        int j = 0;
        int totalEndBrackets = endBracketsPositions.size();
        for (int openPos : startBracketsPositions) {
            if (j < totalEndBrackets && openPos < endBracketsPositions.get(j)) {
                matchCount += 1;
                j += 1;
            }
        }
        return matchCount >= 2;
    }
}