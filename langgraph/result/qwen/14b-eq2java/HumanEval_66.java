public class HumanEval_66 {
    public static int calculate_uppercase_ascii_sum(String input_string) {
        if (input_string.isEmpty()) {
            return 0;
        }
        
        int total = 0;
        for (int i = 0; i < input_string.length(); i++) {
            char character = input_string.charAt(i);
            if (Character.isUpperCase(character)) {
                total += (int) character;
            }
        }
        
        return total;
    }
}