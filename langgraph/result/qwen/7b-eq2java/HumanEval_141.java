public class HumanEval_141 {
    public static String validate_file_identifier(String filename) {
        String[] validExtensions = {"txt", "exe", "dll"};
        String[] parts = filename.rsplit("\\.", 1);
        
        if (parts.length != 2) {
            return "No";
        }
        
        String extension = parts[0];
        String name = parts[1];
        
        if (!contains(validExtensions, extension)) {
            return "No";
        }
        
        if (name.isEmpty()) {
            return "No";
        }
        
        if (!Character.isLetter(name.charAt(0))) {
            return "No";
        }
        
        long digitCount = name.chars().filter(Character::isDigit).count();
        if (digitCount > 3) {
            return "No";
        }
        
        return "Yes";
    }
    
    private static boolean contains(String[] array, String value) {
        for (String item : array) {
            if (item.equals(value)) {
                return true;
            }
        }
        return false;
    }
}