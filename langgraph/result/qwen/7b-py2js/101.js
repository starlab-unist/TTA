function wordsString(s) {
    if (!s) {
        return [];
    }

    let sList = [];

    for (let i = 0; i < s.length; i++) {
        if (s[i] === ',') {
            sList.push(' ');
        } else {
            sList.push(s[i]);
        }
    }

    sList = sList.join('');
    return sList.split();
}