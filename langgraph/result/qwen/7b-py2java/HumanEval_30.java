import java.util.ArrayList;
import java.util.List;

public class HumanEval_30 {
    public static List<Integer> getPositive(List<Integer> l) {
        List<Integer> positiveList = new ArrayList<>();
        for (Integer e : l) {
            if (e > 0) {
                positiveList.add(e);
            }
        }
        return positiveList;
    }
}