public class HumanEval_47 {

    public static double calculateMedian(List<Double> numbers) {
        Collections.sort(numbers);
        int midIndex = numbers.size() / 2;

        if (numbers.size() % 2 == 1) {
            return numbers.get(midIndex);
        } else {
            return (numbers.get(midIndex - 1) + numbers.get(midIndex)) / 2.0;
        }
    }
}