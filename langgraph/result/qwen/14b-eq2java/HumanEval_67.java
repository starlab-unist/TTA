public class HumanEval_67 {
    public static int calculateRemainingFruits(String fruitString, int totalFruits) {
        List<Integer> numbers = new ArrayList<>();
        for (String item : fruitString.split(" ")) {
            if (item.matches("\\d+")) {
                numbers.add(Integer.parseInt(item));
            }
        }
        int remainingFruits = totalFruits - numbers.stream().mapToInt(Integer::intValue).sum();
        return remainingFruits;
    }
}