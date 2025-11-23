function intersperse(numbers, delimiter) {
    if (numbers.length === 0) {
        return [];
    }

    const result = [];

    for (let i = 0; i < numbers.length - 1; i++) {
        result.push(numbers[i]);
        result.push(delimiter);
    }

    result.push(numbers[numbers.length - 1]);

    return result;
}