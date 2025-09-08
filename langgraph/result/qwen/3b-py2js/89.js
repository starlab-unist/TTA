function encrypt(s) {
    const d = 'abcdefghijklmnopqrstuvwxyz';
    let out = '';
    for (let c of s) {
        if (d.includes(c)) {
            const index = d.indexOf(c);
            out += d[(index + 2 * 2) % 26];
        } else {
            out += c;
        }
    }
    return out;
}

console.log(encrypt("Alice"));