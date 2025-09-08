function extractIntegers(data) {
    const result = [];
    for (const item of data) {
        if (typeof item === 'number' && Number.isInteger(item)) {
            result.push(item);
        }
    }
    return result;
}