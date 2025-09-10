import java.util.List;

public class HumanEval_3 {

    public static boolean checkNegativeBalance(List<Integer> transactions) {
        int currentBalance = 0;

        int index = 0;
        while (index < transactions.size()) {
            currentBalance += transactions.get(index);
            if (currentBalance < 0) {
                return true;
            }
            index += 1;
        }

        return false;
    }
}