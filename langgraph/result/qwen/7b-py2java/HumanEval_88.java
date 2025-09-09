import java.util.Arrays;

public class HumanEval_88 {
    public static int[] sortArray(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }
        
        boolean reverse = (array[0] + array[array.length - 1]) % 2 == 0;
        Arrays.sort(array);
        
        if (reverse) {
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
        }
        
        return array;
    }
}