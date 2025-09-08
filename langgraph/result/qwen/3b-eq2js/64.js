const FIX = `
Add more test cases.
`;

function tallyVowels(inputString) {
    const vowelSet = "aeiouAEIOU";
    let vowelCounter = 0;

    for (let i = 0; i < inputString.length; i++) {
        const character = inputString[i];
        if (vowelSet.includes(character)) {
            vowelCounter++;
        }
    }

    if (inputString.endsWith('y') || inputString.endsWith('Y')) {
        vowelCounter++;
    }

    return vowelCounter;
}

// method name: vowels_count -> tallyVowels
// parameter name: s -> inputString
// variable name: vowels -> vowelSet, n_vowels -> vowelCounter
// replaced sum with for loop for counting vowels
// used str.endsWith() method for checking the last character