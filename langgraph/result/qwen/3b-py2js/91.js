function isBored(S) {
    const sentences = S.split(/[\.\?\!]\s*/);
    return sentences.filter(sentence => sentence.startsWith('I ')).length;
}