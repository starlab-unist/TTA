public class HumanEval_67 {
    public static int fruitDistribution(String s, int n) {
        String[] words = s.split(" ");
        int sum = 0;
        for (String word : words) {
            if (word.matches("\\d+")) {
                sum += Integer.parseInt(word);
            }
        }
        return n - sum;
    }
}