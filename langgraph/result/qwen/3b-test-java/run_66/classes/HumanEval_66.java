public class HumanEval_66 {
    public static int calculateUppercaseAsciiSum(String inputString) {
        if (inputString == "") {
            return 0;
        }

        int total = 0;
        for (char character : inputString.toCharArray()) {
            if (Character.isUpperCase(character)) {
                total += (int) character;
            }
        }

        return total;
    }
}