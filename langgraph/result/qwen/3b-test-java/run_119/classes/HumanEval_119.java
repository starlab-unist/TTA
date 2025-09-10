public class HumanEval_119 {

    public static String validateParenthesesCombinations(String[] strings) {
        return isBalanced(strings[0] + strings[1]) || isBalanced(strings[1] + strings[0]) ? "Yes" : "No";
    }

    private static boolean isBalanced(String expression) {
        int balance = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}