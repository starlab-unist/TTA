public class HumanEval_124 {

    public static boolean validDate(String date) {
        try {
            date = date.strip();
            String[] parts = date.split("-");
            if (parts.length != 3) {
                return false;
            }

            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            if (month < 1 || month > 12) {
                return false;
            }
            if (month == 2 && day < 1 || day > 29) {
                return false;
            }
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day < 1 || day > 30) {
                return false;
            }
            if (month in [1,3,5,7,8,10,12] && day < 1 || day > 31) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}