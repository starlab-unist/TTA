public class HumanEval_160 {
    public static double evaluateExpression(String[] operators, double[] values) {
        StringBuilder resultString = new StringBuilder();
        resultString.append(values[0]);
        int index = 0;
        while (index < operators.length) {
            resultString.append(operators[index]).append(values[index + 1]);
            index++;
        }
        return Double.parseDouble(resultString.toString());
    }
}