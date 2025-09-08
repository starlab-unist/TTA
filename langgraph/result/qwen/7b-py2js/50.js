function encodeShift(s) {
    return s.split('').map(ch => {
        const charCode = ((ch.charCodeAt(0) - 'a'.charCodeAt(0) + 5) % 26) + 'a'.charCodeAt(0);
        return String.fromCharCode(charCode);
    }).join('');
}

function decodeShift(s) {
    return s.split('').map(ch => {
        const charCode = ((ch.charCodeAt(0) - 'a'.charCodeAt(0) - 5 + 26) % 26) + 'a'.charCodeAt(0);
        return String.fromCharCode(charCode);
    }).join('');
}