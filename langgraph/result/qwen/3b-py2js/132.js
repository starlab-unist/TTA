function isNested(string) {
    const openingBracketIndices = [];
    const closingBracketIndices = [];

    for (let i = 0; i < string.length; i++) {
        if (string[i] === '[') {
            openingBracketIndices.push(i);
        } else {
            closingBracketIndices.push(i);
        }
    }

    closingBracketIndices.reverse();

    let cnt = 0;
    let i = 0;
    const l = closingBracketIndices.length;

    for (const idx of openingBracketIndices) {
        if (i < l && idx < closingBracketIndices[i]) {
            cnt += 1;
            i += 1;
        }
    }

    return cnt >= 2;
}