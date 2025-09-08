// Source Code
function hexKey(num) {
    const primes = ['2', '3', '5', '7', 'B', 'D'];
    let total = 0;
    for (let i = 0; i < num.length; i++) {
        if (primes.includes(num[i])) {
            total += 1;
        }
    }
    return total;
}

// Transformed Code (Semantically Equivalent)
function countPrimeHexDigits(hexString) {
    const primeHexDigits = new Set(['2', '3', '5', '7', 'B', 'D']);
    let count = 0;
    let index = 0;
    while (index < hexString.length) {
        if (primeHexDigits.has(hexString[index])) {
            count += 1;
        }
        index += 1;
    }
    return count;
}

// Test Cases
describe('hexKey vs countPrimeHexDigits equivalence tests', () => {
    const testCases = [
        "23456789ABCDEF",
        "FFFFFFFF",
        "1234567890",
        "BDBDBD",
        "222222",
        "777777",
        "",
        "AEC",
        "BEEF",
        "DEADBEEF"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(hexKey(inputText)).toBe(countPrimeHexDigits(inputText));
    });
});