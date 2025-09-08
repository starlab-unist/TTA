function convertToBinaryString(number) {
    const digitSum = String(number).split('').reduce((sum, digit) => sum + parseInt(digit, 10), 0);
    const binaryRepresentation = digitSum.toString(2);
    return binaryRepresentation;
}

// method name: solve -> convertToBinaryString
// parameter name: N -> number
// introduced variable: digitSum to hold the sum of digits
// introduced variable: binaryRepresentation to hold the binary string result
// kept the logic of converting the sum of digits to a binary string without '0b' prefix