function encrypt(s) {
    const d = 'abcdefghijklmnopqrstuvwxyz';
    let out = '';
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (d.includes(c)) {
            const index = d.indexOf(c);
            out += d[(index + 2 * 2) % 26];
        } else {
            out += c;
        }
    }
    return out;
}