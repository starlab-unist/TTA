function rotateString(x, shift) {
    let s = String(x);
    let length = s.length;
    
    if (shift >= length) {
        return s.split('').reverse().join('');
    } else {
        let splitPoint = length - shift;
        let rotatedPart = s.slice(splitPoint);
        let remainingPart = s.slice(0, splitPoint);
        return rotatedPart + remainingPart;
    }
}