function calculateTotalSquaredCeilings(lst) {
    const math = require('mathjs');
    let total = 0;
    let iterator = lst[Symbol.iterator]();
    while (true) {
        try {
            let number = iterator.next().value;
            if (number === undefined) break;
            total += Math.pow(math.ceil(number), 2);
        } catch (e) {
            break;
        }
    }
    return total;
}