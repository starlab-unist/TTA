function countDivisibleTriples(limit) {
    const sequence = Array.from({ length: limit }, (_, x) => x * x - x + 1);
    let resultCount = 0;
    
    let indexI = 0;
    while (indexI < limit) {
        let indexJ = indexI + 1;
        while (indexJ < limit) {
            let indexK = indexJ + 1;
            while (indexK < limit) {
                if ((sequence[indexI] + sequence[indexJ] + sequence[indexK]) % 3 === 0) {
                    resultCount += 1;
                }
                indexK += 1;
            }
            indexJ += 1;
        }
        indexI += 1;
    }
    
    return resultCount;
}