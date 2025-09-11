public int countPrimeHexDigits(String hexString) {
    Set<Character> primeHexDigits = new HashSet<>(Arrays.asList('2', '3', '5', '7', 'B', 'D'));
    int count = 0;
    int index = 0;
    while (index < hexString.length()) {
        if (primeHexDigits.contains(hexString.charAt(index))) {
            count++;
        }
        index++;
    }
    return count;
}