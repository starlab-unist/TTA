import java.util.Arrays;

public class HumanEval_109 {
    public static boolean moveOneBall(int[] arr) {
        if (arr.length == 0) {
            return true;
        }
        
        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArray);
        
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }
        
        int[] myArr = new int[arr.length];
        System.arraycopy(arr, minIndex, myArr, 0, arr.length - minIndex);
        System.arraycopy(arr, 0, myArr, arr.length - minIndex, minIndex);
        
        for (int i = 0; i < arr.length; i++) {
            if (myArr[i] != sortedArray[i]) {
                return false;
            }
        }
        
        return true;
    }
}