function findLongestString(stringList) {
    if (!stringList.length) {
        return null;
    }

    const maxLength = Math.max(...stringList.map(item => item.length));
    for (const element of stringList) {
        if (element.length === maxLength) {
            return element;
        }
    }
}