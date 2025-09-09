public class HumanEval_160 {

    public static int doAlgebra(String[] operator, int[] operand) {
        StringBuilder expression = new StringBuilder();
        expression.append(operand[0]);

        for (int i = 0; i < operator.length; i++) {
            expression.append(operator[i]).append(operand[i + 1]);
        }

        try {
            return Integer.parseInt(expression.toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }
}