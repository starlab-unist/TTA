public class HumanEval_57 {
    public static boolean checkMonotonicSequence(int[] sequence) {
        int[] ascending = sequence.clone();
        int[] descending = sequence.clone();
        
        Arrays.sort(ascending);
        Arrays.sort(descending);
        reverseArray(descending);
        
        if (Arrays.equals(sequence, ascending) || Arrays.equals(sequence, descending)) {
            return true;
        }
        return false;
    }

    private static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}