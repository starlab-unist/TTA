// Source Code
function carRaceCollision(n) {
    return n * n;
}

// Transformed Code (Semantically Equivalent)
function calculateImpactForce(vehicleCount) {
    let impact = vehicleCount * vehicleCount;
    return impact;
}

// Test Cases
describe('carRaceCollision vs calculateImpactForce equivalence tests', () => {
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

    test.each(testCases)('Input: %d', (inputValue) => {
        expect(carRaceCollision(inputValue)).toBe(calculateImpactForce(inputValue));
    });
});