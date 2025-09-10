public class HumanEval_85 {
    public static int calculateEvenSumAtOddIndices(int[] numbers) {
        int total = 0;
        int index = 1;
        while (index < numbers.length) {
            if (numbers[index] % 2 == 0) {
                total += numbers[index];
            }
            index += 2;
        }
        return total;
    }
}