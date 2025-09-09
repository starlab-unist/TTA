public class HumanEval_107 {
    public static Pair<Integer, Integer> countEvenOddPalindromes(int limit) {
        boolean[] isPalindrome = new boolean[limit + 1];
        
        for (int i = 1; i <= limit; i++) {
            String numStr = Integer.toString(i);
            int len = numStr.length();
            for (int j = 0; j < len / 2; j++) {
                if (numStr.charAt(j) != numStr.charAt(len - j - 1)) {
                    isPalindrome[i] = false;
                    break;
                }
            }
            if (!isPalindrome[i]) {
                isPalindrome[i] = true;
            }
        }

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 1; i <= limit; i++) {
            if (i % 2 == 1 && isPalindrome[i]) {
                oddCount++;
            } else if (i % 2 == 0 && isPalindrome[i]) {
                evenCount++;
            }
        }

        return new Pair<>(evenCount, oddCount);
    }
}