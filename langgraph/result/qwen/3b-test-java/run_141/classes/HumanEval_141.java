public class HumanEval_141 {

    public static String validateFileIdentifier(String filename) {
        String[] validExtensions = {"txt", "exe", "dll"};
        String[] parts = filename.split("\\.", 2);
        
        if (parts.length != 2) {
            return "No";
        }
        
        String extension = parts[1];
        String name = parts[0];
        
        if (!Arrays.asList(validExtensions).contains(extension)) {
            return "No";
        }
        
        if (name.isEmpty()) {
            return "No";
        }
        
        if (!Character.isLetter(name.charAt(0))) {
            return "No";
        }
        
        int digitCount = (int) name.chars().filter(Character::isDigit).count();
        if (digitCount > 3) {
            return "No";
        }
        
        return "Yes";
    }

}