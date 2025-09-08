function countDivisibleTriples(limit) {
    const sequence = Array.from({ length: limit }, (_, i) => i * i - i + 1);
    let resultCount = 0;

    let indexI = 0;
    while (indexI < limit) {
        let indexJ = indexI + 1;
        while (indexJ < limit) {
            let indexK = indexJ + 1;
            while (indexK < limit) {
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