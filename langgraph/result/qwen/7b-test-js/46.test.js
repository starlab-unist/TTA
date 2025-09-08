// Source Code
function fib4(n) {
    let results = [0, 0, 2, 0];
    if (n < 4) {
        return results[n];
    }

    for (let i = 4; i <= n; i++) {
        results.push(results[results.length - 1] + results[results.length - 2] + results[results.length - 3] + results[results.length - 4]);
        results.shift();
    }

    return results[results.length - 1];
}

// Transformed Code (Semantically Equivalent)
function calculateCustomFibonacci(n) {
    let sequence = [0, 0, 2, 0];
    if (n < 4) {
        return sequence[n];
    }

    let currentIndex = 4;
    while (currentIndex <= n) {
        let nextValue = sequence[3] + sequence[2] + sequence[1] + sequence[0];
        sequence.shift();
        sequence.push(nextValue);
        currentIndex += 1;
    }

    return sequence[3];
}

// Test Cases
describe('fib4 vs calculateCustomFibonacci equivalence tests', () => {
    const testCases = [
        0,  // Base case
        1,  // Base case
        2,  // Base case
        3,  // Base case
        4,  // First calculated value
        5,  // Continue calculation
        6,  // Continue calculation
        7,  // Continue calculation
        8,  // Continue calculation
        9   // Continue calculation
    ];

    test.each(testCases)('Input: %i', (inputNumber) => {
        expect(fib4(inputNumber)).toBe(calculateCustomFibonacci(inputNumber));
    });
});