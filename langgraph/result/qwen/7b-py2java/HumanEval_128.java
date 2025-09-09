public class HumanEval_128 {
    public static Integer prodSigns(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int prod = 0;
        if (containsZero(arr)) {
            prod = 0;
        } else {
            prod = (int) Math.pow(-1, countNegatives(arr));
        }
        return prod * sumOfAbsValues(arr);
    }

    private static boolean containsZero(int[] arr) {
        for (int num : arr) {
            if (num == 0) {
                return true;
            }
        }
        return false;
    }

    private static long countNegatives(int[] arr) {
        return Arrays.stream(arr).filter(num -> num < 0).count();
    }

    private static long sumOfAbsValues(int[] arr) {
        return Arrays.stream(arr).map(Math::abs).sum();
    }
}