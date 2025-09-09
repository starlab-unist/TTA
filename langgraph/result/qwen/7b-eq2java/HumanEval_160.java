public class HumanEval_160 {
    public static int evaluateExpression(char[] operators, int[] values) {
        StringBuilder resultString = new StringBuilder(String.valueOf(values[0]));
        int index = 0;
        while (index < operators.length) {
            resultString.append(operators[index]).append(values[index + 1]);
            index++;
        }
        return (int) eval(resultString.toString());
    }

    private static double eval(String expression) {
        javax.script.ScriptEngine engine = new javax.script.ScriptEngineManager().getEngineByName("JavaScript");
        try {
            return Double.parseDouble(engine.eval(expression).toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}