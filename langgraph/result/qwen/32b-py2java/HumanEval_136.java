import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_136 {

    public static Integer[] largestSmallestIntegers(List<Integer> lst) {
        List<Integer> smallest = lst.stream().filter(x -> x < 0).collect(Collectors.toList());
        List<Integer> largest = lst.stream().filter(x -> x > 0).collect(Collectors.toList());

        Integer smallestValue = smallest.isEmpty() ? null : smallest.stream().max(Integer::compareTo).orElse(null);
        Integer largestValue = largest.isEmpty() ? null : largest.stream().min(Integer::compareTo).orElse(null);

        return new Integer[]{smallestValue, largestValue};
    }
}