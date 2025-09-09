public class HumanEval_136 {
    public static Pair<Integer, Integer> findExtremeValues(int[] numbers) {
        List<Integer> negativeNumbers = new ArrayList<>();
        List<Integer> positiveNumbers = new ArrayList<>();

        for (int num : numbers) {
            if (num < 0) {
                negativeNumbers.add(num);
            } else if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        Integer maxNegative = negativeNumbers.isEmpty() ? null : Collections.max(negativeNumbers);
        Integer minPositive = positiveNumbers.isEmpty() ? null : Collections.min(positiveNumbers);

        return new Pair<>(maxNegative, minPositive);
    }
}