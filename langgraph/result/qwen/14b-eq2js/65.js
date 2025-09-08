function rotateString(number, offset) {
    const numStr = number.toString();
    const length = numStr.length;

    if (offset >= length) {
        return numStr.split('').reverse().join('');
    } else {
        const splitPoint = length - offset;
        const rotatedPart = numStr.slice(splitPoint);
        const remainingPart = numStr.slice(0, splitPoint);
        return rotatedPart + remainingPart;
    }
}

// method name: circular_shift -> rotateString
// parameter name: x -> number, shift -> offset
// variable name: s -> numStr, len(s) -> length
// introduced splitPoint for clarity in slicing
// used more descriptive variable names for sliced parts