import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_136 {
    public static Pair<Integer, Integer> largestSmallestIntegers(List<Integer> lst) {
        List<Integer> smallest = new ArrayList<>();
        List<Integer> largest = new ArrayList<>();

        for (Integer x : lst) {
            if (x < 0) {
                smallest.add(x);
            } else if (x > 0) {
                largest.add(x);
            }
        }

        Integer maxSmallest = smallest.isEmpty() ? null : Collections.max(smallest);
        Integer minLargest = largest.isEmpty() ? null : Collections.min(largest);

        return new Pair<>(maxSmallest, minLargest);
    }

    public static class Pair<T, U> {
        public final T first;
        public final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}