const FIX = `
Add more test cases.
`;

function vowelsCount(s) {
    const vowels = "aeiouAEIOU";
    let nVowels = Array.from(s).filter(c => vowels.includes(c)).length;
    if (s[s.length - 1] === 'y' || s[s.length - 1] === 'Y') {
        nVowels += 1;
    }
    return nVowels;
}