public class HumanEval_119 {
    public static String validateParenthesesCombinations(String[] strings) {
        boolean isBalancedFirstSecond = isBalanced(strings[0] + strings[1]);
        boolean isBalancedSecondFirst = isBalanced(strings[1] + strings[0]);

        return isBalancedFirstSecond || isBalancedSecondFirst ? "Yes" : "No";
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