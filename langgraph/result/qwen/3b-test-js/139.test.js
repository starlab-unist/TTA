// Source Code
function specialFactorial(n) {
    let factI = 1;
    let specialFact = 1;
    for (let i = 1; i <= n; i++) {
        factI *= i;
        specialFact *= factI;
    }
    return specialFact;
}

// Transformed Code
function computeSpecialProduct(n) {
    let currentFactorial = 1;
    let cumulativeProduct = 1;
    let index = 1;

    while (index <= n) {
        currentFactorial *= index;
        cumulativeProduct *= currentFactorial;
        index++;
    }

    return cumulativeProduct;
}

// Test Cases
describe('specialFactorial vs computeSpecialProduct equivalence tests', () => {
    const testCases = [
        0,      // Edge case: n = 0
        1,      // Simple case: n = 1
        2,      // Simple case: n = 2
        3,      // Simple case: n = 3
        4,      // Simple case: n = 4
        5,      // Simple case: n = 5
        6,      // Simple case: n = 6
        10,     // Larger number: n = 10
        20,     // Larger number: n = 20
        100     // Very large number: n = 100
    ];

    test.each(testCases)('Input: %d', (inputValue) => {
        expect(specialFactorial(inputValue)).toBe(computeSpecialProduct(inputValue));
    });
});