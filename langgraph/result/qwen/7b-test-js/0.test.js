// Source Code
function hasCloseElements(numbers, threshold) {
    for (let i = 0; i < numbers.length; i++) {
        for (let j = 0; j < numbers.length; j++) {
            if (i !== j) {
                let distance = Math.abs(numbers[i] - numbers[j]);
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
                let gap = Math.abs(values[index] - values[innerIndex]);
                if (gap < limit) {
                    return true;
                }
            }
            innerIndex += 1;
        }
        index += 1;
    }

    return false;
}

// Test Cases
describe('hasCloseElements vs containsNearbyElements equivalence tests', () => {
    const testCases = [
        { numbers: [1.0, 2.0, 3.0], threshold: 0.5, expected: false },
        { numbers: [1.0, 2.0, 3.0], threshold: 1.5, expected: true },
        { numbers: [1.1, 2.2, 3.3], threshold: 0.1, expected: false },
        { numbers: [1.1, 2.2, 3.3], threshold: 1.2, expected: true },
        { numbers: [0.0, 0.0, 0.0], threshold: 0.0, expected: true },
        { numbers: [0.0, 0.1, 0.2], threshold: 0.05, expected: false },
        { numbers: [5.0, 4.9, 4.8], threshold: 0.2, expected: true },
        { numbers: [10.0, 20.0, 30.0], threshold: 5.0, expected: false },
        { numbers: [1.0, 1.0, 1.0, 1.0], threshold: 0.1, expected: true },
        { numbers: [1.0, 2.0, 3.0, 4.0, 5.0], threshold: 1.1, expected: true }
    ];

    testCases.forEach(({ numbers, threshold, expected }, index) => {
        it(`Test case ${index}`, () => {
            expect(hasCloseElements(numbers, threshold)).toBe(expected);
            expect(containsNearbyElements(numbers, threshold)).toBe(expected);
        });
    });
});