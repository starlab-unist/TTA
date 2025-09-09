public class HumanEval_23 {
    public int calculateStringLength(String text) {
        int count = 0;
        for (char character : text.toCharArray()) {
            count += 1;
        }
        return count;
    }
}