function calculateRemainingFruits(fruitString, totalFruits) {
    const numbers = [];
    const items = fruitString.split();
    for (const item of items) {
        if (!isNaN(item)) {
            numbers.push(parseInt(item));
        }
    }
    const remainingFruits = totalFruits - numbers.reduce((sum, num) => sum + num, 0);
    return remainingFruits;
}