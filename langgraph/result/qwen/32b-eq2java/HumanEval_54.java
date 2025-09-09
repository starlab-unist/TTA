import java.util.Set;
import java.util.HashSet;

public class HumanEval_54 {
    public boolean compareCharacterSets(String stringOne, String stringTwo) {
        Set<Character> setOfCharsOne = new HashSet<>();
        Set<Character> setOfCharsTwo = new HashSet<>();
        
        for (char c : stringOne.toCharArray()) {
            setOfCharsOne.add(c);
        }
        
        for (char c : stringTwo.toCharArray()) {
            setOfCharsTwo.add(c);
        }
        
        return setOfCharsOne.equals(setOfCharsTwo);
    }
}