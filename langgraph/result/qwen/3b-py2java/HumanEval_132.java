public class HumanEval_132 {

    public static boolean isNested(String string) {
        int[] openingBracketIndex = new int[string.length()];
        int[] closingBracketIndex = new int[string.length()];
        int openCount = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '[') {
                openingBracketIndex[openCount++] = i;
            } else if (string.charAt(i) == ']') {
                closingBracketIndex[--openCount] = i;
            }
        }

        int cnt = 0;
        for (int idx : openingBracketIndex) {
            if (idx < closingBracketIndex[openCount - 1]) {
                cnt++;
            }
        }

        return cnt >= 2;
    }
}