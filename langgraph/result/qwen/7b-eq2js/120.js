function findTopKElements(sequence, count) {
    if (count === 0) {
        return [];
    }

    let sortedSequence = [...sequence].sort((a, b) => a - b);
    let topElements = sortedSequence.slice(-count);

    return topElements;
}