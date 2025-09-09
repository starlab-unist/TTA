public class HumanEval_126 {

    public static boolean isSorted(int[] lst) {
        int[] countDigit = new int[100]; // Assuming the input list contains numbers between 0 and 99

        for (int i : lst) {
            countDigit[i]++;
        }

        if (any(countDigit[i] > 2 for i : lst)) {
            return false;
        }

        for (int i = 1; i < lst.length; i++) {
            if (lst[i - 1] > lst[i]) {
                return false;
            }
        }

        return true;
    }

    private static boolean any(int[] array, Predicate<Integer> predicate) {
        for (int value : array) {
            if (predicate.test(value)) {
                return true;
            }
        }
        return false;
    }
}