function wordsString(s) {
    if (!s) {
        return [];
    }

    let sList = [];

    for (let letter of s) {
        if (letter === ',') {
            sList.push(' ');
        } else {
            sList.push(letter);
        }
    }

    sList = sList.join('');
    return sList.split(/\s+/).filter(word => word.length > 0);
}