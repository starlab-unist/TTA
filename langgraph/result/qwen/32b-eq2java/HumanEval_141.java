public class HumanEval_141 {
    public String validateFileIdentifier(String filename) {
        String[] validExtensions = {"txt", "exe", "dll"};
        String[] parts = filename.split("\\.", 2);
        
        if (parts.length != 2) {
            return "No";
        }
        
        String extension = parts[1];
        String name = parts[0];
        
        boolean isValidExtension = false;
        for (String ext : validExtensions) {
            if (extension.equals(ext)) {
                isValidExtension = true;
                break;
            }
        }
        
        if (!isValidExtension) {
            return "No";
        }
        
        if (name.isEmpty()) {
            return "No";
        }
        
        if (!Character.isLetter(name.charAt(0))) {
            return "No";
        }
        
        int digitCount = 0;
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        
        if (digitCount > 3) {
            return "No";
        }
        
        return "Yes";
    }
}