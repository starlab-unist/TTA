public class HumanEval_72 {

    public static boolean canItTakeOff(int[] weights, int maxWeight) {
        int totalWeight = 0;

        // Calculate total weight using a loop
        for (int weight : weights) {
            totalWeight += weight;
        }

        if (totalWeight > maxWeight) {
            return false;
        }

        int start = 0;
        int end = weights.length - 1;

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