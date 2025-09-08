function sortArray(array) {
    return array.length === 0 ? [] : array.sort((a, b) => (a + b) % 2 === 0 ? -1 : 1);
}