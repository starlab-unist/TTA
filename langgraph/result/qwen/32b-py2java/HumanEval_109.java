import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class HumanEval_109 {
    public static boolean moveOneBall(List<Integer> arr) {
        if (arr.isEmpty()) {
            return true;
        }
        
        Integer[] sortedArray = arr.toArray(new Integer[0]);
        Arrays.sort(sortedArray);
        
        int minValue = Collections.min(arr);
        int minIndex = arr.indexOf(minValue);
        
        List<Integer> myArr = new ArrayList<>(arr.subList(minIndex, arr.size()));
        myArr.addAll(arr.subList(0, minIndex));
        
        for (int i = 0; i < arr.size(); i++) {
            if (!myArr.get(i).equals(sortedArray[i])) {
                return false;
            }
        }
        return true;
    }
}