function calculateTotalSquaredCeilings(numbers) {
    let total = 0;
    let iterator = numbers[Symbol.iterator]();
    while (true) {
        let result = iterator.next();
        if (result.done) {
            break;
        }
        let number = result.value;
        total += Math.ceil(number) ** 2;
    }
    return total;
}