function extractIntegers(data) {
    const result = [];
    for (const item of data) {
        if (Number.isInteger(item)) {
            result.push(item);
        }
    }
    return result;
}