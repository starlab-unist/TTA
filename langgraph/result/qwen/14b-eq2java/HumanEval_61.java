public class HumanEval_61 {
    public static boolean validate_parentheses(String sequence) {
        int balance = 0;
        int index = 0;
        while (index < sequence.length()) {
            if (sequence.charAt(index) == '(') {
                balance += 1;
            } else if (sequence.charAt(index) == ')') {
                balance -= 1;
            }
            if (balance < 0) {
                return false;
            }
            index += 1;
        }
        return balance == 0;
    }
}