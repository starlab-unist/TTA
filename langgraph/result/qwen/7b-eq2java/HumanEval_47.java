import java.util.Arrays;

public class HumanEval_47 {
    public static double calculateMedian(int[] numbers) {
        Arrays.sort(numbers);
        int midIndex = numbers.length / 2;
        
        if (numbers.length % 2 == 1) {
            return numbers[midIndex];
        } else {
            return (numbers[midIndex - 1] + numbers[midIndex]) / 2.0;
        }
    }
}