function longest(strings) {
    if (!strings.length) {
        return null;
    }

    const maxlen = Math.max(...strings.map(x => x.length));
    for (const s of strings) {
        if (s.length === maxlen) {
            return s;
        }
    }
}