public class HumanEval_90 {

    public static Integer findSecondMinimum(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        // Convert the array to a set to remove duplicates and sort it
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            uniqueNumbers.add(number);
        }
        List<Integer> sortedUniqueNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(sortedUniqueNumbers);

        // Check if there are at least two unique numbers
        if (sortedUniqueNumbers.size() < 2) {
            return null;
        }

        // Return the second smallest number
        return sortedUniqueNumbers.get(1);
    }
}