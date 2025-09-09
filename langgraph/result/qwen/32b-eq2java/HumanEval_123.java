import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_123 {

    public List<Integer> extractOddNumbersInSequence(int startingValue) {
        List<Integer> sequenceOfOdds = new ArrayList<>();
        
        if (startingValue % 2 != 0) {
            sequenceOfOdds.add(startingValue);
        }

        int currentValue = startingValue;
        while (currentValue > 1) {
            if (currentValue % 2 == 0) {
                currentValue /= 2;
            } else {
                currentValue = currentValue * 3 + 1;
            }

            if (currentValue % 2 != 0) {
                sequenceOfOdds.add(currentValue);
            }
        }

        Collections.sort(sequenceOfOdds);
        return sequenceOfOdds;
    }
}