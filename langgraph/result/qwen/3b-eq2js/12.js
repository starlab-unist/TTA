function findLongestString(stringList) {
    if (!stringList || stringList.length === 0) {
        return null;
    }

    let maxLength = Math.max(...stringList.map(item => item.length));
    for (let element of stringList) {
        if (element.length === maxLength) {
            return element;
        }
    }
}