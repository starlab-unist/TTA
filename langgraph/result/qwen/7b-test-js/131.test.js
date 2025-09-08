// Source Code
function digits(n) {
    let product = 1;
    let oddCount = 0;
    const digits = n.toString().split('');

    for (let i = 0; i < digits.length; i++) {
        const intDigit = parseInt(digits[i], 10);
        if (intDigit % 2 === 1) {
            product *= intDigit;
            oddCount++;
        }
    }

    if (oddCount === 0) {
        return 0;
    } else {
        return product;
    }
}

// Transformed Code (Semantically Equivalent)
function calculateOddDigitProduct(n) {
    let product = 1;
    let oddCount = 0;
    const digits = n.toString().split('');

    for (let i = 0; i < digits.length; i++) {
        const currentDigit = parseInt(digits[i]);
        if (currentDigit % 2 !== 0) {
            product *= currentDigit;
            oddCount++;
        }
    }

    return oddCount > 0 ? product : 0;
}

// Test Cases
describe('digits vs calculateOddDigitProduct equivalence tests', () => {
    const testCases = [
        123456789,
        2468,
        13579,
        11111,
        0,
        987654321,
        2222222,
        123,
        555555,
        9
    ];

    test.each(testCases)('Input: %d', (inputNumber) => {
        expect(digits(inputNumber)).toBe(calculateOddDigitProduct(inputNumber));
    });
});