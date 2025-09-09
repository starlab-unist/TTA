public class HumanEval_124 {
    public static boolean checkValidDate(String date) {
        try {
            date = date.trim();
            String[] parts = date.split("-");
            
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            
            if (!(1 <= month && month <= 12)) {
                return false;
            }
            
            if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && !(1 <= day && day <= 31)) {
                return false;
            }
            
            if ((month == 4 || month == 6 || month == 9 || month == 11) && !(1 <= day && day <= 30)) {
                return false;
            }
            
            if (month == 2 && !(1 <= day && day <= 29)) {
                return false;
            }
    
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}