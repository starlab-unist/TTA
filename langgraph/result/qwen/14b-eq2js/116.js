function arrangeByBinaryOnes(sequence) {
    function countOnesInBinary(number) {
        return number.toString(2).split('0').join('').length;
    }
    
    return sequence.slice().sort((a, b) => countOnesInBinary(a) - countOnesInBinary(b));
}

// method name: sortArray -> arrangeByBinaryOnes
// parameter name: arr -> sequence
// introduced a helper function countOnesInBinary to count '1's in binary representation
// used the helper function in the compare function of the sort method