public class HumanEval_78 {
    public static int countPrimeHexDigits(String hexString) {
        String primeHexDigits = "2357BD";
        int count = 0;
        int index = 0;
        while (index < hexString.length()) {
            if (primeHexDigits.indexOf(hexString.charAt(index)) != -1) {
                count += 1;
            }
            index += 1;
        }
        return count;
    }
}