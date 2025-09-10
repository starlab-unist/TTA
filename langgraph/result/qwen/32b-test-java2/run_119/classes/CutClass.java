class HumanEval_119 {
    public String validateParenthesesCombinations(String[] strings) {
        boolean isBalanced(String expression) {
            int balance = 0;
            for (char ch : expression.toCharArray()) {
                if (ch == '(') {
                    balance++;
                } else if (ch == ')') {
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

        return isBalanced(combinedFirstSecond) || isBalanced(combinedSecondFirst) ? "Yes" : "No";
    }
}