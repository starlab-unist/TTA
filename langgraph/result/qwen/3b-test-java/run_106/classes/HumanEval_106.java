public class HumanEval_106 {

    public static List<Integer> generateAlternatingSequence(int limit) {
        List<Integer> result = new ArrayList<>();
        int index = 1;
        while (index <= limit) {
            if (index % 2 == 0) {
                int factorial = calculateFactorial(index);
                result.add(factorial);
            } else {
                int summation = calculateSummation(index);
                result.add(summation);
            }
            index++;
        }
        return result;
    }

    private static int calculateFactorial(int number) {
        int factorial = 1;
        int innerIndex = 1;
        while (innerIndex <= number) {
            factorial *= innerIndex;
            innerIndex++;
        }
        return factorial;
    }

    private static int calculateSummation(int number) {
        int summation = 0;
        int innerIndex = 1;
        while (innerIndex <= number) {
            summation += innerIndex;
            innerIndex++;
        }
        return summation;
    }
}