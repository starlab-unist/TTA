// Source Code
function closestInteger(value) {
    const floor = Math.floor;
    const ceil = Math.ceil;

    if (value.includes('.')) {
        // remove trailing zeros
        while (value[value.length - 1] === '0') {
            value = value.slice(0, -1);
        }
    }

    const num = parseFloat(value);
    if (value.endsWith('.5')) {
        if (num > 0) {
            res = ceil(num);
        } else {
            res = floor(num);
        }
    } else if (value.length > 0) {
        res = Math.round(num);
    } else {
        res = 0;
    }

    return res;
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

    const number = parseFloat(inputValue);
    let result;

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

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(closestInteger(inputText)).toBe(nearestWholeNumber(inputText));
    });
});