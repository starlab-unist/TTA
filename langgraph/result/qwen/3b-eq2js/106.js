function generateAlternatingSequence(limit) {
    let result = [];
    let index = 1;
    while (index <= limit) {
        if (index % 2 === 0) {
            let factorial = 1;
            let innerIndex = 1;
            while (innerIndex <= index) {
                factorial *= innerIndex;
                innerIndex++;
            }
            result.push(factorial);
        } else {
            let summation = 0;
            let innerIndex = 1;
            while (innerIndex <= index) {
                summation += innerIndex;
                innerIndex++;
            }
            result.push(summation);
        }
        index++;
    }
    return result;
}