function solve(s) {
    let flg = 0;
    let idx = 0;
    let newStr = s.split('');
    for (let i of s) {
        if (/[a-zA-Z]/.test(i)) {
            newStr[idx] = i === i.toLowerCase() ? i.toUpperCase() : i.toLowerCase();
            flg = 1;
        }
        idx += 1;
    }
    s = newStr.join('');
    if (flg === 0) {
        return s.split('').reverse().join('');
    }
    return s;
}