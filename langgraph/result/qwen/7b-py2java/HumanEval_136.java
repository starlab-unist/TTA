import java.util.List;
import java.util.ArrayList;

public class HumanEval_136 {
    public static Pair<Integer, Integer> largestSmallestIntegers(List<Integer> lst) {
        List<Integer> smallest = new ArrayList<>();
        List<Integer> largest = new ArrayList<>();

        for (int x : lst) {
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

    // Helper class for returning two values
    public static class Pair<T1, T2> {
        private T1 first;
        private T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public T1 getFirst() {
            return first;
        }

        public T2 getSecond() {
            return second;
        }
    }
}