function extractIntegers(values) {
    let result = [];
    for (let item of values) {
        if (typeof item === 'number' && Number.isInteger(item)) {
            result.push(item);
        }
    }
    return result;
}