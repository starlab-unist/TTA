import java.util.ArrayList;
import java.util.List;

public class HumanEval_36 {

    public static int countSevensInSpecialNumbers(int limit) {
        List<Integer> specialNumbers = new ArrayList<>();
        int index = 0;
        while (index < limit) {
            if (index % 11 == 0 || index % 13 == 0) {
                specialNumbers.add(index);
            }
            index++;
        }

        StringBuilder concatenatedString = new StringBuilder();
        for (int number : specialNumbers) {
            concatenatedString.append(number);
        }

        int sevenCount = 0;
        int position = 0;
        while (position < concatenatedString.length()) {
            if (concatenatedString.charAt(position) == '7') {
                sevenCount++;
            }
            position++;
        }

        return sevenCount;
    }
}