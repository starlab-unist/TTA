function calculateRemainingFruits(fruitString, totalFruits) {
    const numbers = [];
    for (const item of fruitString.split()) {
        if (!isNaN(item)) {
            numbers.push(parseInt(item, 10));
        }
    }
    const remainingFruits = totalFruits - numbers.reduce((sum, num) => sum + num, 0);
    return remainingFruits;
}