function normalizeValues(values) {
    const smallestValue = Math.min(...values);
    const largestValue = Math.max(...values);
    const rangeValue = largestValue - smallestValue;

    const normalizedList = [];
    for (const value of values) {
        const normalizedValue = (value - smallestValue) / rangeValue;
        normalizedList.push(normalizedValue);
    }

    return normalizedList;
}