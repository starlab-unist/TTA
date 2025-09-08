function evenLengthSortedElements(sequence) {
    sequence.sort();
    const filteredSequence = sequence.filter(element => element.length % 2 === 0);
    return filteredSequence.sort((a, b) => a.length - b.length);
}