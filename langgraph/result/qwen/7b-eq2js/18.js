function countOccurrences(mainStr, subStr) {
    let occurrenceCount = 0;
    let index = 0;

    while (index <= mainStr.length - subStr.length) {
        if (mainStr.slice(index, index + subStr.length) === subStr) {
            occurrenceCount += 1;
        }
        index += 1;
    }

    return occurrenceCount;
}

// method name: howManyTimes -> countOccurrences
// parameter name: string -> mainStr, substring -> subStr
// variable name: times -> occurrenceCount, i -> index
// replaced for loop with while loop
// adjusted the condition in the while loop for clarity