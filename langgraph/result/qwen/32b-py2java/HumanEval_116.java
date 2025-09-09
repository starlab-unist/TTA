import java.util.Arrays;
import java.util.Comparator;

public class HumanEval_116 {
    public static int[] sortArray(int[] arr) {
        Integer[] wrappedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        Arrays.sort(wrappedArray, Comparator.comparingInt((Integer x) -> Integer.bitCount(x)));
        
        return Arrays.stream(wrappedArray).mapToInt(Integer::intValue).toArray();
    }
}