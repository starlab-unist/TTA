public class HumanEval_126 {

    public static boolean isSorted(int[] sequence) {
        int[] digitCount = new int[10]; // Assuming numbers are between 0 and 9
        for (int number : sequence) {
            digitCount[number]++;
        }

        if (anyDigitCountGreaterThanTwo(digitCount)) {
            return false;
        }

        int index = 1;
        while (index < sequence.length) {
            if (sequence[index - 1] > sequence[index]) {
                return false;
            }
            index++;
        }

        return true;
    }

    private static boolean anyDigitCountGreaterThanTwo(int[] digitCount) {
        for (int count : digitCount) {
            if (count > 2) {
                return true;
            }
        }
        return false;
    }
}