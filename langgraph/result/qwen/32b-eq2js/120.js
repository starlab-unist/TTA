function findTopKElements(sequence, count) {
    if (count === 0) {
        return [];
    }

    const sortedSequence = [...sequence].sort((a, b) => a - b);
    const topElements = sortedSequence.slice(-count);

    return topElements;
}