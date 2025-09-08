function rollingMax(numbers) {
    let runningMax = null;
    const result = [];

    for (let n of numbers) {
        if (runningMax === null) {
            runningMax = n;
        } else {
            runningMax = Math.max(runningMax, n);
        }

        result.push(runningMax);
    }

    return result;
}