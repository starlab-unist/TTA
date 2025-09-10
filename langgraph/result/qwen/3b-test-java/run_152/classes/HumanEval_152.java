public class HumanEval_152 {
    public static List<Double> evaluateDifference(double[] actual, double[] playerGuess) {
        List<Double> differences = new ArrayList<>();
        int index = 0;
        while (index < actual.length) {
            differences.add(Math.abs(actual[index] - playerGuess[index]));
            index++;
        }
        return differences;
    }
}