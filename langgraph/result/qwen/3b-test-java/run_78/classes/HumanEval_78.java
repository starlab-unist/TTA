public class HumanEval_78 {

    public static int countPrimeHexDigits(String hexString) {
        Set<Character> primeHexDigits = new HashSet<>();
        primeHexDigits.add('2');
        primeHexDigits.add('3');
        primeHexDigits.add('5');
        primeHexDigits.add('7');
        primeHexDigits.add('B');
        primeHexDigits.add('D');

        int count = 0;
        int index = 0;

        while (index < hexString.length()) {
            char currentChar = hexString.charAt(index);
            if (primeHexDigits.contains(currentChar)) {
                count++;
            }
            index++;
        }

        return count;
    }
}