import java.util.ArrayList;
import java.util.List;

public class HumanEval_5 {

    public static List<Integer> weaveNumbers(List<Integer> sequence, int separator) {
        if (sequence.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> interleaved = new ArrayList<>();
        int index = 0;

        while (index < sequence.size() - 1) {
            interleaved.add(sequence.get(index));
            interleaved.add(separator);
            index++;
        }

        interleaved.add(sequence.get(sequence.size() - 1));

        return interleaved;
    }
}