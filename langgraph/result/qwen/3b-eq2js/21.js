function normalizeValues(values) {
    const smallestValue = Math.min(...values);
    const largestValue = Math.max(...values);
    const rangeValue = largestValue - smallestValue;

    const normalizedList = [];
    for (let i = 0; i < values.length; i++) {
        const value = values[i];
        const normalizedValue = (value - smallestValue) / rangeValue;
        normalizedList.push(normalizedValue);
    }

    return normalizedList;
}