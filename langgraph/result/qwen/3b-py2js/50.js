function encodeShift(s) {
    return s.split('').map(ch => {
        const shiftedCharCode = ((ch.charCodeAt(0) + 5 - 'a'.charCodeAt(0)) % 26) + 'a'.charCodeAt(0);
        return String.fromCharCode(shiftedCharCode);
    }).join('');
}

function decodeShift(s) {
    return s.split('').map(ch => {
        const shiftedCharCode = ((ch.charCodeAt(0) - 5 - 'a'.charCodeAt(0)) % 26) + 'a'.charCodeAt(0);
        return String.fromCharCode(shiftedCharCode);
    }).join('');
}