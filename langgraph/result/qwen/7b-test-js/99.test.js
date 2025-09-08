// Source Code
function closestInteger(value) {
    const { floor, ceil } = Math;

    if (value.includes('.')) {
        // remove trailing zeros
        while (value.endsWith('0')) {
            value = value.slice(0, -1);
        }
    }

    let num = parseFloat(value);
    if (value.endsWith('.5')) {
        if (num > 0) {
            return ceil(num);
        } else {
            return floor(num);
        }
    } else if (value.length > 0) {
        return Math.round(num);
    } else {
        return 0;
    }
}

// Transformed Code (Semantically Equivalent)
function nearestWholeNumber(inputValue) {
    const { floor, ceil } = Math;

    if (inputValue.includes('.')) {
        // strip trailing zeros
        while (inputValue.endsWith('0')) {
            inputValue = inputValue.slice(0, -1);
        }
    }

    let number = parseFloat(inputValue);
    if (inputValue.endsWith('.5')) {
        result = number > 0 ? ceil(number) : floor(number);
    } else if (inputValue) {
        result = Math.round(number);
    } else {
        result = 0;
    }

    return result;
}

// Test Cases
describe('closestInteger vs nearestWholeNumber equivalence tests', () => {
    const testCases = [
        "4.5",
        "-2.5",
        "3.7",
        "-1.2",
        "0.0",
        "5.000",
        "6.99",
        "-3.01",
        ".5",
        "-.5"
    ];

    test.each(testCases)('Input: "%s"', (inputValue) => {
        expect(closestInteger(inputValue)).toBe(nearestWholeNumber(inputValue));
    });
});