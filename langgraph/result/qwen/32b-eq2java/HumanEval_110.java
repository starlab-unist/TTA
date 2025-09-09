public class HumanEval_110 {
    public String compareParity(int[] listA, int[] listB) {
        int oddCount = 0;
        int evenCount = 0;
        int index = 0;
        
        while (index < listA.length) {
            if (listA[index] % 2 != 0) {
                oddCount += 1;
            }
            index += 1;
        }
        
        index = 0;
        while (index < listB.length) {
            if (listB[index] % 2 == 0) {
                evenCount += 1;
            }
            index += 1;
        }
        
        return evenCount >= oddCount ? "YES" : "NO";
    }
}