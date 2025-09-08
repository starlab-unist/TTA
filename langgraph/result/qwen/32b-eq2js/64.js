const FIX = `
Add more test cases.
`;

function tallyVowels(inputString) {
    const vowelSet = "aeiouAEIOU";
    let vowelCounter = 0;

    for (let character of inputString) {
        if (vowelSet.includes(character)) {
            vowelCounter += 1;
        }
    }

    if (inputString.endsWith('y') || inputString.endsWith('Y')) {
        vowelCounter += 1;
    }

    return vowelCounter;
}