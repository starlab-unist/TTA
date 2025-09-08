function checkForZeroSumTriplets(numbers) {
    const length = numbers.length;
    let indexI = 0;

    while (indexI < length) {
        let indexJ = indexI + 1;
        while (indexJ < length) {
            let indexK = indexJ + 1;
            while (indexK < length) {
                if (numbers[indexI] + numbers[indexJ] + numbers[indexK] === 0) {
                    return true;
                }
                indexK++;
            }
            indexJ++;
        }
        indexI++;
    }

    return false;
}