public class HumanEval_146 {

    public static int countSpecialNumbers(int[] numbers) {
        int total = 0;
        Iterator<Integer> iterator = Arrays.stream(numbers).iterator();

        while (iterator.hasNext()) {
            int currentNumber = iterator.next();
            if (currentNumber > 10) {
                Set<Integer> oddDigitsSet = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9));
                String numStr = Integer.toString(currentNumber);
                if (oddDigitsSet.contains(Integer.parseInt(numStr.charAt(0) + ""))
                        && oddDigitsSet.contains(Integer.parseInt(numStr.charAt(numStr.length() - 1) + ""))) {
                    total++;
                }
            }
        }

        return total;
    }
}