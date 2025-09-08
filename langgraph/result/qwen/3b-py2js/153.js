function StrongestExtension(className, extensions) {
    let strong = extensions[0];
    let myVal = 0;
    for (let s of extensions) {
        let val = 0;
        for (let x of s) {
            if (x >= 'A' && x <= 'Z') val++;
            if (x >= 'a' && x <= 'z') val--;
        }
        if (val > myVal) {
            strong = s;
            myVal = val;
        }
    }
    let ans = className + "." + strong;
    return ans;
}