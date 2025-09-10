public class HumanEval_40 {
    public static boolean check_for_zero_sum_triplets(int[] numbers) {
        int length = numbers.length;
        int index_i = 0;
        
        while (index_i < length) {
            int index_j = index_i + 1;
            while (index_j < length) {
                int index_k = index_j + 1;
                while (index_k < length) {
                    if (numbers[index_i] + numbers[index_j] + numbers[index_k] == 0) {
                        return true;
                    }
                    index_k += 1;
                }
                index_j += 1;
            }
            index_i += 1;
        }
        
        return false;
    }
}