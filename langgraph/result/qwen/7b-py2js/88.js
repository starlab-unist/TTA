function sortArray(array) {
    return array.length === 0 ? [] : (array[0] + array[array.length - 1]) % 2 === 0 ? array.sort((a, b) => b - a) : array.sort((a, b) => a - b);
}