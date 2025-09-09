import java.util.ArrayList;
import java.util.List;

public class HumanEval_68 {
    public List<Integer> extractMinEvenAndIndex(List<Integer> sequence) {
        if (sequence.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> evenNumbers = new ArrayList<>();
        for (int num : sequence) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }
        if (evenNumbers.isEmpty()) {
            return new ArrayList<>();
        }

        int smallestEven = Integer.MAX_VALUE;
        for (int num : evenNumbers) {
            if (num < smallestEven) {
                smallestEven = num;
            }
        }

        int positionOfSmallestEven = sequence.indexOf(smallestEven);

        List<Integer> result = new ArrayList<>();
        result.add(smallestEven);
        result.add(positionOfSmallestEven);
        return result;
    }
}