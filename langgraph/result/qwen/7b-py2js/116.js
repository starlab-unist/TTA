function sortArray(arr) {
    return arr.sort((a, b) => {
        const countOnes = (num) => num.toString(2).split('').filter(bit => bit === '1').length;
        return countOnes(a) - countOnes(b);
    });
}