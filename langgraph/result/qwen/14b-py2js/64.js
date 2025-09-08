const FIX = `
Add more test cases.
`;

function vowelsCount(s) {
    const vowels = "aeiouAEIOU";
    let nVowels = 0;
    for (let c of s) {
        if (vowels.includes(c)) {
            nVowels++;
        }
    }
    if (s[s.length - 1] === 'y' || s[s.length - 1] === 'Y') {
        nVowels++;
    }
    return nVowels;
}