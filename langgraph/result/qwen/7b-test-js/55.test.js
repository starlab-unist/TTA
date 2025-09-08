// Source Code
function fib(n) {
    if (n === 0) {
        return 0;
    }
    if (n === 1) {
        return 1;
    }
    return fib(n - 1) + fib(n - 2);
}

// Transformed Code (Semantically Equivalent)
function calculateFibonacci(n) {
    if (n === 0) {
        return 0;
    } else if (n === 1) {
        return 1;
    }

    let previous = 0, current = 1, index = 2;
    while (index <= n) {
        [previous, current] = [current, previous + current];
        index++;
    }

    return current;
}

// Test Cases
describe('fib vs calculateFibonacci equivalence tests', () => {
    const testCases = [
        0,
        1,
        2,
        3,
        4,
        5,
        10,
        15,
        20,
        25
    ];

    test.each(testCases)('Input: %d', (inputNumber) => {
        expect(fib(inputNumber)).toBe(calculateFibonacci(inputNumber));
    });
});