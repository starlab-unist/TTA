public class HumanEval_124 {

    public static boolean checkValidDate(String d) {
        try {
            d = d.trim();
            String[] parts = d.split("-");
            
            int m = Integer.parseInt(parts[0]);
            int d = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            
            if (!isValidMonth(m)) {
                return false;
            }
            
            if (m == 2 && !isLeapYear(y)) {
                return false;
            }
            
            if (!isValidDay(m, d)) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        
        return true;
    }

    private static boolean isValidMonth(int m) {
        return m >= 1 && m <= 12;
    }

    private static boolean isLeapYear(int y) {
        return y % 4 == 0 && (y % 100 != 0 || y % 400 == 0);
    }

    private static boolean isValidDay(int m, int d) {
        switch (m) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return d >= 1 && d <= 31;
            case 4: case 6: case 9: case 11:
                return d >= 1 && d <= 30;
            case 2:
                return d >= 1 && d <= 29;
            default:
                return false;
        }
    }
}