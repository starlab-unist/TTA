public class HumanEval_135 {
    public int findFirstDecreaseIndex(int[] sequence) {
        int position = -1;
        int index = 1;
        while (index < sequence.length) {
            if (sequence[index] < sequence[index - 1]) {
                position = index;
            }
            index++;
        }
        return position;
    }
}