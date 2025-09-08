function evaluateAndCompare(value1, value2) {
    let modifiedVal1 = value1;
    let modifiedVal2 = value2;

    if (typeof modifiedVal1 === 'string') {
        modifiedVal1 = modifiedVal1.replace(',', '.');
    }
    if (typeof modifiedVal2 === 'string') {
        modifiedVal2 = modifiedVal2.replace(',', '.');
    }

    const numericVal1 = parseFloat(modifiedVal1);
    const numericVal2 = parseFloat(modifiedVal2);

    if (numericVal1 === numericVal2) {
        return null;
    } else if (numericVal1 > numericVal2) {
        return value1;
    } else {
        return value2;
    }
}