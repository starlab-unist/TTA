// Source Code
function fib4(n) {
    const results = [0, 0, 2, 0];
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
function calculateCustomFibonacci(index) {
    const sequence = [0, 0, 2, 0];
    if (index < 4) {
        return sequence[index];
    }

    let currentIndex = 4;
    while (currentIndex <= index) {
        const nextValue = sequence[sequence.length - 1] + sequence[sequence.length - 2] + sequence[sequence.length - 3] + sequence[sequence.length - 4];
        sequence.push(nextValue);
        sequence.shift();
        currentIndex += 1;
    }

    return sequence[sequence.length - 1];
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

    test.each(testCases)('Input: %d', (inputValue) => {
        expect(fib4(inputValue)).toBe(calculateCustomFibonacci(inputValue));
    });
});