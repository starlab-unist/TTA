public class HumanEval_23 {

    public static int calculateStringLength(String text) {
        int count = 0;
        for (char character : text.toCharArray()) {
            count++;
        }
        return count;
    }
}