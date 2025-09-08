// Source Code
function findClosestElements(numbers) {
    let closestPair = null;
    let distance = null;

    for (let idx = 0; idx < numbers.length; idx++) {
        const elem = numbers[idx];
        for (let idx2 = 0; idx2 < numbers.length; idx2++) {
            const elem2 = numbers[idx2];
            if (idx !== idx2) {
                if (distance === null) {
                    distance = Math.abs(elem - elem2);
                    closestPair = [elem, elem2].sort((a, b) => a - b);
                } else {
                    const newDistance = Math.abs(elem - elem2);
                    if (newDistance < distance) {
                        distance = newDistance;
                        closestPair = [elem, elem2].sort((a, b) => a - b);
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
                    nearestPair = [values[index], values[innerIndex]].sort((a, b) => a - b);
                }
            }
            innerIndex += 1;
        }
        index += 1;
    }

    return nearestPair;
}

// Test Cases
describe('Function Equivalence Tests', () => {
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
        if (index !== 9) { // Special case for single element array
            it(`Test Case ${index}`, () => {
                expect(findClosestElements(testCase)).toEqual(determineNearestPair(testCase));
            });
        } else {
            it(`Test Case ${index} - Single Element`, () => {
                expect(findClosestElements(testCase)).toBeNull();
                expect(determineNearestPair(testCase)).toBeNull();
            });
        }
    });
});