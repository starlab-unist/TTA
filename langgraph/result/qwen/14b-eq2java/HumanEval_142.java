public class HumanEval_142 {
    public static int calculateModifiedSum(int[] numbers) {
        int total = 0;
        int index = 0;
        while (index < numbers.length) {
            if (index % 3 == 0) {
                total += Math.pow(numbers[index], 2);
            } else if (index % 4 == 0) {
                total += Math.pow(numbers[index], 3);
            } else {
                total += numbers[index];
            }
            index++;
        }
        return total;
    }
}