import java.util.List;

public class HumanEval_68 {

    public static List<Integer> extractMinEvenAndIndex(List<Integer> sequence) {
        if (sequence == null || sequence.isEmpty()) {
            return List.of();
        }

        List<Integer> evenNumbers = new ArrayList<>();
        for (int num : sequence) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }

        if (evenNumbers.isEmpty()) {
            return List.of();
        }

        int smallestEven = Collections.min(evenNumbers);
        int positionOfSmallestEven = sequence.indexOf(smallestEven);

        return List.of(smallestEven, positionOfSmallestEven);
    }
}