public class HumanEval_68 {

    public static int[] pluck(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }

        int[] evens = Arrays.stream(arr)
                            .filter(x -> x % 2 == 0)
                            .toArray();

        if (evens.length == 0) {
            return new int[0];
        }

        int minEven = Arrays.stream(evens).min().getAsInt();
        int index = Arrays.asList(arr).indexOf(minEven);

        return new int[]{minEven, index};
    }
}