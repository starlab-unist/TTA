// Source Code
function digits(n) {
    let product = 1;
    let oddCount = 0;
    for (let digit of String(n)) {
        let intDigit = parseInt(digit, 10);
        if (intDigit % 2 === 1) {
            product *= intDigit;
            oddCount++;
        }
    }
    return oddCount === 0 ? 0 : product;
}

// Transformed Code (Semantically Equivalent)
function calculateOddDigitProduct(number) {
    let result = 1;
    let oddDigitsFound = 0;
    const digitIterator = String(number)[Symbol.iterator]();
    
    while (true) {
        const nextDigit = digitIterator.next();
        if (nextDigit.done) break;
        
        const currentDigit = parseInt(nextDigit.value, 10);
        if (currentDigit % 2 !== 0) {
            result *= currentDigit;
            oddDigitsFound++;
        }
    }
    
    return oddDigitsFound > 0 ? result : 0;
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