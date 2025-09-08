function stringXor(a, b) {
    function xor(i, j) {
        return i === j ? '0' : '1';
    }

    let result = '';
    for (let i = 0; i < Math.min(a.length, b.length); i++) {
        result += xor(a[i], b[i]);
    }
    return result;
}