function encodeShift(s) {
    /**
     * returns encoded string by shifting every character by 5 in the alphabet.
     */
    return Array.from(s).map(ch => String.fromCharCode(((ch.charCodeAt(0) + 5 - 'a'.charCodeAt(0)) % 26) + 'a'.charCodeAt(0))).join('');
}

function decodeShift(s) {
    return Array.from(s).map(ch => String.fromCharCode(((ch.charCodeAt(0) - 5 - 'a'.charCodeAt(0)) % 26) + 'a'.charCodeAt(0))).join('');
}