import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class HumanEval_57 {
    public boolean monotonic(List<Integer> l) {
        List<Integer> sortedList = new ArrayList<>(l);
        List<Integer> reversedSortedList = new ArrayList<>(l);
        
        Collections.sort(sortedList);
        Collections.sort(reversedList, Collections.reverseOrder());
        
        return l.equals(sortedList) || l.equals(reversedList);
    }
}