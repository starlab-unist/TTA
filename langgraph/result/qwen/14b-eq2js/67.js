function calculateRemainingFruits(fruitString, totalFruits) {
    const numbers = [];
    fruitString.split().forEach(item => {
        if (!isNaN(item)) {
            numbers.push(parseInt(item));
        }
    });
    const remainingFruits = totalFruits - numbers.reduce((acc, num) => acc + num, 0);
    return remainingFruits;
}