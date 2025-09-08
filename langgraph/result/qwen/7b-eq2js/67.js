function calculateRemainingFruits(fruitString, totalFruits) {
    let numbers = [];
    for (let item of fruitString.split()) {
        if (!isNaN(item)) {
            numbers.push(parseInt(item));
        }
    }
    let remainingFruits = totalFruits - numbers.reduce((a, b) => a + b, 0);
    return remainingFruits;
}