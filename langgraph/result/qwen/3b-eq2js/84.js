function convertToBinaryString(number) {
    const digitSum = Array.from(String(number), digit => parseInt(digit, 10)).reduce((acc, digit) => acc + digit, 0);
    const binaryRepresentation = digitSum.toString(2);
    return binaryRepresentation;
}