import java.util.Arrays;

public class HumanEval_116 {

    public static int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(arr, (a, b) -> Integer.bitCount(a) - Integer.bitCount(b));
        return arr;
    }

}