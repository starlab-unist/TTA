function findNearestIsolatedVowel(sequence) {
    if (sequence.length < 3) {
        return "";
    }

    const vowelSet = new Set(["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]);
    let index = sequence.length - 3;

    while (index > 0) {
        if (vowelSet.has(sequence[index])) {
            if (!vowelSet.has(sequence[index + 1]) && !vowelSet.has(sequence[index - 1])) {
                return sequence[index];
            }
        }
        index--;
    }

    return "";
}