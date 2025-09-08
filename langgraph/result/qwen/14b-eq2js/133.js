function calculateTotalSquaredCeilings(numbers) {
    const math = Math;
    let total = 0;
    const iterator = numbers[Symbol.iterator]();
    while (true) {
        try {
            const number = iterator.next().value;
            if (number === undefined) {
                break;
            }
            total += math.ceil(number) ** 2;
        } catch (e) {
            break;
        }
    }
    return total;
}