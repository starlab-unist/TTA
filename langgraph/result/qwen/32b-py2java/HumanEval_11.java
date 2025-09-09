import java.util.List;

public class HumanEval_11 {
    public String stringXor(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            char y = b.charAt(i);
            result.append(xor(x, y));
        }
        
        return result.toString();
    }

    private char xor(char i, char j) {
        if (i == j) {
            return '0';
        } else {
            return '1';
        }
    }
}