import java.util.ArrayList;
import java.util.List;

public class HumanEval_42 {
    public List<Integer> incrementElements(List<Integer> inputList) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < inputList.size()) {
            result.add(inputList.get(index) + 1);
            index++;
        }
        return result;
    }
}