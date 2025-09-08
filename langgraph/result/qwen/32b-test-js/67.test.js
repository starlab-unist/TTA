// Source Code
function fruitDistribution(s, n) {
    const lis = [];
    s.split(' ').forEach(i => {
        if (!isNaN(i)) {
            lis.push(parseInt(i, 10));
        }
    });
    return n - lis.reduce((acc, val) => acc + val, 0);
}

// Transformed Code (Semantically Equivalent)
function calculateRemainingFruits(fruitString, totalFruits) {
    const numbers = [];
    for (const item of fruitString.split(' ')) { // Fixed the split method
        if (!isNaN(item)) {
            numbers.push(parseInt(item, 10));
        }
    }
    const remainingFruits = totalFruits - numbers.reduce((sum, num) => sum + num, 0);
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

    test.each(testCases)('Input: "%s", %d', (inputString, inputNumber) => {
        expect(fruitDistribution(inputString, inputNumber)).toBe(calculateRemainingFruits(inputString, inputNumber))
    });
});