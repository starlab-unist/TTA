function findLongestString(stringList) {
    if (!stringList || stringList.length === 0) {
        return null;
    }

    const maxLength = Math.max(...stringList.map(item => item.length));
    for (const element of stringList) {
        if (element.length === maxLength) {
            return element;
        }
    }
}