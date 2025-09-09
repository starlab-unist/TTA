import java.util.List;

public class HumanEval_5 {

    public static List<Integer> weaveNumbers(List<Integer> sequence, int separator) {
        if (sequence == null || sequence.isEmpty()) {
            return List.of();
        }

        List<Integer> interleaved = new ArrayList<>();
        int index = 0;

        while (index < sequence.size() - 1) {
            interleaved.addAll(List.of(sequence.get(index), separator));
            index++;
        }

        interleaved.add(sequence.get(sequence.size() - 1));

        return interleaved;
    }
}