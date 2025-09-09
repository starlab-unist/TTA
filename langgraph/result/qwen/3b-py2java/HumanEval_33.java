import java.util.ArrayList;
import java.util.Collections;

public class HumanEval_33 {
    public static ArrayList<Integer> sortThird(ArrayList<Integer> l) {
        ArrayList<Integer> thirdElements = new ArrayList<>();
        
        // Extract every third element starting from index 2
        for (int i = 2; i < l.size(); i += 3) {
            thirdElements.add(l.get(i));
        }
        
        // Sort the extracted elements
        Collections.sort(thirdElements);
        
        // Place the sorted elements back into their original positions
        int sortedIndex = 0;
        for (int i = 2; i < l.size(); i += 3) {
            l.set(i, thirdElements.get(sortedIndex++));
        }
        
        return l;
    }
}