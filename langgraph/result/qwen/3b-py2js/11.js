function stringXor(a, b) {
    function xor(i, j) {
        if (i === j) {
            return '0';
        } else {
            return '1';
        }
    }

    return a.split('').map((char, index) => xor(char, b[index])).join('');
}