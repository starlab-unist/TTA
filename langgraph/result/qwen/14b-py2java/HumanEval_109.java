import java.util.Arrays;

public class HumanEval_109 {
    public static boolean moveOneBall(int[] arr) {
        if (arr.length == 0) {
            return true;
        }
        
        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArray);
        
        int minValue = Arrays.stream(arr).min().orElse(0);
        int minIndex = findIndex(arr, minValue);
        
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
    
    private static int findIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1; // Should never reach here if minValue is in arr
    }
}