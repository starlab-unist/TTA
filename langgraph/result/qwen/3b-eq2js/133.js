function calculateTotalSquaredCeilings(numbers) {
    let total = 0;
    const iterator = numbers[Symbol.iterator]();
    while (true) {
        try {
            const number = iterator.next().value;
            total += Math.ceil(number) ** 2;
        } catch (e) {
            if (e instanceof StopIteration) {
                break;
            }
            throw e;
        }
    }
    return total;
}