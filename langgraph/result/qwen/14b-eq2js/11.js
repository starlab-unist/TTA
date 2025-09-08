function binaryStringDifference(str1, str2) {
    function bitDiff(c1, c2) {
        return c1 === c2 ? '0' : '1';
    }

    let result = '';
    let index = 0;
    while (index < str1.length) {
        result += bitDiff(str1[index], str2[index]);
        index += 1;
    }

    return result;
}

// method name: string_xor -> binaryStringDifference
// parameter names: a -> str1, b -> str2
// inner function name: xor -> bitDiff
// replaced list comprehension with while loop and explicit string concatenation