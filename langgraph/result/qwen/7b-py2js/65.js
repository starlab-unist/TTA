function circularShift(x, shift) {
    let s = x.toString();
    if (shift > s.length) {
        return s.split('').reverse().join('');
    } else {
        return s.slice(-shift) + s.slice(0, -shift);
    }
}