public class HumanEval_74 {
    public static List<String> compareStringLists(List<String> lst1, List<String> lst2) {
        int lengthA = lst1.stream().mapToInt(String::length).sum();
        
        int lengthB = 0;
        int index = 0;
        while (index < lst2.size()) {
            lengthB += lst2.get(index).length();
            index++;
        }
        
        return lengthA <= lengthB ? lst1 : lst2;
    }
}