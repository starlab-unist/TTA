function processText(s) {
    if (!s) {
        return [];
    }

    let sList = [];

    let index = 0;
    while (index < s.length) {
        let char = s[index];
        if (char === ',') {
            sList.push(' ');
        } else {
            sList.push(char);
        }
        index += 1;
    }

    let processedString = sList.join('');
    return processedString.split();
}