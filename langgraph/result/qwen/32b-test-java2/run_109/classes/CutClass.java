import java.util.Arrays;

class HumanEval_109 {
    public boolean checkSortedAfterRotation(int[] sequence) {
        if (sequence.length == 0) {
            return true;
        }

        int[] orderedSequence = Arrays.copyOf(sequence, sequence.length);
        Arrays.sort(orderedSequence);
        int smallestElement = Arrays.stream(sequence).min().getAsInt();
        int pivotIndex = findPivotIndex(sequence, smallestElement);

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

    private int findPivotIndex(int[] sequence, int smallestElement) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == smallestElement) {
                return i;
            }
        }
        return -1; // This line should never be reached if input assumptions are correct
    }
}