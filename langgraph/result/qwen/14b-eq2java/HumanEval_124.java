public class HumanEval_124 {
    public static boolean check_valid_date(String d) {
        try {
            d = d.strip();
            String[] parts = d.split("-");
            int m = Integer.parseInt(parts[0]);
            int d = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);

            if (!(1 <= m && m <= 12)) {
                return false;
            }

            if ((m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) && !(1 <= d && d <= 31)) {
                return false;
            }

            if ((m == 4 || m == 6 || m == 9 || m == 11) && !(1 <= d && d <= 30)) {
                return false;
            }

            if (m == 2 && !(1 <= d && d <= 29)) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}