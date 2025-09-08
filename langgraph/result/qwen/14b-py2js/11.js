function stringXor(a, b) {
    function xor(i, j) {
        if (i === j) {
            return '0';
        } else {
            return '1';
        }
    }

    let result = '';
    for (let i = 0; i < a.length; i++) {
        result += xor(a[i], b[i]);
    }
    return result;
}