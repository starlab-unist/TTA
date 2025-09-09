public int tallyEvenIndexVowels(String inputString) {
    int vowelCount = 0;
    int index = 0;
    while (index < inputString.length()) {
        if (index % 2 == 0 && "AEIOU".indexOf(inputString.charAt(index)) != -1) {
            vowelCount++;
        }
        index++;
    }
    return vowelCount;
}