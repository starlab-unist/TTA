// Source Code
function fruitDistribution(s, n) {
    let lis = [];
    for (let i of s.split(' ')) {
        if (!isNaN(i)) {
            lis.push(parseInt(i));
        }
    }
    return n - lis.reduce((a, b) => a + b, 0);
}

// Transformed Code (Semantically Equivalent)
function calculateRemainingFruits(fruitString, totalFruits) {
    let numbers = [];
    for (let item of fruitString.split(' ')) { // Corrected the split method
        if (!isNaN(item)) {
            numbers.push(parseInt(item));
        }
    }
    let remainingFruits = totalFruits - numbers.reduce((a, b) => a + b, 0);
    return remainingFruits;
}

// Test Cases
describe('fruitDistribution vs calculateRemainingFruits equivalence tests', () => {
    const testCases = [
        ["1 2 3", 10],
        ["5 5 5", 20],
        ["", 10],
        ["10 20 30", 100],
        ["100", 150],
        ["1 2 3 4 5", 20],
        ["7 8 9", 30],
        ["0 0 0", 5],
        ["123", 200],
        ["456 789", 1500]
    ];

    test.each(testCases)('Input: "%s" with total %d', (inputString, totalFruits) => {
        expect(fruitDistribution(inputString, totalFruits)).toBe(calculateRemainingFruits(inputString, totalFruits));
    });
});