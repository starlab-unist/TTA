import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_116 {
    public static int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(arr, Comparator.comparingInt(x -> Integer.bitCount(x)));
        return arr;
    }
}