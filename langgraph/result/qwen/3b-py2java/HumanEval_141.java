public class HumanEval_141 {

    public static String fileNameCheck(String fileName) {
        String[] suf = {"txt", "exe", "dll"};
        String[] parts = fileName.split("\\.");
        
        if (parts.length != 2) {
            return "No";
        }
        
        String extension = parts[1];
        if (!Arrays.asList(suf).contains(extension)) {
            return "No";
        }
        
        if (parts[0].isEmpty()) {
            return "No";
        }
        
        char firstChar = parts[0].charAt(0);
        if (!Character.isLetter(firstChar)) {
            return "No";
        }
        
        int digitCount = (int) parts[0].chars()
                                .filter(Character::isDigit)
                                .count();
        
        if (digitCount > 3) {
            return "No";
        }
        
        return "Yes";
    }

}