function rotateString(number, offset) {
    let numStr = number.toString();
    let length = numStr.length;

    if (offset >= length) {
        return numStr.split('').reverse().join('');
    } else {
        let splitPoint = length - offset;
        let rotatedPart = numStr.slice(splitPoint);
        let remainingPart = numStr.slice(0, splitPoint);
        return rotatedPart + remainingPart;
    }
}