public class HumanEval_160 {
    public static int doAlgebra(String[] operator, int[] operand) {
        StringBuilder expression = new StringBuilder(Integer.toString(operand[0]));
        for (int i = 0; i < operator.length; i++) {
            expression.append(operator[i]).append(Integer.toString(operand[i + 1]));
        }
        return evaluateExpression(expression.toString());
    }

    private static int evaluateExpression(String expression) {
        try {
            return (int) java.lang.reflect.MethodHandles.lookup().findStatic(java.lang.Math.class, "parseInt", java.lang.reflect.MethodType.methodType(int.class, String.class)).invokeExact(expression);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}