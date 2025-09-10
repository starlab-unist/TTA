public class HumanEval_15 {
    public static String generateNumberSeries(int length) {
        StringBuilder numberList = new StringBuilder();
        int index = 0;

        while (index <= length) {
            numberList.append(index).append(" ");
            index++;
        }

        // Remove the trailing space
        if (numberList.length() > 0) {
            numberList.setLength(numberList.length() - 1);
        }

        return numberList.toString();
    }
}