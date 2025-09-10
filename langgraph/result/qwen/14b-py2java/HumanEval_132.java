public class HumanEval_132 {
    public static boolean isNested(String string) {
        List<Integer> openingBracketIndex = new ArrayList<>();
        List<Integer> closingBracketIndex = new ArrayList<>();
        
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '[') {
                openingBracketIndex.add(i);
            } else {
                closingBracketIndex.add(i);
            }
        }
        
        Collections.reverse(closingBracketIndex);
        
        int cnt = 0;
        int i = 0;
        int l = closingBracketIndex.size();
        
        for (int idx : openingBracketIndex) {
            if (i < l && idx < closingBracketIndex.get(i)) {
                cnt++;
                i++;
            }
        }
        
        return cnt >= 2;
    }
}