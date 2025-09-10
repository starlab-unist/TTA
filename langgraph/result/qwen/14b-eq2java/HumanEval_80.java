public class HumanEval_80 {
    public static boolean check_happiness(int[] sequence) {
        if (sequence.length < 3) {
            return false;
        }

        int index = 0;
        while (index < sequence.length - 2) {
            if (sequence[index] == sequence[index + 1] ||
                sequence[index + 1] == sequence[index + 2] ||
                sequence[index] == sequence[index + 2]) {
                return false;
            }
            index += 1;
        }

        return true;
    }
}