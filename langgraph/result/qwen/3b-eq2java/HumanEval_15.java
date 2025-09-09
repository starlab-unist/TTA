public class HumanEval_15 {
    public static String generateNumberSeries(int length) {
        StringBuilder numberList = new StringBuilder();
        int index = 0;

        while (index <= length) {
            numberList.append(index);
            numberList.append(" ");
            index++;
        }

        return numberList.toString().trim();
    }
}