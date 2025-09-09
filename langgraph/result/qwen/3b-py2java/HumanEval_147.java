public class HumanEval_147 {

    public static int getMaxTriples(int n) {
        int[] A = new int[n];
        for (int i = 1; i <= n; i++) {
            A[i - 1] = i * i - i + 1;
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((A[i] + A[j] + A[k]) % 3 == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getMaxTriples(5)); // Example usage
    }
}