function extractDistinctElements(inputList) {
    const distinctElements = new Set(inputList);
    const sortedElements = Array.from(distinctElements).sort();
    return sortedElements;
}