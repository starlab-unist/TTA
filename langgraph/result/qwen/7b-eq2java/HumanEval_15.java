public class HumanEval_15 {
    public static String stringSequence(int n) {
        StringBuilder numberList = new StringBuilder();
        int index = 0;

        while (index <= n) {
            if (index > 0) {
                numberList.append(" ");
            }
            numberList.append(index);
            index++;
        }

        return numberList.toString();
    }
}