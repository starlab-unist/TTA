public class HumanEval_160 {
    public static double doAlgebra(String[] operator, double[] operand) {
        StringBuilder expression = new StringBuilder();
        expression.append(operand[0]);
        for (int i = 0; i < operator.length; i++) {
            expression.append(operator[i]).append(operand[i + 1]);
        }
        return Double.parseDouble(new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression.toString()).toString());
    }
}