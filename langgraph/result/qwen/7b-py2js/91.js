function isBored(s) {
    const sentences = s.split(/[\.\?!]\s*/);
    return sentences.filter(sentence => sentence.startsWith('I ')).length;
}