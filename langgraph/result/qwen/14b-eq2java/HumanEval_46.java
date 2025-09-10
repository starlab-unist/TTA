public class HumanEval_46 {
    public static int calculateCustomFibonacci(int index) {
        int[] sequence = {0, 0, 2, 0};
        if (index < 4) {
            return sequence[index];
        }

        int currentIndex = 4;
        while (currentIndex <= index) {
            int nextValue = sequence[3] + sequence[2] + sequence[1] + sequence[0];
            for (int i = 0; i < 3; i++) {
                sequence[i] = sequence[i + 1];
            }
            sequence[3] = nextValue;
            currentIndex++;
        }

        return sequence[3];
    }
}