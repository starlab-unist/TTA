import java.util.ArrayList;
import java.util.List;

public class HumanEval_100 {
    public static List<Integer> makeAPile(int n) {
        List<Integer> pile = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pile.add(n + 2 * i);
        }
        return pile;
    }
}