function solve(s) {
    let flg = 0;
    let idx = 0;
    let newStr = s.split('');
    
    for (let i of s) {
        if (i.match(/[a-zA-Z]/)) {
            newStr[idx] = i === i.toUpperCase() ? i.toLowerCase() : i.toUpperCase();
            flg = 1;
        }
        idx++;
    }
    
    let result = newStr.join('');
    
    if (flg === 0) {
        return result.split('').reverse().join('');
    }
    
    return result;
}