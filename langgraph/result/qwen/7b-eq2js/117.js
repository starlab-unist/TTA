function filterWordsByConsonantCount(s, n) {
    const selectedWords = [];
    const words = s.split(' ');

    for (let word of words) {
        let consonantCounter = 0;
        let index = 0;
        while (index < word.length) {
            if (!'aeiou'.includes(word[index].toLowerCase())) {
                consonantCounter++;
            }
            index++;
        }

        if (consonantCounter === n) {
            selectedWords.push(word);
        }
    }

    return selectedWords;
}

// Example usage:
const result = filterWordsByConsonantCount("The quick brown fox jumps over the lazy dog", 3);
console.log(result); // Output: ["quick", "brown"]