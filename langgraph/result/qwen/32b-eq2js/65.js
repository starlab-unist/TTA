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