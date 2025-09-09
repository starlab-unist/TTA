public class HumanEval_160 {
    public static int doAlgebra(String[] operator, int[] operand) {
        StringBuilder expression = new StringBuilder(Integer.toString(operand[0]));
        for (int i = 0; i < operator.length; i++) {
            expression.append(operator[i]).append(operand[i + 1]);
        }
        return evaluateExpression(expression.toString());
    }

    private static int evaluateExpression(String expression) {
        return new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression).intValue();
    }
}