function sortArray(arr) {
    return arr.sort((a, b) => a.toString(2).split('0').join('').length - b.toString(2).split('0').join('').length);
}