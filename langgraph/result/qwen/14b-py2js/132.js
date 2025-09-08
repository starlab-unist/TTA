function isNested(string) {
    let openingBracketIndex = [];
    let closingBracketIndex = [];
    for (let i = 0; i < string.length; i++) {
        if (string[i] === '[') {
            openingBracketIndex.push(i);
        } else {
            closingBracketIndex.push(i);
        }
    }
    closingBracketIndex.reverse();
    let cnt = 0;
    let i = 0;
    let l = closingBracketIndex.length;
    for (let idx of openingBracketIndex) {
        if (i < l && idx < closingBracketIndex[i]) {
            cnt += 1;
            i += 1;
        }
    }
    return cnt >= 2;
}