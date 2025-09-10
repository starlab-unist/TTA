import java.util.List;

public class HumanEval_74 {
    public static List<String> compareStringLists(List<String> listA, List<String> listB) {
        int lengthA = listA.stream().mapToInt(String::length).sum();
        
        int lengthB = 0;
        int index = 0;
        while (index < listB.size()) {
            lengthB += listB.get(index).length();
            index++;
        }
        
        if (lengthA <= lengthB) {
            return listA;
        }
        return listB;
    }
}