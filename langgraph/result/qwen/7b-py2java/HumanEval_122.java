import java.util.Arrays;

public class HumanEval_122 {
    public static int addElements(int[] arr, int k) {
        return Arrays.stream(arr).limit(k).filter(elem -> String.valueOf(elem).length() <= 2).sum();
    }
}