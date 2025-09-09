public class HumanEval_135 {
    public static int canArrange(int[] arr) {
        int ind = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                ind = i;
            }
        }
        return ind;
    }
}