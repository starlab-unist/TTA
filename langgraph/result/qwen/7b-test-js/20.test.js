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
    let minGap = Infinity;

    let index = 0;
    while (index < values.length) {
        let innerIndex = 0;
        while (innerIndex < values.length) {
            if (index !== innerIndex) {
                const currentDifference = Math.abs(values[index] - values[innerIndex]);
                if (currentDifference < minGap) {
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

// Test Cases
describe('findClosestElements vs determineNearestPair equivalence tests', () => {
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
        if (index === 9) {
            // This case should handle the scenario where there is only one element in the list.
            // The function should return null as there are no pairs to compare.
            it(`should return null for single element array at test ${index}`, () => {
                expect(findClosestElements(testCase)).toBeNull();
                expect(determineNearestPair(testCase)).toBeNull();
            });
        } else {
            it(`should be equivalent for test case ${index}`, () => {
                expect(findClosestElements(testCase)).toEqual(expect.arrayContaining(determineNearestPair(testCase)));
                expect(determineNearestPair(testCase)).toEqual(expect.arrayContaining(findClosestElements(testCase)));
            });
        }
    });
});