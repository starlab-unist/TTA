public class HumanEval_109 {

    public static boolean checkSortedAfterRotation(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return true;
        }

        int[] orderedSequence = sequence.clone();
        java.util.Arrays.sort(orderedSequence);

        int smallestElement = Integer.MAX_VALUE;
        int pivotIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] < smallestElement) {
                smallestElement = sequence[i];
                pivotIndex = i;
            }
        }

        int[] rotatedSequence = new int[sequence.length];
        System.arraycopy(sequence, pivotIndex, rotatedSequence, 0, sequence.length - pivotIndex);
        System.arraycopy(sequence, 0, rotatedSequence, sequence.length - pivotIndex, pivotIndex);

        for (int i = 0; i < sequence.length; i++) {
            if (rotatedSequence[i] != orderedSequence[i]) {
                return false;
            }
        }

        return true;
    }
}