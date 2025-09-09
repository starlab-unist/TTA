public class HumanEval_128 {
    public static Integer prodSigns(int[] arr) {
        if (arr.length == 0) return null;
        int countNegatives = 0;
        int sumOfAbsValues = 0;
        boolean containsZero = false;

        for (int num : arr) {
            if (num == 0) {
                containsZero = true;
            }
            if (num < 0) {
                countNegatives++;
            }
            sumOfAbsValues += Math.abs(num);
        }

        int prod = containsZero ? 0 : (countNegatives % 2 == 0) ? 1 : -1;
        return prod * sumOfAbsValues;
    }
}