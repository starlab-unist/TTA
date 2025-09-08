const FIX = `
Add more test cases.
`;

function vowelsCount(s) {
    const vowels = "aeiouAEIOU";
    let nVowels = Array.from(s).reduce((count, c) => count + (vowels.includes(c) ? 1 : 0), 0);
    if (s[s.length - 1] === 'y' || s[s.length - 1] === 'Y') {
        nVowels += 1;
    }
    return nVowels;
}