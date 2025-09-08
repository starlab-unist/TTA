function matchParens(lst) {
    function check(s) {
        let val = 0;
        for (let i = 0; i < s.length; i++) {
            if (s[i] === '(') {
                val += 1;
            } else {
                val -= 1;
            }
            if (val < 0) {
                return false;
            }
        }
        return val === 0;
    }

    const S1 = lst[0] + lst[1];
    const S2 = lst[1] + lst[0];
    return check(S1) || check(S2) ? 'Yes' : 'No';
}