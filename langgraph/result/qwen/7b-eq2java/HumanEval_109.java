public class HumanEval_109 {
    public static boolean checkSortedAfterRotation(int[] sequence) {
        if (sequence.length == 0) {
            return true;
        }

        int[] orderedSequence = sequence.clone();
        Arrays.sort(orderedSequence);
        int smallestElement = orderedSequence[0];
        int pivotIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == smallestElement) {
                pivotIndex = i;
                break;
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