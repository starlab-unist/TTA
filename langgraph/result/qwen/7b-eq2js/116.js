function arrangeByBinaryOnes(arr) {
    function countOnesInBinary(number) {
        return number.toString(2).split('').filter(bit => bit === '1').length;
    }
    
    return arr.sort((a, b) => {
        const onesA = countOnesInBinary(a);
        const onesB = countOnesInBinary(b);
        if (onesA !== onesB) {
            return onesA - onesB;
        }
        return a - b;
    });
}