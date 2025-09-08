function countOccurrences(mainStr, subStr) {
    let occurrenceCount = 0;
    let index = 0;

    while (index <= mainStr.length - subStr.length) {
        if (mainStr.substring(index, index + subStr.length) === subStr) {
            occurrenceCount++;
        }
        index++;
    }

    return occurrenceCount;
}