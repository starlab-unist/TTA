function longest(strings) {
    if (strings.length === 0) {
        return null;
    }

    let maxlen = Math.max(...strings.map(x => x.length));
    for (let s of strings) {
        if (s.length === maxlen) {
            return s;
        }
    }
}