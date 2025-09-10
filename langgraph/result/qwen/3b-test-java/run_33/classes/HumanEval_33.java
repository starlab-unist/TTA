public class HumanEval_33 {
    public static List<Integer> arrangeEveryThirdElement(List<Integer> inputList) {
        List<Integer> elementsToSort = new ArrayList<>(inputList.subList(0, inputList.size()));
        Collections.sort(elementsToSort);
        
        List<Integer> resultList = new ArrayList<>(inputList);
        int sortIndex = 0;
        
        for (int i = 0; i < resultList.size(); i += 3) {
            resultList.set(i, elementsToSort.get(sortIndex));
            sortIndex++;
        }
        
        return resultList;
    }
}