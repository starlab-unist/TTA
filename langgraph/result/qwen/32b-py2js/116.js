function sortArray(arr) {
    return arr.sort((a, b) => {
        const countOnes = num => num.toString(2).split('0').join('').length;
        return countOnes(a) - countOnes(b) || a - b;
    });
}