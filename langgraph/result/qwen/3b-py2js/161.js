function solve(s) {
    let flg = 0;
    let idx = 0;
    let newStr = s.split('');
    
    for (let i of s) {
        if (/[a-zA-Z]/.test(i)) {
            newStr[idx] = i === i.toUpperCase() ? i.toLowerCase() : i.toUpperCase();
            flg = 1;
        }
        idx++;
    }
    
    s = newStr.join('');
    
    if (flg === 0) {
        return s.split('').reverse().join('');
    }
    
    return s;
}