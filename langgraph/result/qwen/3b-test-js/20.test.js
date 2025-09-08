// Source Code
function findClosestElements(numbers) {
    let closestPair = null;
    let distance = null;

    for (let i = 0; i < numbers.length; i++) {
        for (let j = 0; j < numbers.length; j++) {
            if (i !== j) {
                if (distance === null) {
                    distance = Math.abs(numbers[i] - numbers[j]);
                    closestPair = [numbers[i], numbers[j]].sort((a, b) => a - b);
                } else {
                    const newDistance = Math.abs(numbers[i] - numbers[j]);
                    if (newDistance < distance) {
                        distance = newDistance;
                        closestPair = [numbers[i], numbers[j]].sort((a, b) => a - b);
                    }
                }
            }
        }
    }

    return closestPair;
}

// Transformed Code (Semantically Equivalent)
function determineNearestPair(values) {
    let nearestPair = null;
    let minGap = null;

    let index = 0;
    while (index < values.length) {
        let innerIndex = 0;
        while (innerIndex < values.length) {
            if (index !== innerIndex) {
                const currentDifference = Math.abs(values[index] - values[innerIndex]);
                if (minGap === null || currentDifference < minGap) {
                    minGap = currentDifference;
                    nearestPair = [Math.min(values[index], values[innerIndex]), Math.max(values[index], values[innerIndex])];
                }
            }
            innerIndex++;
        }
        index++;
    }

    return nearestPair;
}

// Test cases
describe('Equivalence of findClosestElements and determineNearestPair', () => {
    const testCases = [
        [1.0, 2.0, 3.0, 4.0],
        [5.5, 3.3, 2.2, 8.8, 9.9],
        [-1.0, -2.0, -3.0, -4.0],
        [10.0, 10.0, 10.0, 10.0],
        [0.1, 0.2, 0.3, 0.4, 0.5],
        [100.0, 99.0, 101.0, 98.0],
        [0.0, 0.0, 0.0, 0.0],
        [1.5, 2.5, 3.5, 4.5],
        [1000.1, 1000.2, 999.9, 1001.1],
        [1.0]
    ];

    testCases.forEach((testCase, index) => {
        it(`should return the same result for test case ${index}`, () => {
            const result1 = findClosestElements(testCase);
            const result2 = determineNearestPair(testCase);
            
            if (testCase.length === 1) {
                expect(result1).toBeNull();
                expect(result2).toBeNull();
            } else {
                expect(result1).toEqual(expect.arrayContaining(result2));
                expect(result2).toEqual(expect.arrayContaining(result1));
            }
        });
    });
});