public class HumanEval_136 {
    public static Pair<Integer, Integer> largestSmallestIntegers(List<Integer> lst) {
        List<Integer> smallest = lst.stream()
                                   .filter(x -> x < 0)
                                   .collect(Collectors.toList());
        List<Integer> largest = lst.stream()
                                  .filter(x -> x > 0)
                                  .collect(Collectors.toList());

        Integer smallestValue = smallest.isEmpty() ? null : Collections.max(smallest);
        Integer largestValue = largest.isEmpty() ? null : Collections.min(largest);

        return new Pair<>(smallestValue, largestValue);
    }

    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(-10, -5, 0, 5, 10);
        Pair<Integer, Integer> result = largestSmallestIntegers(lst);
        System.out.println("Smallest: " + result.getFirst());
        System.out.println("Largest: " + result.getSecond());
    }
}

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}