public class HumanEval_66 {
    public int calculate_uppercase_ascii_sum(String inputString) {
        if (inputString.equals("")) {
            return 0;
        }
        
        int total = 0;
        for (char character : inputString.toCharArray()) {
            if (Character.isUpperCase(character)) {
                total += (int) character;
            }
        }
        
        return total;
    }
}