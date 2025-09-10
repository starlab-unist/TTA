public class HumanEval_135 {
    public static int canArrange(int[] arr) {
        int ind = -1;
        int i = 1;
        while (i < arr.length) {
            if (arr[i] < arr[i - 1]) {
                ind = i;
            }
            i += 1;
        }
        return ind;
    }
}