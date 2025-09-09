import java.util.ArrayList;
import java.util.Arrays;

public class HumanEval_68 {
    public static ArrayList<Integer> extractMinEvenAndIndex(ArrayList<Integer> sequence) {
        if (sequence.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for (int num : sequence) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }

        if (evenNumbers.isEmpty()) {
            return new ArrayList<>();
        }

        int smallestEven = Collections.min(evenNumbers);
        int positionOfSmallestEven = sequence.indexOf(smallestEven);

        return new ArrayList<>(Arrays.asList(smallestEven, positionOfSmallestEven));
    }
}