// Source Code
function numericalLetterGrade(grades) {
    let letterGrade = [];
    for (let gpa of grades) {
        if (gpa === 4.0) {
            letterGrade.push("A+");
        } else if (gpa > 3.7) {
            letterGrade.push("A");
        } else if (gpa > 3.3) {
            letterGrade.push("A-");
        } else if (gpa > 3.0) {
            letterGrade.push("B+");
        } else if (gpa > 2.7) {
            letterGrade.push("B");
        } else if (gpa > 2.3) {
            letterGrade.push("B-");
        } else if (gpa > 2.0) {
            letterGrade.push("C+");
        } else if (gpa > 1.7) {
            letterGrade.push("C");
        } else if (gpa > 1.3) {
            letterGrade.push("C-");
        } else if (gpa > 1.0) {
            letterGrade.push("D+");
        } else if (gpa > 0.7) {
            letterGrade.push("D");
        } else if (gpa > 0.0) {
            letterGrade.push("D-");
        } else {
            letterGrade.push("D-");
        }
    }
    return letterGrade;
}

// Transformed Code
function convertGpasToLetters(gpas) {
    const gradeMapping = [
        [4.0, "A+"],
        [3.7, "A"],
        [3.3, "A-"],
        [3.0, "B+"],
        [2.7, "B"],
        [2.3, "B-"],
        [2.0, "C+"],
        [1.7, "C"],
        [1.3, "C-"],
        [1.0, "D+"],
        [0.7, "D"],
        [0.0, "D-"],
    ];

    let letterGrades = [];
    for (let gpa of gpas) {
        let index = 0;
        while (index < gradeMapping.length && gpa <= gradeMapping[index][0]) {
            index++;
        }
        letterGrades.push(gradeMapping[index - 1][1]);
    }

    return letterGrades;
}

// Test Cases
describe('GPA Conversion', () => {
    test.each([
        [4.0, ["A+"]],
        [3.8, ["A"]],
        [3.5, ["A-"]],
        [3.2, ["B+"]],
        [2.9, ["B"]],
        [2.5, ["B-"]],
        [2.1, ["C+"]],
        [1.8, ["C"]],
        [1.4, ["C-"]],
        [1.1, ["D+"]],
        [0.8, ["D"]],
        [0.3, ["D-"]],
        [0.0, ["D-"]]
    ])('converts %f to %p', (gpa, expected) => {
        expect(numericalLetterGrade([gpa])).toEqual(expected);
        expect(convertGpasToLetters([gpa])).toEqual(expected);
    });
});