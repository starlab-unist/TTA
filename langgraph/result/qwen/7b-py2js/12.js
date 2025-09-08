function longest(strings) {
    if (!strings.length) {
        return null;
    }

    let maxlen = Math.max(...strings.map(s => s.length));
    for (let s of strings) {
        if (s.length === maxlen) {
            return s;
        }
    }
}