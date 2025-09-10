import java.util.Arrays;

public class HumanEval_109 {
    public static boolean checkSortedAfterRotation(int[] sequence) {
        if (sequence.length == 0) {
            return true;
        }

        int[] orderedSequence = Arrays.copyOf(sequence, sequence.length);
        Arrays.sort(orderedSequence);
        int smallestElement = Arrays.stream(sequence).min().orElse(Integer.MAX_VALUE);
        int pivotIndex = findIndex(sequence, smallestElement);

        int[] rotatedSequence = new int[sequence.length];
        System.arraycopy(sequence, pivotIndex, rotatedSequence, 0, sequence.length - pivotIndex);
        System.arraycopy(sequence, 0, rotatedSequence, sequence.length - pivotIndex, pivotIndex);

        for (int idx = 0; idx < sequence.length; idx++) {
            if (rotatedSequence[idx] != orderedSequence[idx]) {
                return false;
            }
        }

        return true;
    }

    private static int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}