public class HumanEval_72 {
    public static boolean can_it_take_off(int[] weights, int max_weight) {
        int total_weight = 0;
        for (int weight : weights) {
            total_weight += weight;
        }

        if (total_weight > max_weight) {
            return false;
        }

        int start = 0, end = weights.length - 1;
        while (start < end) {
            if (weights[start] != weights[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}