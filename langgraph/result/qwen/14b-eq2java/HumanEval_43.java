public class HumanEval_43 {
    public static boolean check_for_zero_sum_pairs(int[] numbers) {
        int index = 0;
        while (index < numbers.length) {
            int current_number = numbers[index];
            int next_index = index + 1;
            while (next_index < numbers.length) {
                if (current_number + numbers[next_index] == 0) {
                    return true;
                }
                next_index += 1;
            }
            index += 1;
        }
        return false;
    }
}