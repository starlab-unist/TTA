function findLongestString(strings) {
    if (!strings || strings.length === 0) {
        return null;
    }

    let maxLength = Math.max(...strings.map(s => s.length));
    for (let element of strings) {
        if (element.length === maxLength) {
            return element;
        }
    }
}