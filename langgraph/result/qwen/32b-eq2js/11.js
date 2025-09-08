function binaryStringDifference(str1, str2) {
    function bitDiff(c1, c2) {
        return c1 === c2 ? '0' : '1';
    }

    let result = [];
    let index = 0;
    while (index < str1.length) {
        result.push(bitDiff(str1[index], str2[index]));
        index += 1;
    }

    return result.join('');
}