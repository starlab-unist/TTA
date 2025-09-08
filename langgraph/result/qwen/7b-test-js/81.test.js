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
        [0.0, "D-"]
    ];

    let letterGrades = [];
    for (let gpa of gpas) {
        let index = 0;
        while (index < gradeMapping.length - 1 && gpa <= gradeMapping[index][0]) {
            index++;
        }
        if (gpa > gradeMapping[index][0] || index === 0) {
            letterGrades.push(gradeMapping[index][1]);
        } else {
            letterGrades.push(gradeMapping[index - 1][1]);
        }
    }

    return letterGrades;
}

// Jest Test Suite
describe('GPA Conversion', () => {
    it('should convert [4.0] to ["A+"]', () => {
        expect(numericalLetterGrade([4.0])).toEqual(["A+"]);
        expect(convertGpasToLetters([4.0])).toEqual(["A+"]);
    });

    it('should convert [3.8] to ["A"]', () => {
        expect(numericalLetterGrade([3.8])).toEqual(["A"]);
        expect(convertGpasToLetters([3.8])).toEqual(["A"]);
    });

    it('should convert [3.5] to ["A-"]', () => {
        expect(numericalLetterGrade([3.5])).toEqual(["A-"]);
        expect(convertGpasToLetters([3.5])).toEqual(["A-"]);
    });

    it('should convert [3.2] to ["B+"]', () => {
        expect(numericalLetterGrade([3.2])).toEqual(["B+"]);
        expect(convertGpasToLetters([3.2])).toEqual(["B+"]);
    });

    it('should convert [2.9] to ["B"]', () => {
        expect(numericalLetterGrade([2.9])).toEqual(["B"]);
        expect(convertGpasToLetters([2.9])).toEqual(["B"]);
    });

    it('should convert [2.5] to ["B-"]', () => {
        expect(numericalLetterGrade([2.5])).toEqual(["B-"]);
        expect(convertGpasToLetters([2.5])).toEqual(["B-"]);
    });

    it('should convert [2.1] to ["C+"]', () => {
        expect(numericalLetterGrade([2.1])).toEqual(["C+"]);
        expect(convertGpasToLetters([2.1])).toEqual(["C+"]);
    });

    it('should convert [1.8] to ["C"]', () => {
        expect(numericalLetterGrade([1.8])).toEqual(["C"]);
        expect(convertGpasToLetters([1.8])).toEqual(["C"]);
    });

    it('should convert [1.4] to ["C-"]', () => {
        expect(numericalLetterGrade([1.4])).toEqual(["C-"]);
        expect(convertGpasToLetters([1.4])).toEqual(["C-"]);
    });

    it('should convert [1.1] to ["D+"]', () => {
        expect(numericalLetterGrade([1.1])).toEqual(["D+"]);
        expect(convertGpasToLetters([1.1])).toEqual(["D+"]);
    });

    it('should convert [0.8] to ["D"]', () => {
        expect(numericalLetterGrade([0.8])).toEqual(["D"]);
        expect(convertGpasToLetters([0.8])).toEqual(["D"]);
    });

    it('should convert [0.3] to ["D-"]', () => {
        expect(numericalLetterGrade([0.3])).toEqual(["D-"]);
        expect(convertGpasToLetters([0.3])).toEqual(["D-"]);
    });

    it('should convert [0.0] to ["D-"]', () => {
        expect(numericalLetterGrade([0.0])).toEqual(["D-"]);
        expect(convertGpasToLetters([0.0])).toEqual(["D-"]);
    });
});