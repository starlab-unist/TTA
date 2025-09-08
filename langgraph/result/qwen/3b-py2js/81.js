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
            letterGrade.push("E");
        }
    }
    return letterGrade;
}