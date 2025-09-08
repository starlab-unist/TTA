function convertToBinaryString(number) {
    const digitSum = String(number).split('').reduce((sum, digit) => sum + parseInt(digit, 10), 0);
    const binaryRepresentation = digitSum.toString(2);
    return binaryRepresentation;
}