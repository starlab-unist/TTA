public class HumanEval_36 {
    public static int countSevensInSpecialNumbers(int limit) {
        java.util.List<Integer> specialNumbers = new java.util.ArrayList<>();
        int index = 0;
        while (index < limit) {
            if (index % 11 == 0 || index % 13 == 0) {
                specialNumbers.add(index);
            }
            index += 1;
        }

        StringBuilder concatenatedString = new StringBuilder();
        for (int number : specialNumbers) {
            concatenatedString.append(number);
        }

        int sevenCount = 0;
        int position = 0;
        while (position < concatenatedString.length()) {
            if (concatenatedString.charAt(position) == '7') {
                sevenCount += 1;
            }
            position += 1;
        }

        return sevenCount;
    }
}