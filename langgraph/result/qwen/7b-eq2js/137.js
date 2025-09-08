function evaluateAndCompare(a, b) {
    let tempA = a;
    let tempB = b;

    if (typeof tempA === 'string') {
        tempA = tempA.replace(',', '.');
    }
    if (typeof tempB === 'string') {
        tempB = tempB.replace(',', '.');
    }

    const numericVal1 = parseFloat(tempA);
    const numericVal2 = parseFloat(tempB);

    if (numericVal1 === numericVal2) {
        return null;
    } else if (numericVal1 > numericVal2) {
        return a;
    } else {
        return b;
    }
}