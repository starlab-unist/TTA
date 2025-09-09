public class HumanEval_88 {

    public static int[] sortArray(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }
        boolean isEvenSum = (array[0] + array[array.length - 1]) % 2 == 0;
        Arrays.sort(array);
        if (isEvenSum) {
            reverseArray(array);
        }
        return array;
    }

    private static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}