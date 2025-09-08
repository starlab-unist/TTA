function binaryStringDifference(a, b) {
    function bitDiff(c1, c2) {
        return c1 === c2 ? '0' : '1';
    }

    let result = [];
    let index = 0;
    while (index < a.length) {
        result.push(bitDiff(a[index], b[index]));
        index += 1;
    }

    return result.join('');
}