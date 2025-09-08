function f(n) {
    const ret = [];
    for (let i = 1; i <= n; i++) {
        let x;
        if (i % 2 === 0) {
            x = 1;
            for (let j = 1; j <= i; j++) x *= j;
        } else {
            x = 0;
            for (let j = 1; j <= i; j++) x += j;
        }
        ret.push(x);
    }
    return ret;
}