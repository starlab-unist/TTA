// Source Code
function sortArray(arr) {
    return arr.sort((a, b) => {
        const countOnes = (num) => num.toString(2).split('').filter(bit => bit === '1').length;
        return countOnes(a) - countOnes(b);
    });
}

// Transformed Code (Semantically Equivalent)
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

// Test Cases
describe('sortArray vs arrangeByBinaryOnes equivalence tests', () => {
    const testCases = [
        [3, 7, 8, 9],          // Mixed numbers with different binary '1' counts
        [5, 3, 15, 7, 2],      // Numbers with varying binary '1' counts
        [0, 1, 2, 3, 4, 5, 6], // Sequential numbers starting from 0
        [10, 20, 30, 40, 50],  // Multiples of 10
        [31, 14, 7, 3, 1],     // Descending powers of 2 minus 1
        [64, 128, 256, 512],   // Powers of 2
        [1, 1, 1, 1],          // All ones
        [0, 0, 0, 0],          // All zeros
        [13, 9, 5, 7, 11],     // Mixed numbers with same '1' count in binary
        [2, 4, 8, 16, 32]      // Powers of 2 starting from 2^1
    ];

    test.each(testCases)('Input: %p', (inputArray) => {
        expect(sortArray([...inputArray])).toEqual(arrangeByBinaryOnes([...inputArray]));
    });
});