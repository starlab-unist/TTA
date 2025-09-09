public class HumanEval_136 {

    public static int[] findExtremeValues(int[] numbers) {
        int[] result = new int[2];

        int maxNegative = Integer.MIN_VALUE;
        int minPositive = Integer.MAX_VALUE;

        for (int num : numbers) {
            if (num < 0 && num > maxNegative) {
                maxNegative = num;
            }
            if (num > 0 && num < minPositive) {
                minPositive = num;
            }
        }

        if (maxNegative == Integer.MIN_VALUE) {
            result[0] = -1; // Indicate no negative numbers
        } else {
            result[0] = maxNegative;
        }

        if (minPositive == Integer.MAX_VALUE) {
            result[1] = 1; // Indicate no positive numbers
        } else {
            result[1] = minPositive;
        }

        return result;
    }
}