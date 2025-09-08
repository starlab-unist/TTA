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
        [-1.0, "E"]  // Added -1.0 to handle the else case
    ];

    let letterGrades = [];
    let index = 0;
    while (index < gpas.length) {
        let gpa = gpas[index];
        while (gpa <= gradeMapping[index][0]) {
            index++;
        }
        letterGrades.push(gradeMapping[index - 1][1]);
        index++;
    }

    return letterGrades;
}