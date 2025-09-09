import java.util.ArrayList;
import java.util.List;

public class HumanEval_100 {
    public List<Integer> constructStack(int size) {
        List<Integer> pile = new ArrayList<>();
        int index = 0;
        while (index < size) {
            pile.add(size + 2 * index);
            index++;
        }
        return pile;
    }
}