function extractDistinctElements(l) {
    let distinctElements = new Set(l);
    let sortedElements = Array.from(distinctElements).sort();
    return sortedElements;
}