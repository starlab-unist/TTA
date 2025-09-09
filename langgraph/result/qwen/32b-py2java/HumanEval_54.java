import java.util.Set;
import java.util.HashSet;

class HumanEval_54 {
    public static boolean sameChars(String s0, String s1) {
        Set<Character> set0 = new HashSet<>();
        Set<Character> set1 = new HashSet<>();
        
        for (char c : s0.toCharArray()) {
            set0.add(c);
        }
        
        for (char c : s1.toCharArray()) {
            set1.add(c);
        }
        
        return set0.equals(set1);
    }
}