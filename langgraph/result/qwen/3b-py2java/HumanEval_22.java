import java.util.List;
import java.util.ArrayList;

public class HumanEval_22 {

    public static List<Integer> filterIntegers(List<Object> values) {
        List<Integer> integers = new ArrayList<>();
        for (Object value : values) {
            if (value instanceof Integer) {
                integers.add((Integer) value);
            }
        }
        return integers;
    }
}