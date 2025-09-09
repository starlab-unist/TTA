public class HumanEval_73 {

    public static int minimalAdjustments(int[] sequence) {
        int adjustmentsNeeded = 0;
        int index = 0;
        while (index < sequence.length / 2) {
            if (sequence[index] != sequence[sequence.length - index - 1]) {
                adjustmentsNeeded++;
            }
            index++;
        }
        return adjustmentsNeeded;
    }
}