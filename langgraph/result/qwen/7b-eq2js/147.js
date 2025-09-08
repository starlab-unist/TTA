function countDivisibleTriples(n) {
    let sequence = [];
    for (let x = 1; x <= n; x++) {
        sequence.push(x * x - x + 1);
    }
    
    let resultCount = 0;
    
    let indexI = 0;
    while (indexI < n) {
        let indexJ = indexI + 1;
        while (indexJ < n) {
            let indexK = indexJ + 1;
            while (indexK < n) {
                if ((sequence[indexI] + sequence[indexJ] + sequence[indexK]) % 3 === 0) {
                    resultCount++;
                }
                indexK++;
            }
            indexJ++;
        }
        indexI++;
    }
    
    return resultCount;
}

// function name: countDivisibleTriples
// parameter name: n
// array name: sequence
// result storage: resultCount
// replaced nested for loops with while loops
// removed the array push and used a counter instead