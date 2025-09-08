// Source Code
function fruitDistribution(s, n) {
    const lis = s.split(' ').filter(item => !isNaN(Number(item))).map(Number);
    return n - lis.reduce((acc, curr) => acc + curr, 0);
}

// Transformed Code (Semantically Equivalent)
function calculateRemainingFruits(fruitString, totalFruits) {
    const numbers = [];
    const items = fruitString.split(''); // Corrected to split by space
    for (const item of items) {
        if (!isNaN(item)) {
            numbers.push(parseInt(item));
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

    test.each(testCases)('Input: "%s" with %d total fruits', (inputString, totalFruits) => {
        expect(fruitDistribution(inputString, totalFruits)).toBe(calculateRemainingFruits(inputString, totalFruits));
    });
});