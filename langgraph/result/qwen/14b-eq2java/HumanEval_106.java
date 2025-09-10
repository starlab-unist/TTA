import java.util.ArrayList;
import java.util.List;

public class HumanEval_106 {
    public static List<Integer> generateAlternatingSequence(int limit) {
        List<Integer> result = new ArrayList<>();
        int index = 1;
        while (index <= limit) {
            if (index % 2 == 0) {
                int factorial = 1;
                int innerIndex = 1;
                while (innerIndex <= index) {
                    factorial *= innerIndex;
                    innerIndex++;
                }
                result.add(factorial);
            } else {
                int summation = 0;
                int innerIndex = 1;
                while (innerIndex <= index) {
                    summation += innerIndex;
                    innerIndex++;
                }
                result.add(summation);
            }
            index++;
        }
        return result;
    }
}