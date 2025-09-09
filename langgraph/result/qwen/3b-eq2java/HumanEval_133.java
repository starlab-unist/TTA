public class HumanEval_133 {
    public static int calculateTotalSquaredCeilings(int[] numbers) {
        int total = 0;
        java.util.Iterator<Integer> iterator = java.util.Arrays.asList(numbers).iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            total += Math.ceil((double) number) * Math.ceil((double) number);
        }
        return total;
    }
}