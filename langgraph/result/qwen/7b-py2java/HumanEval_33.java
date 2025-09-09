import java.util.Arrays;

public class HumanEval_33 {
    public static int[] sortThird(int[] arr) {
        int[] thirdElements = new int[arr.length / 3];
        for (int i = 0; i < thirdElements.length; i++) {
            thirdElements[i] = arr[i * 3];
        }
        Arrays.sort(thirdElements);
        for (int i = 0; i < thirdElements.length; i++) {
            arr[i * 3] = thirdElements[i];
        }
        return arr;
    }
}