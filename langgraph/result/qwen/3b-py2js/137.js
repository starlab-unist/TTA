function compareOne(a, b) {
    let tempA = a;
    let tempB = b;

    if (typeof tempA === 'string') tempA = tempA.replace(',', '.');
    if (typeof tempB === 'string') tempB = tempB.replace(',', '.');

    if (parseFloat(tempA) === parseFloat(tempB)) return null;
    return tempA > tempB ? a : b;
}