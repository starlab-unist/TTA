public class HumanEval_122 {
    public static int addElements(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k && i < arr.length; i++) {
            if (String.valueOf(arr[i]).length() <= 2) {
                sum += arr[i];
            }
        }
        return sum;
    }
}