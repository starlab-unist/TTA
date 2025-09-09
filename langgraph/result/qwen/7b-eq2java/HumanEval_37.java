import java.util.ArrayList;
import java.util.List;

public class HumanEval_37 {
    public static List<Integer> sortEven(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                evens.add(numbers.get(i));
            } else {
                odds.add(numbers.get(i));
            }
        }

        evens.sort(null);

        int index = 0;
        while (index < odds.size()) {
            ans.add(evens.get(index));
            ans.add(odds.get(index));
            index++;
        }

        if (evens.size() > odds.size()) {
            ans.add(evens.get(evens.size() - 1));
        }

        return ans;
    }
}