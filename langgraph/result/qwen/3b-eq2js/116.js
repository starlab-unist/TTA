function arrangeByBinaryOnes(sequence) {
    function countOnesInBinary(number) {
        return number.toString(2).split('').filter(char => char === '1').length;
    }

    return sequence.sort((a, b) => countOnesInBinary(a) - countOnesInBinary(b));
}