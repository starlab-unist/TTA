// Source Code
function isPalindrome(n) {
    return String(n) === String(n).split('').reverse().join('');
}

function evenOddPalindrome(n) {
    let evenPalindromeCount = 0;
    let oddPalindromeCount = 0;

    for (let i = 1; i <= n; i++) {
        if (i % 2 === 1 && isPalindrome(i)) {
            oddPalindromeCount += 1;
        } else if (i % 2 === 0 && isPalindrome(i)) {
            evenPalindromeCount += 1;
        }
    }
    return [evenPalindromeCount, oddPalindromeCount];
}

// Transformed Code (Semantically Equivalent)
function countEvenOddPalindromes(limit) {
    function checkPalindrome(number) {
        return number.toString() === number.toString().split('').reverse().join('');
    }

    let evenCount = 0;
    let oddCount = 0;

    let currentNumber = 1;
    while (currentNumber <= limit) {
        if (currentNumber % 2 === 1 && checkPalindrome(currentNumber)) {
            oddCount += 1;
        } else if (currentNumber % 2 === 0 && checkPalindrome(currentNumber)) {
            evenCount += 1;
        }
        currentNumber += 1;
    }

    return [evenCount, oddCount];
}

// Test Cases
describe('evenOddPalindrome vs countEvenOddPalindromes equivalence tests', () => {
    const testCases = [
        1,
        10,
        20,
        50,
        100,
        200,
        300,
        400,
        500,
        1000
    ];

    test.each(testCases)('Input: %d', (inputNumber) => {
        expect(evenOddPalindrome(inputNumber)).toBe(countEvenOddPalindromes(inputNumber));
    });
});