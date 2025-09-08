function generateAlternatingSequence(limit) {
    const result = [];
    let index = 1;
    while (index <= limit) {
        if (index % 2 === 0) {
            let factorial = 1;
            let innerIndex = 1;
            while (innerIndex <= index) {
                factorial *= innerIndex;
                innerIndex += 1;
            }
            result.push(factorial);
        } else {
            let summation = 0;
            let innerIndex = 1;
            while (innerIndex <= index) {
                summation += innerIndex;
                innerIndex += 1;
            }
            result.push(summation);
        }
        index += 1;
    }
    return result;
}