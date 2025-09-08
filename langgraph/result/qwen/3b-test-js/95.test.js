// Source Code
function checkDictCase(dict) {
    if (Object.keys(dict).length === 0) {
        return false;
    } else {
        let state = "start";
        for (let key of Object.keys(dict)) {
            if (typeof key !== 'string') {
                state = "mixed";
                break;
            }
            if (state === "start") {
                if (key.toUpperCase() === key) {
                    state = "upper";
                } else if (key.toLowerCase() === key) {
                    state = "lower";
                } else {
                    break;
                }
            } else if ((state === "upper" && key.toUpperCase() !== key) || (state === "lower" && key.toLowerCase() !== key)) {
                state = "mixed";
                break;
            } else {
                break;
            }
        }
        return state === "upper" || state === "lower";
    }
}

// Transformed Code (Semantically Equivalent)
function evaluateDictionaryKeysCasing(inputDict) {
    if (!inputDict) {
        return false;
    }

    let casingState = null;
    for (let key of Object.keys(inputDict)) {
        if (typeof key !== 'string') {
            return false;
        }

        if (casingState === null) {
            if (key.toUpperCase() === key) {
                casingState = 'UPPER';
            } else if (key.toLowerCase() === key) {
                casingState = 'LOWER';
            } else {
                return false;
            }
        } else {
            if ((casingState === 'UPPER' && key.toUpperCase() !== key) || (casingState === 'LOWER' && key.toLowerCase() !== key)) {
                return false;
            }
        }
    }

    return ['UPPER', 'LOWER'].includes(casingState);
}

// Test Cases
describe('Function Equivalence Tests', () => {
    const testCases = [
        [{}, false],
        ({"A": 1, "B": 2, "C": 3}, true),
        ({"a": 1, "b": 2, "c": 3}, true),
        ({"A": 1, "b": 2, "C": 3}, false),
        ({"1": 1, "2": 2, "3": 3}, false),
        ({"A": 1, 2: "B", "C": 3}, false),
        ({"a": 1, "b": 2, "c": 3, "d": 4, "e": 5}, true),
        ({"HELLO": 1, "WORLD": 2}, true),
        ({"hello": 1, "world": 2}, true),
        ({"Mixed": 1, "CASE": 2}, false)
    ];

    testCases.forEach(([input, expected], index) => {
        it(`Test case ${index}`, () => {
            expect(checkDictCase(input)).toBe(evaluateDictionaryKeysCasing(input));
        });
    });
});