// Source Code
function tri(n) {
    if (n === 0) {
        return [1];
    }
    let myTri = [1, 3];
    for (let i = 2; i <= n; i++) {
        if (i % 2 === 0) {
            myTri.push(i / 2 + 1);
        } else {
            myTri.push(myTri[i - 1] + myTri[i - 2] + (i + 3) / 2);
        }
    }
    return myTri;
}

// Transformed Code (Semantically Equivalent)
function generateCustomSequence(length) {
    if (length === 0) {
        return [1];
    }

    let sequence = [1, 3];
    let index = 2;

    while (index <= length) {
        if (index % 2 === 0) {
            sequence.push(index / 2 + 1);
        } else {
            sequence.push(sequence[index - 1] + sequence[index - 2] + (index + 3) / 2);
        }
        index++;
    }

    return sequence;
}

// Test Cases
describe('tri vs generateCustomSequence equivalence tests', () => {
    const testCases = [
        0,
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9
    ];

    test.each(testCases)('Input: %s', (input) => {
        expect(tri(input)).toEqual(generateCustomSequence(input));
    });
});