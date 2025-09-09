import java.util.ArrayList;
import java.util.List;

public class HumanEval_30 {
    public List<Integer> extractPositiveNumbers(List<Integer> inputList) {
        List<Integer> positiveNumbers = new ArrayList<>();
        int index = 0;

        while (index < inputList.size()) {
            if (inputList.get(index) > 0) {
                positiveNumbers.add(inputList.get(index));
            }
            index++;
        }

        return positiveNumbers;
    }
}