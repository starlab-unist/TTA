import java.util.List;

public class HumanEval_74 {
    public List<String> compareStringLists(List<String> listA, List<String> listB) {
        int lengthA = 0;
        for (String string : listA) {
            lengthA += string.length();
        }

        int lengthB = 0;
        int index = 0;
        while (index < listB.size()) {
            lengthB += listB.get(index).length();
            index++;
        }

        return (lengthA <= lengthB) ? listA : listB;
    }
}