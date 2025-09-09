public class HumanEval_122 {
    public static int calculateSumOfSmallNumbers(int[] numbers, int count) {
        int total = 0;
        int index = 0;

        while (index < count && index < numbers.length) {
            if (String.valueOf(numbers[index]).length() <= 2) {
                total += numbers[index];
            }
            index++;
        }

        return total;
    }
}