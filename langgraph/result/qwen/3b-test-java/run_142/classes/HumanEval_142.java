public class HumanEval_142 {

    public static int calculateModifiedSum(int[] numbers) {
        int total = 0;
        int index = 0;
        while (index < numbers.length) {
            if (index % 3 == 0) {
                total += numbers[index] * numbers[index];
            } else if (index % 4 == 0) {
                total += numbers[index] * numbers[index] * numbers[index];
            }
            index++;
        }
        return total;
    }

}