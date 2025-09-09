public class HumanEval_56 {
    public static boolean validateBracketSequence(String brackets) {
        int depth = 0;
        int index = 0;
        while (index < brackets.length()) {
            if (brackets.charAt(index) == '<') {
                depth++;
            } else {
                depth--;
            }
            if (depth < 0) {
                return false;
            }
            index++;
        }
        return depth == 0;
    }
}