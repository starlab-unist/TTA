function tallyEvenIndexVowels(inputString) {
    let vowelCount = 0;
    let index = 0;
    while (index < inputString.length) {
        if (index % 2 === 0 && "AEIOU".includes(inputString[index])) {
            vowelCount += 1;
        }
        index += 1;
    }
    return vowelCount;
}