public class HumanEval_61 {
    public static boolean validateParentheses(String brackets) {
        int depth = 0;
        int index = 0;
        while (index < brackets.length()) {
            if (brackets.charAt(index) == '(') {
                depth++;
            } else if (brackets.charAt(index) == ')') {
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