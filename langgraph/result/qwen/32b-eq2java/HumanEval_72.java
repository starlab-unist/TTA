public class HumanEval_72 {
    public boolean canItTakeOff(int[] weights, int maxWeight) {
        int totalWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
        }

        if (totalWeight > maxWeight) {
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