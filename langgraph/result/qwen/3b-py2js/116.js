function sortArray(arr) {
    return arr.sort((a, b) => {
        const countOnesA = bin(a).slice(2).split('').filter(char => char === '1').length;
        const countOnesB = bin(b).slice(2).split('').filter(char => char === '1').length;
        return countOnesA - countOnesB;
    });
}

function bin(n) {
    return n.toString(2);
}