function isBored(S) {
    const sentences = S.split(/(?<=[.?!])\s+/);
    return sentences.reduce((count, sentence) => count + (sentence.startsWith('I ')), 0);
}