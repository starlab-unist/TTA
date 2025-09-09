public class HumanEval_160 {
    public static int evaluateExpression(String[] operators, int[] values) {
        StringBuilder resultString = new StringBuilder(Integer.toString(values[0]));
        int index = 0;
        while (index < operators.length) {
            resultString.append(operators[index]).append(Integer.toString(values[index + 1]));
            index++;
        }
        return evaluate(resultString.toString());
    }

    private static int evaluate(String expression) {
        // Simple evaluation logic for demonstration purposes
        // This does not handle complex expressions or error checking
        return new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression).intValue();
    }
}