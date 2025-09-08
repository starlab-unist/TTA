function encodeShift(s) {
    return s.split('').map(ch => String.fromCharCode(((ch.charCodeAt(0) + 5 - 'a'.charCodeAt(0)) % 26) + 'a'.charCodeAt(0))).join('');
}

function decodeShift(s) {
    return s.split('').map(ch => String.fromCharCode(((ch.charCodeAt(0) - 5 - 'a'.charCodeAt(0)) % 26 + 26) % 26 + 'a'.charCodeAt(0))).join('');
}