function compareOne(a, b) {
    let tempA = a;
    let tempB = b;
    if (typeof tempA === 'string') tempA = tempA.replace(',', '.');
    if (typeof tempB === 'string') tempB = tempB.replace(',', '.');
    const numA = parseFloat(tempA);
    const numB = parseFloat(tempB);
    if (numA === numB) return null;
    return numA > numB ? a : b;
}