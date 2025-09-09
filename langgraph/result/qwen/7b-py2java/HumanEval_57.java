import java.util.Arrays;

public class HumanEval_57 {
    public static boolean monotonic(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        int[] reversedSortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(reversedSortedArr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sortedArr[i] && arr[i] != reversedSortedArr[i]) {
                return false;
            }
        }
        return true;
    }
}