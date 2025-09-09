import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanEval_33 {
    public static List<Integer> arrangeEveryThirdElement(List<Integer> inputList) {
        List<Integer> elementsToSort = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i += 3) {
            elementsToSort.add(inputList.get(i));
        }
        Collections.sort(elementsToSort);
        List<Integer> resultList = new ArrayList<>(inputList);
        for (int index = 0; index < elementsToSort.size(); index++) {
            resultList.set(index * 3, elementsToSort.get(index));
        }
        return resultList;
    }
}