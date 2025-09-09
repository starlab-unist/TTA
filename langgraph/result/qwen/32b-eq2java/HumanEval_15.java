public class HumanEval_15 {
    public String generateNumberSeries(int length) {
        StringBuilder numberList = new StringBuilder();
        int index = 0;

        while (index <= length) {
            numberList.append(index);
            if (index < length) {
                numberList.append(" ");
            }
            index++;
        }

        return numberList.toString();
    }
}