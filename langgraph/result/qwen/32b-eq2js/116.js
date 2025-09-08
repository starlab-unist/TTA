function arrangeByBinaryOnes(sequence) {
    function countOnesInBinary(number) {
        return number.toString(2).split('0').join('').length;
    }
    
    return sequence.sort((a, b) => {
        const onesA = countOnesInBinary(a);
        const onesB = countOnesInBinary(b);
        if (onesA === onesB) {
            return a - b;
        }
        return onesA - onesB;
    });
}