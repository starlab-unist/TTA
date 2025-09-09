public class HumanEval_43 {
    public static boolean checkForZeroSumPairs(int[] numbers) {
        int index = 0;
        while (index < numbers.length) {
            int currentNumber = numbers[index];
            int nextIndex = index + 1;
            while (nextIndex < numbers.length) {
                if (currentNumber + numbers[nextIndex] == 0) {
                    return true;
                }
                nextIndex++;
            }
            index++;
        }
        return false;
    }
}