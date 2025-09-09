import java.util.ArrayList;
import java.util.List;

public class HumanEval_100 {
    public List<Integer> makeAPile(int n) {
        List<Integer> pile = new ArrayList<>();
        int index = 0;
        while (index < n) {
            pile.add(n + 2 * index);
            index += 1;
        }
        return pile;
    }
}