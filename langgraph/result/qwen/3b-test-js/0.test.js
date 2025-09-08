// Source Code
function hasCloseElements(numbers, threshold) {
    for (let i = 0; i < numbers.length; i++) {
        for (let j = 0; j < numbers.length; j++) {
            if (i !== j) {
                const distance = Math.abs(numbers[i] - numbers[j]);
                if (distance < threshold) {
                    return true;
                }
            }
        }
    }

    return false;
}

// Transformed Code (Semantically Equivalent)
function containsNearbyElements(values, limit) {
    let index = 0;
    while (index < values.length) {
        let innerIndex = 0;
        while (innerIndex < values.length) {
            if (index !== innerIndex) {
                const gap = Math.abs(values[index] - values[innerIndex]);
                if (gap < limit) {
                    return true;
                }
            }
            innerIndex++;
        }
        index++;
    }

    return false;
}

// Test Cases
describe('hasCloseElements vs containsNearbyElements equivalence tests', () => {
    const testCases = [
        { input: [1.0, 2.0, 3.0], threshold: 0.5, expected: false },
        { input: [1.0, 2.0, 3.0], threshold: 1.5, expected: true },
        { input: [1.0, 2.0, 3.0], threshold: 1.2, expected: true },
        { input: [0.0, 0.0, 0.0], threshold: 0.0, expected: true },
        { input: [0.0, 0.1, 0.2], threshold: 0.05, expected: false },
        { input: [5.0, 4.9, 4.8], threshold: 0.2, expected: true },
        { input: [10.0, 20.0, 30.0], threshold: 5.0, expected: false },
        { input: [1.0, 1.0, 1.0, 1.0], threshold: 0.1, expected: true },
        { input: [1.0, 2.0, 3.0, 4.0, 5.0], threshold: 1.1, expected: true }
    ];

    testCases.forEach(({ input, threshold, expected }, index) => {
        test(`test case ${index}`, () => {
            expect(hasCloseElements(input, threshold)).toBe(expected);
            expect(containsNearbyElements(input, threshold)).toBe(expected);
        });
    });
});