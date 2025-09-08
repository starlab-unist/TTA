function longest(strings) {
    if (!strings || strings.length === 0) {
        return null;
    }

    let maxlen = Math.max(...strings.map(str => str.length));
    for (let s of strings) {
        if (s.length === maxlen) {
            return s;
        }
    }
}