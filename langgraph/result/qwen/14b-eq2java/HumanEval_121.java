public class HumanEval_121 {
    public static int calculate_odd_sum_at_even_indices(int[] numbers) {
        int total = 0;
        int index = 0;
        while (index < numbers.length) {
            if (index % 2 == 0 && numbers[index] % 2 == 1) {
                total += numbers[index];
            }
            index += 1;
        }
        return total;
    }
}