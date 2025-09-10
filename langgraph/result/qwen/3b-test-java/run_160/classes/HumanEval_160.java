public class HumanEval_160 {

    public static double evaluateExpression(String[] operators, double[] values) {
        String resultString = String.valueOf(values[0]);
        int index = 0;
        while (index < operators.length) {
            resultString += operators[index] + String.valueOf(values[index + 1]);
            index++;
        }
        try {
            return Double.parseDouble(resultString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }
}