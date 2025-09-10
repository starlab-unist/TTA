public class HumanEval_119 {
    public static String validateParenthesesCombinations(String[] strings) {
        boolean isBalanced(String expression) {
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

        String combinedFirstSecond = strings[0] + strings[1];
        String combinedSecondFirst = strings[1] + strings[0];

        if (isBalanced(combinedFirstSecond) || isBalanced(combinedSecondFirst)) {
            return "Yes";
        } else {
            return "No";
        }
    }
}